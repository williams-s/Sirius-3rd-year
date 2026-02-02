import {Player} from "./classes/Player";
import {BallEvent} from "./types/generated/BallEvent";
import {
    FIELD_HEIGHT,
    FIELD_WIDTH,
    getOptionsForPosition,
    GOAL_END_Y,
    GOAL_START_Y,
    SUCCESS_RATES,
    TeamSimulate
} from "./Constants";
import {PositionEnum} from "./enums/generated/PositionEnum";
import {MqttPublish} from "./classes/MqttPublish";
import {EventTypeEnum} from "./enums/generated/EventTypeEnum";
import {getPlacementByPosition} from "./Positions";
import {MatchStateEnum} from "./enums/generated/MatchStateEnum";
import {TeamScore} from "./types/generated/TeamScore";
import {Score} from "./types/generated/Score";


const MQTT_BROKER = "172.31.249.162:1883"


const TEAM_A = "PSG";
const TEAM_B = "OM";
const TEAM_A_ID = 1;
const TEAM_B_ID = 2;


class SimulateMatch {
    public teamA : TeamSimulate;
    public teamB : TeamSimulate;
    private ball : BallEvent;
    private ballOwner : Player;
    private currentCarryStreak : number;
    private lastPasser : Player;
    private matchId : number;
    private mqttPublish : MqttPublish;
    private matchTime : number;
    private matchTime90minutes : number;
    public running : boolean;
    public score: Score;

    constructor(teamA : TeamSimulate, teamB : TeamSimulate, ball : BallEvent, mqttPublish : MqttPublish, matchId : number) {
        this.mqttPublish = mqttPublish;
        this.running = false;
        this.matchId = matchId;
        /*this.teamA = {
            team_id : TEAM_A_ID,
            name : TEAM_A,
            players : this.initPlayers("LEFT", TEAM_A, 11 ,1),
            side : "LEFT",
            score : 0
        };
        this.teamB = {
            team_id : TEAM_B_ID,
            name : TEAM_B,
            players: this.initPlayers("RIGHT", TEAM_B, 11, 12),
            side : "RIGHT",
            score : 0
        };*/

        //console.log(this.teamA.players);
        //console.log(this.teamB.players);

        this.teamA = teamA;
        this.teamB = teamB;

        this.ball = ball; //{x: FIELD_WIDTH / 2, y: FIELD_HEIGHT / 2, z: 0, speed: 0};
        this.ballOwner = null;

        this.matchTime = 0;
        this.matchTime90minutes = 0;
        this.lastPasser = null;
        this.currentCarryStreak = 0;

        let scoreTeamA : TeamScore = {
            teamId: this.teamA.teamId,
            name: this.teamA.name,
            score: 0
        };

        let scoreTeamB : TeamScore = {
            teamId: this.teamB.teamId,
            name: this.teamB.name,
            score: 0
        }

        this.score = {
            homeTeam: scoreTeamA,
            awayTeam: scoreTeamB
        }

    }



    /*initPlayers(side, team, count, idStart = 1, firstHalfPlayers = []) {
        const players = [];
        const positions = getPositionsWithPlacement(side, FIELD_WIDTH, FIELD_HEIGHT);
        let id = idStart;
        if (firstHalfPlayers.length > 0) {
            for (let i = 0; i < firstHalfPlayers.length; i++) {
                const player = firstHalfPlayers[i];
                const positionWithPlacement = positions[i];
                const position = positionWithPlacement.position;
                players.push({
                    id: id,
                    team: team,
                    side: side,
                    position: position,
                    x: positionWithPlacement.x,
                    y: positionWithPlacement.y,
                    stamina: player.stamina,
                    heartRate: player.heartRate,
                    temperature: player.temperature,
                    distanceCovered: 0,
                    hasBall: false,
                    carryStreak: 0
                })
                id++;
            }
        }
        else {
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
                    heartRate: 70 + Math.floor(Math.random() * 20),
                    temperature: 36.5 + Math.random() * 0.5,
                    distanceCovered: 0,
                    hasBall: false,
                    carryStreak: 0
                });
                id++;
            }
        }
        return players;
    }*/


    getOpponentGoalCoords(player: Player){
        const team = this.getTeamFromPlayer(player);
        return team.side === "LEFT" ? {x: FIELD_WIDTH, y: FIELD_HEIGHT/2} : {x: 0, y: FIELD_HEIGHT/2};
    }

    getShotProbabilityByPosition(player: Player) {
        const opponentGoalX = this.getOpponentGoalCoords(player).x;
        const distanceToGoal = Math.abs(player.getPlayerPosition().playerCoordinates.x - opponentGoalX);

        let shotProba : number = 0;

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

    chooseAction(player : Player) : {action : string, probability : number, to_position? : string} {
        let options = [...getOptionsForPosition(player.getPlayerPosition().position)];

        const shotProba = this.getShotProbabilityByPosition(player);
        options.push({action: "shot", probability: shotProba});

        const minDist = this.findClosestOpponent(player).distance;

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

    findClosestOpponent(player : Player) {
        const opponentTeam = player.getTeamId() === this.teamA.teamId ? this.teamB.players : this.teamA.players;
        let closest : Player = null;
        let minDist = Infinity;
        const playerCoords = player.getPlayerPosition().playerCoordinates;
        for (let opponent of opponentTeam) {
            const opponentCoords = opponent.getPlayerPosition().playerCoordinates;
            const dist = Math.sqrt((playerCoords.x - opponentCoords.x) ** 2 + (playerCoords.y - opponentCoords.y) ** 2);
            if (dist < minDist) {
                minDist = dist;
                closest = opponent;
            }
        }
        return {
            opponent: closest,
            distance: minDist
        }
        //return [closest, minDist];
    }

    findTeammateByPosition(player : Player, targetPosition : string) {
        const teammates = player.getTeamId() === this.teamA.teamId ? this.teamA.players : this.teamB.players;
        let candidates = teammates.filter(p => p.getPlayerPosition().position === targetPosition && p.getPlayerId() !== player.getPlayerId());

        if (candidates.length === 0) {
            candidates = teammates.filter(p => p.getPlayerId() !== player.getPlayerId());
        }

        return candidates.length > 0 ? candidates[Math.floor(Math.random() * candidates.length)] : null;
    }

    executeAction(player : Player, action : {action : string, probability : number, to_position? : string}) {
        const position = player.getPlayerPosition().position;
        const actionType = action.action;

        const successRate = (SUCCESS_RATES[position] && SUCCESS_RATES[position][actionType]) || 0.5;
        const success = Math.random() < successRate;

        /*const result = {
            player: player,
            action: actionType,
            success: success,
            timestamp: new Date().toISOString()
        };*/

        if (actionType === "pass") {
            this.currentCarryStreak = 0;

            const targetPos = action.to_position || "MIDFIELDER";
            const targetPlayer = this.findTeammateByPosition(player, targetPos);

            if (targetPlayer && success) {
                this.ball.ballCoordinates.x = targetPlayer.getPlayerPosition().playerCoordinates.x + Math.random() * 4 - 2;
                this.ball.ballCoordinates.y = targetPlayer.getPlayerPosition().playerCoordinates.y + Math.random() * 4 - 2;
                this.ballOwner = targetPlayer;
                //result.target = targetPlayer;
                this.mqttPublish.publishActionEvent(player, EventTypeEnum.PASS_SUCCESS, this.matchId, true);
                this.lastPasser = player;
            } else {
                const opponent = this.findClosestOpponent(player).opponent;
                this.ballOwner = opponent;
                //result.intercepted_by = opponent;
                this.mqttPublish.publishActionEvent(player, EventTypeEnum.PASS_FAILED, this.matchId, false);
                this.mqttPublish.publishActionEvent(opponent, EventTypeEnum.INTERCEPTION, this.matchId, false);
                this.lastPasser = null;
            }
        } else if (actionType === "carry") {
            this.currentCarryStreak++;

            if (success) {
                const direction = player.getPlayerId() === this.teamA.teamId ? 1 : -1;

                const speedBonus = Math.min(this.currentCarryStreak * 0.5, 3);
                const baseDistance = 2 + speedBonus;

                const playerCoords = player.getPlayerPosition().playerCoordinates;

                playerCoords.x += direction * (baseDistance + Math.random() * 2);
                playerCoords.y += Math.random() * 3 - 1.5;

                playerCoords.x = Math.max(0, Math.min(FIELD_WIDTH, playerCoords.x));
                playerCoords.y = Math.max(0, Math.min(FIELD_HEIGHT, playerCoords.y));

                this.ball.ballCoordinates.x = playerCoords.x;
                this.ball.ballCoordinates.y = playerCoords.y;

                player.getPlayerPosition().distanceCovered = 2 + speedBonus;
                player.getPlayerHealth().heartRate = Math.min(190, player.getPlayerHealth().heartRate + this.currentCarryStreak * 2);
                player.getPlayerHealth().stamina = Math.max(0, player.getPlayerHealth().stamina - (0.3 + this.currentCarryStreak * 0.1));

                this.mqttPublish.publishActionEvent(player, EventTypeEnum.CARRY_SUCCESS, this.matchId, true);
            } else {
                this.currentCarryStreak = 0;

                //const direction = player.getTeamId() === this.teamA.teamId ? 1 : -1;
                //this.ball.ballCoordinates.x = player.getPlayerPosition().playerCoordinates.x + direction * 3;
                //this.ball.ballCoordinates.y = Math.random() < 0.5 ? 0 : FIELD_HEIGHT;

                const opponent = this.findClosestOpponent(player).opponent;
                this.ballOwner = opponent;
                this.ball.ballCoordinates.x = opponent.getPlayerPosition().playerCoordinates.x;
                this.ball.ballCoordinates.y = opponent.getPlayerPosition().playerCoordinates.y;
                this.mqttPublish.publishActionEvent(player, EventTypeEnum.CARRY_FAILED, this.matchId, false);
                this.lastPasser = null;
            }
        } else if (actionType === "dribble") {
            this.currentCarryStreak = 0;
            const opponent = this.findClosestOpponent(player).opponent;
            if (success) {
                const playerCoords = player.getPlayerPosition().playerCoordinates;
                const direction = this.getTeamFromPlayer(player).side === "LEFT" ? 1 : -1;
                playerCoords.x += direction * (Math.random() * 4 + 3);
                playerCoords.y += Math.random() * 6 - 3;
                this.ball.ballCoordinates.x = playerCoords.x;
                this.ball.ballCoordinates.y = playerCoords.y;
                this.mqttPublish.publishActionEvent(player, EventTypeEnum.DRIBBLE_SUCCESS, this.matchId, true);
                this.mqttPublish.publishActionEvent(opponent, EventTypeEnum.TACKLE_FAILED, this.matchId, false);
            } else {
                this.ballOwner = opponent;
                //result.tackled_by = opponent;
                this.mqttPublish.publishActionEvent(player, EventTypeEnum.DRIBBLE_FAILED, this.matchId, false);
                this.mqttPublish.publishActionEvent(opponent, EventTypeEnum.TACKLE_SUCCESS, this.matchId, false);
                this.lastPasser = null;
            }
        } else if (actionType === "shot") {
            this.currentCarryStreak = 0;
            const opponentGoalCoords = this.getOpponentGoalCoords(player);
            const opponentTeam = player.getTeamId() === this.teamA.teamId ? this.teamB.players : this.teamA.players;
            const goalkeeper = opponentTeam.find(p => p.getPlayerPosition().position === PositionEnum.GOALKEEPER);

            const shotOnTarget = Math.random() < 0.7;

            if (!shotOnTarget) {
                this.ball.ballCoordinates.x = opponentGoalCoords.x;
                const useTopZone = Math.random() < 0.5;
                if (useTopZone) {
                    this.ball.ballCoordinates.y = Math.random() * GOAL_START_Y;
                } else {
                    this.ball.ballCoordinates.y = GOAL_END_Y + Math.random() * (FIELD_HEIGHT - GOAL_END_Y);
                }
                this.mqttPublish.publishActionEvent(player, EventTypeEnum.SHOT_MISS, this.matchId, false);
                this.ballOwner = goalkeeper;
                this.lastPasser = null;
            } else {
                this.ball.ballCoordinates.x = opponentGoalCoords.x;
                this.ball.ballCoordinates.y = opponentGoalCoords.y;
                this.mqttPublish.publishActionEvent(player, EventTypeEnum.SHOT_ON_TARGET, this.matchId, false);
                if (success && goalkeeper) {
                    //this.getTeamFromPlayer(player).score++;
                    let teamThatScored = this.getTeamFromPlayer(player);
                    this.score.awayTeam.teamId === teamThatScored.teamId ? this.score.awayTeam.score++ : this.score.homeTeam.score++;
                    this.mqttPublish.publishGoalEvent(player, this.matchId, this.matchTime90minutes, this.score, this.lastPasser);
                    this.resetBall();
                } else {
                    this.mqttPublish.publishActionEvent(goalkeeper, EventTypeEnum.SHOT_SAVED, this.matchId, false);
                    this.ballOwner = goalkeeper;
                    this.lastPasser = null;
                }
            }
        }
        //return result;
    }

    getTeamFromPlayer(player : Player) {
        return this.teamA.players.includes(player) ? this.teamA : this.teamB;
    }



    /*getScore () {
        const homeTeam = {
            team_id: this.teamA.team_id,
            name: this.teamA.name,
            score: this.teamA.score,
        }

        const awayTeam = {
            team_id: this.teamB.team_id,
            name: this.teamB.name,
            score: this.teamB.score,
        }
        return {
            homeTeam,
            awayTeam
        }
    }*/

    updatePlayerPosition(player: Player, deltaTimeMs: number) {
        if (player.getPlayerPosition().hasBall) return;

        const dt = deltaTimeMs / 1000;
        const pos = player.getPlayerPosition();
        const side = this.getTeamFromPlayer(player).side;

        let moveX = 0;
        let moveY = 0;

        if (pos.position === PositionEnum.GOALKEEPER) {
            const speed = 3;
            const direction = this.ball.ballCoordinates.x > FIELD_WIDTH / 2 ? 1 : -1;
            moveX = speed * dt * (side === "LEFT" ? direction : -direction);
        } else {
            const dx = this.ball.ballCoordinates.x - pos.playerCoordinates.x;
            const dy = this.ball.ballCoordinates.y - pos.playerCoordinates.y;
            const distance = Math.sqrt(dx ** 2 + dy ** 2);

            if (distance > 0.01) {
                const speed = 5;
                const rand = Math.random() * 0.5 + 0.75;

                moveX = (dx / distance) * speed * rand * dt;
                moveY = (dy / distance) * speed * rand * dt;
            }
        }

        pos.playerCoordinates.x = Math.max(3, Math.min(FIELD_WIDTH-3, pos.playerCoordinates.x + moveX));
        pos.playerCoordinates.y = Math.max(0, Math.min(FIELD_HEIGHT, pos.playerCoordinates.y + moveY));

        pos.distanceCovered = Math.sqrt(moveX ** 2 + moveY ** 2);
    }

    updatePlayerHealth(player : Player) {
        const playerPosition = player.getPlayerPosition();
        const playerHealth = player.getPlayerHealth();
        if (playerPosition.distanceCovered > 1) {
            playerHealth.stamina = Math.max(0, playerHealth.stamina - (Math.random() * 0.2 + 0.1));
        } else {
            playerHealth.stamina = Math.min(100, playerHealth.stamina + (Math.random() * 0.1 + 0.05));
        }

        const baseHr = 70 + (100 - playerHealth.stamina) * 1.2;
        playerHealth.heartRate = Math.floor(baseHr + Math.random() * 10 - 5);
        playerHealth.temperature = 36.5 + (100 - playerHealth.stamina) * 0.015 + Math.random() * 0.2 - 0.1;
    }

    updateBallPossession() {
        if (!this.ballOwner) {
            const allPlayers = [...this.teamA.players, ...this.teamB.players];
            let closest = null;
            let minDist = Infinity;

            for (let player of allPlayers) {
                const dist = Math.sqrt((player.getPlayerPosition().playerCoordinates.x - this.ball.ballCoordinates.x) ** 2 + (player.getPlayerPosition().playerCoordinates.y - this.ball.ballCoordinates.y) ** 2);
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
                p.getPlayerPosition().hasBall = false;
            }

            if (this.ballOwner) {
                this.ballOwner.getPlayerPosition().hasBall = true;
            }
        }
    }

    resetBall() {
        this.ball.ballCoordinates = {x: FIELD_WIDTH / 2, y: FIELD_HEIGHT / 2, z: 0};
        this.ballOwner = null;
        this.currentCarryStreak = 0;
    }

    kickoff() {

        let playersToKickOff = this.teamA.players.filter(p => !p.getPlayerPosition().position.includes("BACK") && p.getPlayerPosition().position !== "GOALKEEPER");
        const player1 = playersToKickOff[Math.floor(Math.random() * playersToKickOff.length)];
        playersToKickOff = playersToKickOff.filter(p => p !== player1);
        const player2 = playersToKickOff[Math.floor(Math.random() * playersToKickOff.length)];

        player1.getPlayerPosition().playerCoordinates.x = FIELD_WIDTH / 2;
        player1.getPlayerPosition().playerCoordinates.y = FIELD_HEIGHT / 2;
        player2.getPlayerPosition().playerCoordinates.x = FIELD_WIDTH / 2 + Math.random() * 6 - 3;
        player2.getPlayerPosition().playerCoordinates.y = FIELD_HEIGHT / 2 + Math.random() * 6 - 3;

        this.ball.ballCoordinates = {x: FIELD_WIDTH / 2, y: FIELD_HEIGHT / 2, z: 0};

        console.log(`Coup d'envoi! ${player1.getPlayerId()} passe à ${player2.getPlayerId()}`);

        this.ball.ballCoordinates.x = player2.getPlayerPosition().playerCoordinates.x + Math.random() - 0.5;
        this.ball.ballCoordinates.y = player2.getPlayerPosition().playerCoordinates.y + Math.random() - 0.5;
        this.ball.ballCoordinates.z = 0.3;
        this.ball.speed = 15;
        this.ballOwner = player2;
    }



    simulateStep() {
        const allPlayers = [...this.teamA.players, ...this.teamB.players];
        for (let player of [...this.teamA.players, ...this.teamB.players]) {
            //this.updatePlayerPosition(player);
            this.updatePlayerHealth(player);
        }

        this.updateBallPossession();

        this.mqttPublish.publishPlayersHealth(allPlayers, this.matchId);
        //this.mqttPublish.publishPlayersPosition(allPlayers, this.matchId);
        this.mqttPublish.publishBallPosition(this.ball, this.matchId);
    }

    secondHalfStart() {
        this.teamA.side = "RIGHT";
        this.teamB.side = "LEFT";
        this.resetPositionOfPlayers([...this.teamA.players, ...this.teamB.players]);
        //this.teamA.players = this.initPlayers("RIGHT", TEAM_A, 11, 1, this.teamA.players);
        //this.teamB.players = this.initPlayers("LEFT", TEAM_B, 11, 12, this.teamB.players);
        this.mqttPublish.publishMatchState(MatchStateEnum.SECOND_HALF_KICK_OFF, this.matchId, this.matchTime90minutes, this.score);
    }

    resetPositionOfPlayers(allPlayers : Player[]) {
        for (const player of allPlayers) {
            const placement = getPlacementByPosition(this.getTeamFromPlayer(player).side,FIELD_WIDTH,FIELD_HEIGHT,player.getPlayerPosition().position)
            player.getPlayerPosition().playerCoordinates.x = placement.x;
            player.getPlayerPosition().playerCoordinates.y = placement.y;
        }
    }

    async startSimulation(duration = 90, actionsPerSecond = 3) {
        console.log(`Début du match! Durée: ${duration} secondes`);
        this.mqttPublish.publishMatchState(MatchStateEnum.KICK_OFF, this.matchId, this.matchTime90minutes,this.score);
        this.kickoff();
        this.running = true;

        while (this.running && this.matchTime < duration) {
            if (this.matchTime === Math.round(duration / 2)) {
                this.mqttPublish.publishMatchState(MatchStateEnum.HALF_TIME, this.matchId, this.matchTime90minutes,this.score);
                console.log(`MI-TEMPS`);
                await new Promise(resolve => setTimeout(resolve, 30000));
                this.secondHalfStart();
            }

            for (let i = 0; i < actionsPerSecond; i++) {
                this.simulateStep();
                await new Promise(resolve => setTimeout(resolve, 1000 / actionsPerSecond));
            }

            this.matchTime++;
            this.matchTime90minutes = Number((this.matchTime / duration * 90).toFixed(2));
            this.mqttPublish.publishMatchState(MatchStateEnum.TIME_UPDATE, this.matchId, this.matchTime90minutes,this.score);
        }
        this.mqttPublish.publishMatchState(MatchStateEnum.FULL_TIME, this.matchId, this.matchTime90minutes,this.score);
        console.log(`\nFin du match!`);
        this.running = false;
    }

  /*  stop() {
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
    }*/
}

export default SimulateMatch

/*const simulator = new SimulateMatch();
simulator.connect().then((connected) => {
    if (connected) {
        try {
            simulator.startSimulation(10, 3);
        } catch (error) {
            console.error("Erreur:", error);
            simulator.stop();
        }
    } else {
        console.log("Impossible de démarrer la simulation");
    }
});*/

