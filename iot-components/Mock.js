const mqtt = require('mqtt');

const args = process.argv.slice(2);
const match_id = args[0];

const TEAM_A = "PSG";
const TEAM_B = "OM";

const OPTIONS_MIDFIELDER = [
    {action: "carry", probability: 4},
    {action: "pass", probability: 3, to_position: "MIDFIELDER"},
    {action: "pass", probability: 1.3, to_position: "FORWARD"},
    {action: "pass", probability: 1.3, to_position: "DEFENDER"},
    {action: "pass", probability: 0.01, to_position: "GOALKEEPER"},
    {action: "dribble", probability: 0.3}
];

const OPTIONS_FORWARD = [
    {action: "carry", probability: 3},
    {action: "pass", probability: 1, to_position: "MIDFIELDER"},
    {action: "pass", probability: 1, to_position: "FORWARD"},
    {action: "pass", probability: 0.009, to_position: "DEFENDER"},
    {action: "dribble", probability: 1.5}
];

const OPTIONS_DEFENDER = [
    {action: "carry", probability: 3},
    {action: "pass", probability: 2.5, to_position: "MIDFIELDER"},
    {action: "pass", probability: 0.1, to_position: "FORWARD"},
    {action: "pass", probability: 1.8, to_position: "DEFENDER"},
    {action: "pass", probability: 0.2, to_position: "GOALKEEPER"},
    {action: "dribble", probability: 0.2}
];

const OPTIONS_GOALKEEPER = [
    {action: "pass", probability: 0.4, to_position: "MIDFIELDER"},
    {action: "pass", probability: 0.05, to_position: "FORWARD"},
    {action: "pass", probability: 1.0, to_position: "DEFENDER"}
];

const SUCCESS_RATES = {
    "MIDFIELDER": {pass: 0.8, dribble: 0.6, carry: 0.95, shot: 0.1, tackle: 0.4},
    "FORWARD": {pass: 0.6, dribble: 0.4, carry: 0.9, shot: 0.25, tackle: 0.2},
    "DEFENDER": {pass: 0.85, dribble: 0.6, carry: 0.95, shot: 0.1, tackle: 0.7},
    "GOALKEEPER": {pass: 0.95, carry: 0.98, save: 0.85}
};

class MockIoTMatch {
    constructor(broker = "mqtt://localhost:1883") {
        this.client = mqtt.connect(broker);
        this.running = false;

        this.fieldWidth = 105;
        this.fieldHeight = 68;
        this.matchId = match_id;
        this.teamA = this.initPlayers(TEAM_A, 11, 20, 1);
        this.teamB = this.initPlayers(TEAM_B, 11, 85, 12);

        this.ball = {x: 52.5, y: 34, z: 0, speed: 0};
        this.ballOwner = null;

        this.score = {};
        this.score[TEAM_A] = 0;
        this.score[TEAM_B] = 0;
        this.matchTime = 0;
    }

    initPlayers(team, count, xStart, idStart = 1) {
        const players = [];
        const positions = ["GOALKEEPER", "DEFENDER", "DEFENDER", "DEFENDER", "DEFENDER",
            "MIDFIELDER", "MIDFIELDER", "MIDFIELDER", "FORWARD", "FORWARD", "FORWARD"];
        let id = idStart;
        for (let i = 0; i < count; i++) {
            const position = i < positions.length ? positions[i] : "MIDFIELDER";
            players.push({
                id: id,
                team: team,
                position: position,
                x: xStart + Math.random() * 20 - 10,
                y: Math.random() * 48 + 10,
                stamina: 100,
                heart_rate: 70 + Math.floor(Math.random() * 20),
                temperature: 36.5 + Math.random() * 0.5,
                speed: 0,
                hasBall: false,
                carryStreak: 0
            });
            id++;
        }
        return players;
    }

    getOptionsForPosition(position) {
        if (position === "MIDFIELDER") return OPTIONS_MIDFIELDER;
        if (position === "FORWARD") return OPTIONS_FORWARD;
        if (position === "DEFENDER") return OPTIONS_DEFENDER;
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
            shotProba = 1.0;
        } else if (distanceToGoal <= 50) {
            shotProba = 0.2;
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
        const opponentTeam = player.team === TEAM_A ? this.teamB : this.teamA;
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
        const teammates = player.team === TEAM_A ? this.teamA : this.teamB;
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
            } else {
                const [opponent, _] = this.findClosestOpponent(player);
                this.ballOwner = opponent;
                result.intercepted_by = opponent;
                this.publishActionEvent(player, "PASS_FAILED", opponent);
                this.publishActionEvent(opponent, "INTERCEPTION", player);
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

                player.speed = 2 + speedBonus;
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
                result.throw_in_by = opponent;

                this.publishActionEvent(player, "CARRY_FAILED", opponent);
            }
        } else if (actionType === "dribble") {
            player.carryStreak = 0;
            const [opponent, _] = this.findClosestOpponent(player);
            if (success) {
                const direction = player.team === TEAM_A ? 1 : -1;
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
            }
        } else if (actionType === "shot") {
            player.carryStreak = 0;

            const opponentTeam = player.team === TEAM_A ? this.teamB : this.teamA;
            const goalkeeper = opponentTeam.find(p => p.position === "GOALKEEPER");

            const shotOnTarget = Math.random() < 0.7;

            if (!shotOnTarget) {
                this.publishActionEvent(player, "SHOT_MISS");
                this.ballOwner = goalkeeper;
            } else {
                this.publishActionEvent(player, "SHOT_ON_TARGET", goalkeeper);
                if (success && goalkeeper) {
                    this.score[player.team]++;
                    this.publishGoalEvent(player, goalkeeper);
                    this.resetBall();
                } else {
                    this.publishActionEvent(goalkeeper, "SHOT_SAVED", player);
                    this.ballOwner = goalkeeper;
                }
            }
        }

        return result;
    }

    updatePlayerPosition(player) {
        if (player.hasBall) return;

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
        player.speed = Math.sqrt(moveX ** 2 + moveY ** 2);
    }

    updatePlayerHealth(player) {
        if (player.speed > 1) {
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
            const allPlayers = [...this.teamA, ...this.teamB];
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

            for (let p of [...this.teamA, ...this.teamB]) {
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

        for (let p of [...this.teamA, ...this.teamB]) {
            p.carryStreak = 0;
        }
    }

    kickoff() {
        const player1 = this.teamA[0];
        const player2 = this.teamA[1];

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
            match_time: this.matchTime
        };

        if (target) {
            data.target_player = target.id;
        }

        this.client.publish("match/events", JSON.stringify(data));
        console.log(`${actionType}: ${player.id} (${player.position})`);
    }

    publishPlayersHealth() {
        const allPlayers = [...this.teamA, ...this.teamB];
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
        const allPlayers = [...this.teamA, ...this.teamB];
        for (let player of allPlayers) {
            const data = {
                match_id: this.matchId,
                player_id: player.id,
                team: player.team,
                timestamp: new Date().toISOString(),
                x: Math.round(player.x * 100) / 100,
                y: Math.round(player.y * 100) / 100,
                speed: Math.round(player.speed * 100) / 100,
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
            match_time: this.matchTime,
            score: {...this.score},
            player_id: player.id,
            goalkeeper_id: goalkeeper.id
        };
        this.client.publish("match/events", JSON.stringify(data));
        const data2 = {
            match_id: this.matchId,
            timestamp: new Date().toISOString(),
            event_type: "SCORE_UPDATE",
            team: team,
            match_time: this.matchTime,
            score: {...this.score}
        }
        this.client.publish("match/state", JSON.stringify(data2));
        console.log(`BUT! ${team} marque! Score: ${this.score[TEAM_A]}-${this.score[TEAM_B]}`);
    }

    publishMatchState(eventType) {
        const data = {
            match_id: this.matchId,
            timestamp: new Date().toISOString(),
            event_type: eventType,
            match_time: this.matchTime,
            score: {...this.score}
        };
        this.client.publish("match/state", JSON.stringify(data));
    }

    simulateStep() {
        for (let player of [...this.teamA, ...this.teamB]) {
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
            for (let i = 0; i < actionsPerSecond; i++) {
                this.simulateStep();
                await new Promise(resolve => setTimeout(resolve, 1000 / actionsPerSecond));
            }
            this.matchTime++;
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
            simulator.startSimulation(90, 5);
        } catch (error) {
            console.error("Erreur:", error);
            simulator.stop();
        }
    } else {
        console.log("Impossible de démarrer la simulation");
    }
});

module.exports = {MockIoTMatch};