const mqtt = require('mqtt');
const {OPTIONS_MIDFIELDER,OPTIONS_DEFENDER,OPTIONS_FORWARD, OPTIONS_GOALKEEPER, SUCCESS_RATES} = require("./Constants");
const {getPositionsWithPlacement} = require("./Positions");

const args = process.argv.slice(2);
const match_id = args[0];

const TEAM_A = "PSG";
const TEAM_B = "OM";


class MockIoTMatch {
    constructor(broker = "mqtt://localhost:1883") {
        this.client = mqtt.connect(broker);
        this.running = false;

        this.fieldWidth = 105;
        this.fieldHeight = 68;
        this.matchId = match_id;
        this.teamA = {
            name : TEAM_A,
            players : this.initPlayers("LEFT", TEAM_A, 11 ,1),
            side : "LEFT"
        };
        this.teamB = {
            name : TEAM_B,
            players: this.initPlayers("RIGHT", TEAM_B, 11, 12),
            side : "RIGHT"
        };

        console.log(this.teamA.players);
        console.log(this.teamB.players);

        this.ball = {x: 52.5, y: 34, z: 0, speed: 0};
        this.ballOwner = null;

        this.score = {};
        this.score[TEAM_A] = 0;
        this.score[TEAM_B] = 0;
        this.matchTime = 0;
        this.matchTime90minutes = 0;
        this.lastPasser = null;
    }



    initPlayers(side, team, count, idStart = 1) {
        const players = [];
        const positions = getPositionsWithPlacement(side, this.fieldWidth, this.fieldHeight);
        let id = idStart;
        for (let i = 0; i < count; i++) {
            const positionWithPlacement = positions[i];
            const position = positionWithPlacement.position;
            players.push({
                id: id,
                team: team,
                side: side,
                position: position,
                x: positionWithPlacement.x,
                y: positionWithPlacement.y,
                stamina: 100,
                heart_rate: 70 + Math.floor(Math.random() * 20),
                temperature: 36.5 + Math.random() * 0.5,
                distanceCovered: 0,
                hasBall: false,
                carryStreak: 0
            });
            id++;
        }
        return players;
    }

    getOptionsForPosition(position) {
        if (position.includes("MIDFIELDER")) return OPTIONS_MIDFIELDER;
        if (position.includes("WING") || position === "STRIKER") return OPTIONS_FORWARD;
        if (position.includes("BACK")) return OPTIONS_DEFENDER;
        if (position === "GOALKEEPER") return OPTIONS_GOALKEEPER;
        return OPTIONS_MIDFIELDER;
    }

    getShotProbabilityByPosition(player) {
        const opponentGoalX = player.team === TEAM_A ? this.fieldWidth : 0;
        const distanceToGoal = Math.abs(player.x - opponentGoalX);

        let shotProba;

        if (distanceToGoal <= 20) {
            shotProba = 3.0;
        } else if (distanceToGoal <= 35) {
            shotProba = 0.4;
        } else if (distanceToGoal <= 50) {
            shotProba = 0.08;
        } else {
            shotProba = 0.05;
        }

        return shotProba;
    }

    chooseAction(player) {
        let options = [...this.getOptionsForPosition(player.position)];

        const shotProba = this.getShotProbabilityByPosition(player);
        options.push({action: "shot", probability: shotProba});

        const [_, minDist] = this.findClosestOpponent(player);

        if (minDist <= 2) {
            options = options.filter(opt => opt.action !== "carry");
        } else {
            options = options.filter(opt => opt.action !== "dribble");
            options = options.map(opt => {
                if (opt.action === "carry") {
                    return {...opt, probability: opt.probability * 1.5};
                }
                return opt;
            });
        }

        const totalProb = options.reduce((sum, opt) => sum + opt.probability, 0);
        const rand = Math.random() * totalProb;

        let cumulative = 0;
        for (let option of options) {
            cumulative += option.probability;
            if (rand <= cumulative) {
                return option;
            }
        }

        return options[0];
    }

    findClosestOpponent(player) {
        const opponentTeam = player.team === TEAM_A ? this.teamB.players : this.teamA.players;
        let closest = null;
        let minDist = Infinity;

        for (let opponent of opponentTeam) {
            const dist = Math.sqrt((player.x - opponent.x) ** 2 + (player.y - opponent.y) ** 2);
            if (dist < minDist) {
                minDist = dist;
                closest = opponent;
            }
        }

        return [closest, minDist];
    }

    findTeammateByPosition(player, targetPosition) {
        const teammates = player.team === TEAM_A ? this.teamA.players : this.teamB.players;
        let candidates = teammates.filter(p => p.position === targetPosition && p.id !== player.id);

        if (candidates.length === 0) {
            candidates = teammates.filter(p => p.id !== player.id);
        }

        return candidates.length > 0 ? candidates[Math.floor(Math.random() * candidates.length)] : null;
    }

    executeAction(player, action) {
        const position = player.position;
        const actionType = action.action;

        const successRate = (SUCCESS_RATES[position] && SUCCESS_RATES[position][actionType]) || 0.5;
        const success = Math.random() < successRate;

        const result = {
            player: player,
            action: actionType,
            success: success,
            timestamp: new Date().toISOString()
        };

        if (actionType === "pass") {
            player.carryStreak = 0;

            const targetPos = action.to_position || "MIDFIELDER";
            const targetPlayer = this.findTeammateByPosition(player, targetPos);

            if (targetPlayer && success) {
                this.ball.x = targetPlayer.x + Math.random() * 4 - 2;
                this.ball.y = targetPlayer.y + Math.random() * 4 - 2;
                this.ballOwner = targetPlayer;
                result.target = targetPlayer;
                this.publishActionEvent(player, "PASS_SUCCESS", targetPlayer);
                this.lastPasser = player;
            } else {
                const [opponent, _] = this.findClosestOpponent(player);
                this.ballOwner = opponent;
                result.intercepted_by = opponent;
                this.publishActionEvent(player, "PASS_FAILED", opponent);
                this.publishActionEvent(opponent, "INTERCEPTION", player);
                this.lastPasser = null;
            }
        } else if (actionType === "carry") {
            player.carryStreak++;

            if (success) {
                const direction = player.team === TEAM_A ? 1 : -1;

                const speedBonus = Math.min(player.carryStreak * 0.5, 3);
                const baseDistance = 2 + speedBonus;

                player.x += direction * (baseDistance + Math.random() * 2);
                player.y += Math.random() * 3 - 1.5;

                player.x = Math.max(0, Math.min(this.fieldWidth, player.x));
                player.y = Math.max(0, Math.min(this.fieldHeight, player.y));

                this.ball.x = player.x;
                this.ball.y = player.y;

                player.distanceCovered = 2 + speedBonus;
                player.heart_rate = Math.min(190, player.heart_rate + player.carryStreak * 2);
                player.stamina = Math.max(0, player.stamina - (0.3 + player.carryStreak * 0.1));

                this.publishActionEvent(player, "CARRY_SUCCESS");
            } else {
                player.carryStreak = 0;

                const direction = player.team === TEAM_A ? 1 : -1;
                this.ball.x = player.x + direction * 3;
                this.ball.y = Math.random() < 0.5 ? 0 : this.fieldHeight;

                const [opponent, _] = this.findClosestOpponent(player);
                this.ballOwner = opponent;

                this.publishActionEvent(player, "CARRY_FAILED", opponent);
                this.lastPasser = null;
            }
        } else if (actionType === "dribble") {
            player.carryStreak = 0;
            const [opponent, _] = this.findClosestOpponent(player);
            if (success) {
                const direction = player.side === "LEFT" ? 1 : -1;
                player.x += direction * (Math.random() * 4 + 3);
                player.y += Math.random() * 6 - 3;
                this.ball.x = player.x;
                this.ball.y = player.y;
                this.publishActionEvent(player, "DRIBBLE_SUCCESS", opponent);
                this.publishActionEvent(opponent, "TACKLE_FAILED", player);
            } else {
                this.ballOwner = opponent;
                result.tackled_by = opponent;
                this.publishActionEvent(player, "DRIBBLE_FAILED", opponent);
                this.publishActionEvent(opponent, "TACKLE_SUCCESS", player);
                this.lastPasser = null;
            }
        } else if (actionType === "shot") {
            player.carryStreak = 0;

            const opponentTeam = player.team === TEAM_A ? this.teamB.players : this.teamA.players;
            const goalkeeper = opponentTeam.find(p => p.position === "GOALKEEPER");

            const shotOnTarget = Math.random() < 0.7;

            if (!shotOnTarget) {
                this.publishActionEvent(player, "SHOT_MISS");
                this.ballOwner = goalkeeper;
                this.lastPasser = null;
            } else {
                this.publishActionEvent(player, "SHOT_ON_TARGET", goalkeeper);
                if (success && goalkeeper) {
                    this.score[player.team]++;
                    this.publishGoalEvent(player, goalkeeper);
                    this.resetBall();
                } else {
                    this.publishActionEvent(goalkeeper, "SHOT_SAVED", player);
                    this.ballOwner = goalkeeper;
                    this.lastPasser = null;
                }
            }
        }

        return result;
    }

    updatePlayerPosition(player) {
        if (player.hasBall) return;
        if (player.position === "GOALKEEPER") {
            const moveX = 0.3;
            //const moveY = 0.2;
            if (this.ball.x > this.fieldWidth / 2) {
                console.log(player, this.ball.x);
                player.x = player.side === "LEFT" ? Math.max(0, Math.min(this.fieldWidth, player.x + moveX)) : Math.max(0, Math.min(this.fieldWidth, player.x - moveX));
                //player.y = player.side === "LEFT" ? Math.max(0, Math.min(this.fieldHeight, player.y + moveY)) : Math.max(0, Math.min(this.fieldHeight, player.y - moveY));
            } else {
                console.log(player, this.ball.x);
                player.x = player.side === "LEFT" ? Math.max(0, Math.min(this.fieldWidth, player.x - moveX)) : Math.max(0, Math.min(this.fieldWidth, player.x + moveX));
                //player.y = player.side === "LEFT" ? Math.max(0, Math.min(this.fieldHeight, player.y - moveX)) : Math.max(0, Math.min(this.fieldHeight, player.y + moveX));
            }
            player.distanceCovered = moveX;
            //player.distanceCovered = Math.sqrt(moveX ** 2 + moveY ** 2);
            return;
        }
        const dx = this.ball.x - player.x;
        const dy = this.ball.y - player.y;
        const distance = Math.sqrt(dx ** 2 + dy ** 2);

        let moveX, moveY;
        if (distance > 5) {
            moveX = (dx / distance) * (Math.random() * 1.5 + 0.5);
            moveY = (dy / distance) * (Math.random() * 1.5 + 0.5);
        } else {
            moveX = Math.random() * 2 - 1;
            moveY = Math.random() * 2 - 1;
        }

        player.x = Math.max(0, Math.min(this.fieldWidth, player.x + moveX));
        player.y = Math.max(0, Math.min(this.fieldHeight, player.y + moveY));
        player.distanceCovered = Math.sqrt(moveX ** 2 + moveY ** 2);
    }

    updatePlayerHealth(player) {
        if (player.distanceCovered > 1) {
            player.stamina = Math.max(0, player.stamina - (Math.random() * 0.2 + 0.1));
        } else {
            player.stamina = Math.min(100, player.stamina + (Math.random() * 0.1 + 0.05));
        }

        const baseHr = 70 + (100 - player.stamina) * 1.2;
        player.heart_rate = Math.floor(baseHr + Math.random() * 10 - 5);
        player.temperature = 36.5 + (100 - player.stamina) * 0.015 + Math.random() * 0.2 - 0.1;
    }

    updateBallPossession() {
        if (!this.ballOwner) {
            const allPlayers = [...this.teamA.players, ...this.teamB.players];
            let closest = null;
            let minDist = Infinity;

            for (let player of allPlayers) {
                const dist = Math.sqrt((player.x - this.ball.x) ** 2 + (player.y - this.ball.y) ** 2);
                if (dist < minDist) {
                    minDist = dist;
                    closest = player;
                }
            }

            if (minDist < 2) {
                this.ballOwner = closest;
                closest.hasBall = true;
            }
        }

        if (this.ballOwner) {
            const action = this.chooseAction(this.ballOwner);
            this.executeAction(this.ballOwner, action);

            for (let p of [...this.teamA.players, ...this.teamB.players]) {
                p.hasBall = false;
            }

            if (this.ballOwner) {
                this.ballOwner.hasBall = true;
            }
        }
    }

    resetBall() {
        this.ball = {x: 52.5, y: 34, z: 0, speed: 0};
        this.ballOwner = null;

        for (let p of [...this.teamA.players, ...this.teamB.players]) {
            p.carryStreak = 0;
        }
    }

    kickoff() {

        let playersToKickOff = this.teamA.players.filter(p => !p.position.includes("BACK") && p.position !== "GOALKEEPER");
        const player1 = playersToKickOff[Math.floor(Math.random() * playersToKickOff.length)];
        playersToKickOff = playersToKickOff.filter(p => p !== player1);
        const player2 = playersToKickOff[Math.floor(Math.random() * playersToKickOff.length)];

        player1.x = 52.5;
        player1.y = 34;
        player2.x = 55;
        player2.y = 34 + Math.random() * 6 - 3;

        this.ball.x = 52.5;
        this.ball.y = 34;

        console.log(`Coup d'envoi! ${player1.id} passe à ${player2.id}`);

        this.ball.x = player2.x + Math.random() - 0.5;
        this.ball.y = player2.y + Math.random() - 0.5;
        this.ball.z = 0.3;
        this.ball.speed = 15;
        this.ballOwner = player2;
    }

    publishActionEvent(player, actionType, target = null) {
        const data = {
            match_id: this.matchId,
            timestamp: new Date().toISOString(),
            event_type: actionType,
            player_id: player.id,
            team: player.team,
            position: player.position,
        };

        if (target) {
            data.target_player = target.id;
        }

        this.client.publish("match/events", JSON.stringify(data));
        //console.log(`${actionType}: ${player.id} (${player.position})`);
    }

    publishPlayersHealth() {
        const allPlayers = [...this.teamA.players, ...this.teamB.players];
        for (let player of allPlayers) {
            const data = {
                match_id: this.matchId,
                player_id: player.id,
                team: player.team,
                timestamp: new Date().toISOString(),
                stamina: Math.round(player.stamina * 10) / 10,
                heart_rate: player.heart_rate,
                temperature: Math.round(player.temperature * 100) / 100
            };
            this.client.publish("players/health", JSON.stringify(data));
        }
    }

    publishPlayersPosition() {
        const allPlayers = [...this.teamA.players, ...this.teamB.players];
        for (let player of allPlayers) {
            const data = {
                match_id: this.matchId,
                player_id: player.id,
                team: player.team,
                position: player.position,
                timestamp: new Date().toISOString(),
                x: Math.round(player.x * 100) / 100,
                y: Math.round(player.y * 100) / 100,
                distance_covered: Math.round(player.distanceCovered * 100) / 100,
                has_ball: player.hasBall || false
            };
            this.client.publish("players/position", JSON.stringify(data));
        }
    }

    publishBallPosition() {
        const data = {
            match_id: this.matchId,
            timestamp: new Date().toISOString(),
            x: Math.round(this.ball.x * 100) / 100,
            y: Math.round(this.ball.y * 100) / 100,
            z: Math.round(this.ball.z * 100) / 100,
            speed: Math.round(this.ball.speed * 100) / 100,
            owner: this.ballOwner ? this.ballOwner.id : null
        };
        this.client.publish("ball/events", JSON.stringify(data));
    }

    publishGoalEvent(player, goalkeeper) {
        const team = player.team;
        const data = {
            match_id: this.matchId,
            timestamp: new Date().toISOString(),
            event_type: "GOAL",
            team: team,
            score: {...this.score},
            player_id: player.id,
            goalkeeper_id: goalkeeper.id
        };
        this.client.publish("match/events", JSON.stringify(data));
        if (this.lastPasser) {
            const data3 = {
                match_id: this.matchId,
                timestamp: new Date().toISOString(),
                event_type: "ASSIST",
                team: team,
                score: {...this.score},
                player_id: this.lastPasser.id,
            }
            this.client.publish("match/events", JSON.stringify(data3));
        }
        const data2 = {
            match_id: this.matchId,
            timestamp: new Date().toISOString(),
            event_type: "SCORE_UPDATE",
            team: team,
            match_time: this.matchTime90minutes,
            score: {...this.score}
        }
        this.client.publish("match/state", JSON.stringify(data2));
        console.log(`BUT! ${team} marque! Score: ${this.score[TEAM_A]}-${this.score[TEAM_B]}`);
        this.lastPasser = null;
    }

    publishMatchState(eventType) {
        const data = {
            match_id: this.matchId,
            timestamp: new Date().toISOString(),
            event_type: eventType,
            match_time: this.matchTime90minutes,
            score: {...this.score}
        };
        this.client.publish("match/state", JSON.stringify(data));
    }

    simulateStep() {
        for (let player of [...this.teamA.players, ...this.teamB.players]) {
            this.updatePlayerPosition(player);
            this.updatePlayerHealth(player);
        }

        this.updateBallPossession();

        this.publishPlayersHealth();
        this.publishPlayersPosition();
        this.publishBallPosition();
    }

    startSimulation(duration = 90, actionsPerSecond = 3) {
        console.log(`Début du match! Durée: ${duration} secondes`);
        this.publishMatchState("KICK_OFF");
        this.kickoff();
        this.running = true;

        const interval = setInterval(async () => {
            if (!this.running || this.matchTime >= duration) {
                clearInterval(interval);
                this.publishMatchState("FULL_TIME");
                console.log(`\nFin du match! Score final: ${this.score[TEAM_A]}-${this.score[TEAM_B]}`);
                this.stop();
                return;
            }
            if (this.matchTime === Math.round(duration / 2)) {
                this.publishMatchState("HALF_TIME");
                console.log(`Score a la mi temps : ${this.score[TEAM_A]}-${this.score[TEAM_B]}`);
            }
            for (let i = 0; i < actionsPerSecond; i++) {
                this.simulateStep();
                await new Promise(resolve => setTimeout(resolve, 1000 / actionsPerSecond));
            }
            this.matchTime++;
            this.matchTime90minutes = (this.matchTime / duration * 90).toFixed(2);
            this.publishMatchState("TIME_UPDATE");
        }, 1000);
    }

    stop() {
        this.running = false;
        this.client.end();
        console.log("\nStopped");
    }

    connect() {
        return new Promise((resolve) => {
            this.client.on('connect', () => {
                console.log('Connecté au broker MQTT');
                resolve(true);
            });

            this.client.on('error', (err) => {
                console.error(`Erreur de connexion: ${err}`);
                resolve(false);
            });
        });
    }
}

const BROKER = "mqtt://localhost:1883";
const simulator = new MockIoTMatch(BROKER);

simulator.connect().then((connected) => {
    if (connected) {
        try {
            simulator.startSimulation(300, 3);
        } catch (error) {
            console.error("Erreur:", error);
            simulator.stop();
        }
    } else {
        console.log("Impossible de démarrer la simulation");
    }
});

module.exports = {MockIoTMatch};