import {Player} from "./Player";
import {BallEvent} from "../types/generated/BallEvent";
import {
    BallFlight,
    BallFlightType,
    DRIBBLE_RANGE,
    FIELD_HEIGHT,
    FIELD_WIDTH,
    getOptionsForPosition,
    GOAL_END_Y,
    GOAL_START_Y,
    INTERCEPTION_RADIUS, PENALTY_LEFT, PENALTY_RIGHT,
    SUCCESS_RATES,
    TeamSimulate
} from "../utils/Constants";
import {PositionEnum} from "../enums/generated/PositionEnum";
import {MqttPublish} from "./MqttPublish";
import {EventTypeEnum} from "../enums/generated/EventTypeEnum";
import {getPlacementByPosition, getPositionsWithPlacement} from "../utils/Positions";
import {MatchStateEnum} from "../enums/generated/MatchStateEnum";
import {TeamScore} from "../types/generated/TeamScore";
import {Score} from "../types/generated/Score";
import {Coordinates3D} from "../types/generated/Coordinates3D";


class SimulateMatch {
    public teamA: TeamSimulate;
    public teamB: TeamSimulate;
    private ball: BallEvent;
    private ballOwner: Player;
    private currentCarryStreak: number;
    private lastPasser: Player;
    private matchId: number;
    private mqttPublish: MqttPublish;
    private matchTime: number;
    private matchTime90minutes: number;
    public running: boolean;
    public score: Score;
    public matchPause = true;
    public flight: BallFlight = {
        active: false,
        type: BallFlightType.PASS,
        origin: { x: 0, y: 0 },
        target: { x: 0, y: 0 },
        speed: 0,
        pendingOwner: null,
        shooter: null,
        lastPasser: null,
    };
    private ballFlightGoal: boolean = false;

    constructor(teamA: TeamSimulate, teamB: TeamSimulate, ball: BallEvent, mqttPublish: MqttPublish, matchId: number) {
        this.mqttPublish = mqttPublish;
        this.running = false;
        this.matchId = matchId;

        this.teamA = teamA;
        this.teamB = teamB;

        this.ball = ball;
        this.ballOwner = null;

        this.matchTime = 0;
        this.matchTime90minutes = 0;
        this.lastPasser = null;
        this.currentCarryStreak = 0;

        let scoreTeamA: TeamScore = {
            teamId: this.teamA.teamId,
            name: this.teamA.name,
            score: 0,
            side: this.teamA.homeOrAway
        };

        let scoreTeamB: TeamScore = {
            teamId: this.teamB.teamId,
            name: this.teamB.name,
            score: 0,
            side: this.teamB.homeOrAway
        };

        this.score = {
            homeTeam: scoreTeamA.side === "HOME" ? scoreTeamA : scoreTeamB,
            awayTeam: scoreTeamB.side === "AWAY" ? scoreTeamB : scoreTeamA
        };
    }

    private launchBall(type: BallFlightType, target: { x: number; y: number }, speed: number, pendingOwner: Player | null = null, shooter: Player | null = null) {
        this.flight = {
            active: true,
            type,
            origin: { x: this.ball.ballCoordinates.x, y: this.ball.ballCoordinates.y },
            target,
            speed,
            pendingOwner,
            shooter,
            lastPasser: this.lastPasser,
        };
        this.ballOwner = null;
        for (const p of [...this.teamA.players, ...this.teamB.players]) {
            p.getPlayerPosition().hasBall = false;
        }
    }

    async updateBallFlight(deltaTimeMs: number) {
        if (!this.flight.active) return;
        //console.log("ball in flight, pos:", this.ball.ballCoordinates, "target:", this.flight.target);

        const dt = deltaTimeMs / 1000;
        const dx = this.flight.target.x - this.ball.ballCoordinates.x;
        const dy = this.flight.target.y - this.ball.ballCoordinates.y;
        const distanceLeft = Math.sqrt(dx ** 2 + dy ** 2);
        const step = this.flight.speed * dt;

        /*const interceptor = this.checkInterception();
        if (interceptor) {
            this.handleInterception(interceptor);
            return;
        }*/

        if (distanceLeft <= step) {
            this.ball.ballCoordinates.x = this.flight.target.x;
            this.ball.ballCoordinates.y = this.flight.target.y;
            this.ball.speed = 0;
            this.flight.active = false;
            await this.onBallArrived();
        } else {
            this.ball.ballCoordinates.x += (dx / distanceLeft) * step;
            this.ball.ballCoordinates.y += (dy / distanceLeft) * step;
            this.ball.speed = this.flight.speed;
        }
    }

     checkInterception() {
         if (!this.flight.active) return null;

         const shooterOrPasser = this.flight.shooter ?? this.flight.lastPasser;
         const defenders = shooterOrPasser
             ? (shooterOrPasser.getTeamId() === this.teamA.teamId ? this.teamB.players : this.teamA.players)
             : [...this.teamA.players, ...this.teamB.players];

         const pendingId = this.flight.pendingOwner?.getPlayerId();
         const shooterId = this.flight.shooter?.getPlayerId();

         return defenders.find(player => {
             const id = player.getPlayerId();
             if (id === pendingId || id === shooterId) return false;
             const px = player.getPlayerPosition().playerCoordinates.x - this.ball.ballCoordinates.x;
             const py = player.getPlayerPosition().playerCoordinates.y - this.ball.ballCoordinates.y;
             return Math.sqrt(px ** 2 + py ** 2) <= INTERCEPTION_RADIUS;
         }) ?? null;
    }

    handleInterception(interceptor: Player) {
        this.flight.active = false;
        this.ball.ballCoordinates.x = interceptor.getPlayerPosition().playerCoordinates.x;
        this.ball.ballCoordinates.y = interceptor.getPlayerPosition().playerCoordinates.y;
        this.ball.speed = 0;
        this.ballOwner = interceptor;
        interceptor.getPlayerPosition().hasBall = true;
        this.lastPasser = null;
        this.currentCarryStreak = 0;
        this.mqttPublish.publishActionEvent(interceptor, EventTypeEnum.INTERCEPTION, this.matchId, false);
    }

    async onBallArrived() {
        const { type, pendingOwner, shooter, lastPasser } = this.flight;

        if (type === BallFlightType.PASS) {
            this.ballOwner = pendingOwner;
            if (pendingOwner) {
                pendingOwner.getPlayerPosition().hasBall = true;
            }
            this.lastPasser = lastPasser;

        } else if (type === BallFlightType.SHOT) {
            const opponentTeam = shooter
                ? (shooter.getTeamId() === this.teamA.teamId ? this.teamB.players : this.teamA.players)
                : this.teamB.players;
            const goalkeeper = opponentTeam.find(p => p.getPlayerPosition().position === PositionEnum.GOALKEEPER);

            if (this.ballFlightGoal) {
                const teamThatScored = shooter ? this.getTeamFromPlayer(shooter) : this.teamA;
                this.score.awayTeam.teamId === teamThatScored.teamId
                    ? this.score.awayTeam.score++
                    : this.score.homeTeam.score++;
                this.mqttPublish.publishGoalEvent(shooter, this.matchId, this.matchTime90minutes, this.score, lastPasser);
                await this.resetAllPlacements(teamThatScored.teamId === this.teamA.teamId ? this.teamB : this.teamA);
            } else {
                if (pendingOwner && goalkeeper) {
                    this.mqttPublish.publishActionEvent(goalkeeper, EventTypeEnum.SHOT_SAVED, this.matchId, false);
                    this.ballOwner = goalkeeper;
                    goalkeeper.getPlayerPosition().hasBall = true;
                } else {
                    if (goalkeeper) {
                        const team = this.getTeamFromPlayer(goalkeeper);
                        const penaltySpot = team.side === "LEFT" ? PENALTY_LEFT : PENALTY_RIGHT;
                        goalkeeper.getPlayerPosition().playerCoordinates.x = penaltySpot.x;
                        goalkeeper.getPlayerPosition().playerCoordinates.y = penaltySpot.y;
                        await this.resetAllPlacements(team, { ...penaltySpot, z: 0 }, false);
                        goalkeeper.getPlayerPosition().playerCoordinates.x = penaltySpot.x;
                        goalkeeper.getPlayerPosition().playerCoordinates.y = penaltySpot.y;
                        this.ball.ballCoordinates.x = penaltySpot.x;
                        this.ball.ballCoordinates.y = penaltySpot.y;
                        this.ballOwner = goalkeeper;
                        goalkeeper.getPlayerPosition().hasBall = true;
                    }
                }
                this.lastPasser = null;
            }
            this.ballFlightGoal = false;
        }
    }

    getOpponentGoalCoords(player: Player) {
        const team = this.getTeamFromPlayer(player);
        return team.side === "LEFT" ? { x: FIELD_WIDTH, y: FIELD_HEIGHT / 2 } : { x: 0, y: FIELD_HEIGHT / 2 };
    }

    getShotProbabilityByPosition(player: Player) {
        const opponentGoalX = this.getOpponentGoalCoords(player).x;
        const distanceToGoal = Math.abs(player.getPlayerPosition().playerCoordinates.x - opponentGoalX);

        if (distanceToGoal <= 20) return 4.0;
        if (distanceToGoal <= 35) return 0.4;
        if (distanceToGoal <= 50) return 0.08;
        return 0.05;
    }

    chooseAction(player: Player): { action: string; probability: number; to_position?: string } {
        let options = [...getOptionsForPosition(player.getPlayerPosition().position)];

        const shotProba = this.getShotProbabilityByPosition(player);
        options.push({ action: "shot", probability: shotProba });

        const minDist = this.findClosestPlayer(player).distance;

        if (minDist <= DRIBBLE_RANGE) {
            options = options.filter(opt => opt.action !== "carry");
        } else {
            options = options.filter(opt => opt.action !== "dribble");
            options = options.map(opt =>
                opt.action === "carry" ? { ...opt, probability: opt.probability * 1.5 } : opt
            );
        }

        const totalProb = options.reduce((sum, opt) => sum + opt.probability, 0);
        const rand = Math.random() * totalProb;
        let cumulative = 0;
        for (const option of options) {
            cumulative += option.probability;
            if (rand <= cumulative) return option;
        }
        return options[0];
    }

    findClosestPlayer(player: Player, findOpponent = true) {
        const team: Player[] = findOpponent
            ? (player.getTeamId() === this.teamA.teamId ? this.teamB.players : this.teamA.players)
            : (player.getTeamId() === this.teamA.teamId
                ? this.teamA.players.filter(p => p.getPlayerId() !== player.getPlayerId())
                : this.teamB.players.filter(p => p.getPlayerId() !== player.getPlayerId()));

        let closest: Player = null;
        let minDist = Infinity;
        const pc = player.getPlayerPosition().playerCoordinates;

        for (const p of team) {
            const c = p.getPlayerPosition().playerCoordinates;
            const dist = Math.sqrt((pc.x - c.x) ** 2 + (pc.y - c.y) ** 2);
            if (dist < minDist) { minDist = dist; closest = p; }
        }
        return { player: closest, distance: minDist };
    }

    findTeammateByPosition(player: Player, targetPosition: string) {
        const teammates = player.getTeamId() === this.teamA.teamId ? this.teamA.players : this.teamB.players;
        let candidates = teammates.filter(p => p.getPlayerPosition().position === targetPosition && p.getPlayerId() !== player.getPlayerId());
        let teamatesButExluded = teammates.filter(p => p.getPlayerId() !== player.getPlayerId())
        return candidates.length > 0 ? candidates[Math.floor(Math.random() * candidates.length)] : teamatesButExluded[Math.floor(Math.random() * teamatesButExluded.length)];
    }

    executeAction(player: Player, action: { action: string; probability: number; to_position?: string }) {
        const position = player.getPlayerPosition().position;
        const actionType = action.action;
        const successRate = (SUCCESS_RATES[position] && SUCCESS_RATES[position][actionType]) || 0.5;
        const success = Math.random() < successRate;

        if (actionType === "pass") {
            this.currentCarryStreak = 0;
            const targetPos = action.to_position || "MIDFIELDER";
            const targetPlayer = this.findTeammateByPosition(player, targetPos);

            if (targetPlayer && success) {
                const dest = {
                    x: targetPlayer.getPlayerPosition().playerCoordinates.x + Math.random() * 4 - 2,
                    y: targetPlayer.getPlayerPosition().playerCoordinates.y + Math.random() * 4 - 2,
                };
                this.mqttPublish.publishActionEvent(player, EventTypeEnum.PASS_SUCCESS, this.matchId, true);
                this.lastPasser = player;
                this.launchBall(BallFlightType.PASS, dest, 25, targetPlayer);
            } else {
                const opponent = this.findClosestPlayer(player).player;
                this.mqttPublish.publishActionEvent(player, EventTypeEnum.PASS_FAILED, this.matchId, false);
                this.mqttPublish.publishActionEvent(opponent, EventTypeEnum.INTERCEPTION, this.matchId, false);
                this.lastPasser = null;
                if (opponent) {
                    const dest = {
                        x: opponent.getPlayerPosition().playerCoordinates.x + Math.random() * 3 - 1.5,
                        y: opponent.getPlayerPosition().playerCoordinates.y + Math.random() * 3 - 1.5,
                    };
                    this.launchBall(BallFlightType.PASS, dest, 20, opponent);
                }
            }

        } else if (actionType === "carry") {
            this.currentCarryStreak++;

            if (success) {
                const direction = this.getTeamFromPlayer(player).side === "LEFT" ? 1 : -1;
                const speedBonus = Math.min(this.currentCarryStreak * 0.5, 3);
                const baseDistance = 2 + speedBonus;

                const playerCoords = player.getPlayerPosition().playerCoordinates;
                playerCoords.x = Math.max(0, Math.min(FIELD_WIDTH, playerCoords.x + direction * (baseDistance + Math.random() * 2)));
                playerCoords.y = Math.max(0, Math.min(FIELD_HEIGHT, playerCoords.y + Math.random() * 3 - 1.5));

                this.ball.ballCoordinates.x = playerCoords.x;
                this.ball.ballCoordinates.y = playerCoords.y;
                this.ballOwner = player;

                player.getPlayerPosition().distanceCovered = 2 + speedBonus;
                player.getPlayerHealth().heartRate = Math.min(190, player.getPlayerHealth().heartRate + this.currentCarryStreak * 2);
                player.getPlayerHealth().stamina = Math.max(0, player.getPlayerHealth().stamina - (0.3 + this.currentCarryStreak * 0.1));

                this.mqttPublish.publishActionEvent(player, EventTypeEnum.CARRY_SUCCESS, this.matchId, true);
            } else {
                this.currentCarryStreak = 0;
                const closestOpponent = this.findClosestPlayer(player);

                if (closestOpponent.player && closestOpponent.distance <= DRIBBLE_RANGE) {
                    const tackleSuccess = Math.random() < 0.7;
                    if (tackleSuccess) {
                        this.mqttPublish.publishActionEvent(player, EventTypeEnum.CARRY_FAILED, this.matchId, false);
                        this.mqttPublish.publishActionEvent(closestOpponent.player, EventTypeEnum.TACKLE_SUCCESS, this.matchId, false);
                        this.ballOwner = closestOpponent.player;
                        closestOpponent.player.getPlayerPosition().hasBall = true;
                        this.lastPasser = null;
                    }
                }
            }

        } else if (actionType === "dribble") {
            this.currentCarryStreak = 0;
            const opponent = this.findClosestPlayer(player).player;

            if (success) {
                const direction = this.getTeamFromPlayer(player).side === "LEFT" ? 1 : -1;
                const playerCoords = player.getPlayerPosition().playerCoordinates;
                playerCoords.x = Math.max(0, Math.min(FIELD_WIDTH, playerCoords.x + direction * (Math.random() * 4 + 3)));
                playerCoords.y = Math.max(0, Math.min(FIELD_HEIGHT, playerCoords.y + Math.random() * 6 - 3));

                this.ball.ballCoordinates.x = playerCoords.x;
                this.ball.ballCoordinates.y = playerCoords.y;
                this.ballOwner = player;

                this.mqttPublish.publishActionEvent(player, EventTypeEnum.DRIBBLE_SUCCESS, this.matchId, true);
                if (opponent) this.mqttPublish.publishActionEvent(opponent, EventTypeEnum.TACKLE_FAILED, this.matchId, false);
            } else {
                this.mqttPublish.publishActionEvent(player, EventTypeEnum.DRIBBLE_FAILED, this.matchId, false);
                const tackleSuccess = Math.random() < 0.8;
                if (opponent && tackleSuccess) {
                        this.mqttPublish.publishActionEvent(opponent, EventTypeEnum.TACKLE_SUCCESS, this.matchId, false);
                    this.ballOwner = opponent;
                    opponent.getPlayerPosition().hasBall = true;
                } else {
                    if (opponent) this.mqttPublish.publishActionEvent(opponent, EventTypeEnum.TACKLE_FAILED, this.matchId, false);
                    const teammate = this.findTeammateByPosition(player, "MIDFIELDER");
                    if (teammate) {
                        const dest = {
                            x: teammate.getPlayerPosition().playerCoordinates.x + Math.random() * 4 - 2,
                            y: teammate.getPlayerPosition().playerCoordinates.y + Math.random() * 4 - 2,
                        };
                        this.mqttPublish.publishActionEvent(player, EventTypeEnum.PASS_SUCCESS, this.matchId, true);
                        this.lastPasser = player;
                        this.launchBall(BallFlightType.PASS, dest, 25, teammate);
                        return;
                    }
                }
                this.lastPasser = null;
            }

        } else if (actionType === "shot") {
            this.currentCarryStreak = 0;
            const opponentGoalCoords = this.getOpponentGoalCoords(player);
            const opponentTeam = player.getTeamId() === this.teamA.teamId ? this.teamB.players : this.teamA.players;
            const goalkeeper = opponentTeam.find(p => p.getPlayerPosition().position === PositionEnum.GOALKEEPER);
            const shotOnTarget = Math.random() < 0.7;

            if (!shotOnTarget) {
                const missY = Math.random() < 0.5
                    ? Math.random() * GOAL_START_Y
                    : GOAL_END_Y + Math.random() * (FIELD_HEIGHT - GOAL_END_Y);
                this.mqttPublish.publishActionEvent(player, EventTypeEnum.SHOT_MISS, this.matchId, false);
                this.ballFlightGoal = false;
                this.launchBall(BallFlightType.SHOT, { x: opponentGoalCoords.x, y: missY }, 35, null, player);
            } else {
                const shotSuccessRate = (SUCCESS_RATES[position]?.["shot"]) || 0.5;
                this.ballFlightGoal = Math.random() < shotSuccessRate;
                this.mqttPublish.publishActionEvent(player, EventTypeEnum.SHOT_ON_TARGET, this.matchId, false);
                this.launchBall(BallFlightType.SHOT, { x: opponentGoalCoords.x, y: opponentGoalCoords.y }, 35, goalkeeper, player);
            }
        }
    }

    getTeamFromPlayer(player: Player) {
        return this.teamA.players.includes(player) ? this.teamA : this.teamB;
    }

    updatePlayersPositions(players: Player[], deltaTimeMs: number) {
        const dt = deltaTimeMs / 1000;
        let moveX = 0;
        let moveY = 0;

        if (this.ballOwner) {
            const closestMate = this.findClosestPlayer(this.ballOwner, false);
            const closestOpponent = this.findClosestPlayer(this.ballOwner);
            this.moveTowardsTheBall(closestMate.player, dt, moveX, moveY);
            this.moveTowardsTheBall(closestOpponent.player, dt, moveX, moveY);

            const teamMates = players.filter(p =>
                p.getTeamId() === this.ballOwner.getTeamId() &&
                p.getPlayerId() !== closestMate.player.getPlayerId() &&
                p.getPlayerId() !== this.ballOwner.getPlayerId()
            );
            const opponents = players.filter(p =>
                p.getTeamId() !== this.ballOwner.getTeamId() &&
                p.getPlayerId() !== closestOpponent.player.getPlayerId() &&
                p.getPlayerId() !== this.ballOwner.getPlayerId()
            );
            const speed = 3;
            for (const mate of teamMates) {
                this.moveDynamically(mate, this.getTeamFromPlayer(mate).side, true, moveX, moveY, speed, dt);
            }
            for (const opponent of opponents) {
                this.moveDynamically(opponent, this.getTeamFromPlayer(opponent).side, false, moveX, moveY, speed, dt);
            }
        } else {
            if (this.flight.active) {
                //console.log(this.flight);
                const player = this.flight.lastPasser ? this.flight.lastPasser : this.flight.shooter;
                if (!player){
                    for (const player of players) {
                        this.moveTowardsTheBall(player, dt, moveX, moveY);
                    }
                    return;
                }
                let teamMates = players.filter(p =>
                    p.getTeamId() === player.getTeamId() &&
                    p.getPlayerId() !== player.getPlayerId()
                );
                if (this.flight.pendingOwner) {
                    if (teamMates.includes(this.flight.pendingOwner))
                        teamMates = teamMates.filter(p => p.getPlayerId() != this.flight.pendingOwner.getPlayerId())
                }
                const opponents = players.filter(p =>
                    p.getTeamId() !== player.getTeamId() &&
                    p.getPlayerId() !== player.getPlayerId()
                );
                const speed = 3;
                for (const mate of teamMates) {
                    this.moveDynamically(mate, this.getTeamFromPlayer(mate).side, true, moveX, moveY, speed, dt);
                }
                for (const opponent of opponents) {
                    this.moveDynamically(opponent, this.getTeamFromPlayer(opponent).side, false, moveX, moveY, speed, dt);
                }
            } else {
                for (const player of players) {
                    this.moveTowardsTheBall(player, dt, moveX, moveY);
                }
            }
        }
    }

    moveDynamically(player: Player, side: string, teamHasBall: boolean, moveX: number, moveY: number, speed: number, dt: number) {
        const ballIsInLeftSide = this.ball.ballCoordinates.x < FIELD_WIDTH / 2;
        let direction = 1;

        if (side === "LEFT") {
            direction = teamHasBall ? 1 : (ballIsInLeftSide ? -1 : 1);
        } else {
            direction = teamHasBall ? -1 : (ballIsInLeftSide ? -1 : 1);
        }

        moveX = speed * dt * direction;
        this.updateCoords(player, moveX, moveY);
    }

    moveTowardsTheBall(player: Player, dt: number, moveX = 0, moveY = 0) {
        const pos = player.getPlayerPosition();
        if (pos.position === PositionEnum.GOALKEEPER) {
            const speed = 3;
            const direction = this.ball.ballCoordinates.x > FIELD_WIDTH / 2 ? 1 : -1;
            moveX = speed * dt * direction;
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
        this.updateCoords(player, moveX, moveY);
    }

    updateCoords(player: Player, moveX: number, moveY: number) {
        const pos = player.getPlayerPosition();
        const side = this.getTeamFromPlayer(player).side;
        if (pos.position === PositionEnum.GOALKEEPER) {
            pos.playerCoordinates.x = side === "LEFT"
                ? Math.max(3, Math.min(FIELD_WIDTH / 6, pos.playerCoordinates.x + moveX))
                : Math.max(FIELD_WIDTH * 5 / 6, Math.min(FIELD_WIDTH - 3, pos.playerCoordinates.x + moveX));
        } else {
            pos.playerCoordinates.x = Math.max(3, Math.min(FIELD_WIDTH - 3, pos.playerCoordinates.x + moveX));
            pos.playerCoordinates.y = Math.max(0, Math.min(FIELD_HEIGHT, pos.playerCoordinates.y + moveY));
        }
        pos.distanceCovered = Math.sqrt(moveX ** 2 + moveY ** 2);
    }

    updatePlayerHealth(player: Player) {
        const playerPosition = player.getPlayerPosition();
        const playerHealth = player.getPlayerHealth();
        const dist = playerPosition.distanceCovered;

        if (dist > 0.25) {
            playerHealth.stamina = Math.max(0, playerHealth.stamina - (Math.random() * 0.2 + 0.1));
        } else {
            playerHealth.stamina = Math.min(100, playerHealth.stamina + (Math.random() * 0.1 + 0.05));
        }

        const movementHr = dist > 0.25 ? 40 + Math.random() * 20 : Math.random() * 10;
        const fatigueHr = (100 - playerHealth.stamina) * 0.3;
        playerHealth.heartRate = Math.floor(65 + movementHr + fatigueHr + Math.random() * 8 - 4);
        playerHealth.temperature = 36.5 + (100 - playerHealth.stamina) * 0.015 + Math.random() * 0.4 - 0.2;
    }

    updateBallPossession() {
        if (this.flight.active) return;

        if (!this.ballOwner) {
            const allPlayers = [...this.teamA.players, ...this.teamB.players];
            let closest: Player = null;
            let minDist = Infinity;

            for (const player of allPlayers) {
                const dist = Math.sqrt(
                    (player.getPlayerPosition().playerCoordinates.x - this.ball.ballCoordinates.x) ** 2 +
                    (player.getPlayerPosition().playerCoordinates.y - this.ball.ballCoordinates.y) ** 2
                );
                if (dist < minDist) { minDist = dist; closest = player; }
            }

            if (minDist < 2) {
                this.ballOwner = closest;
                closest.getPlayerPosition().hasBall = true;
            }
        }

        if (this.ballOwner) {
            const action = this.chooseAction(this.ballOwner);
            console.log(action);
            this.executeAction(this.ballOwner, action);

            for (const p of [...this.teamA.players, ...this.teamB.players]) {
                p.getPlayerPosition().hasBall = false;
            }
            if (this.ballOwner) {
                this.ballOwner.getPlayerPosition().hasBall = true;
            }
        }
    }

    async resetAllPlacements(teamThatKickoff : TeamSimulate, ballCoords : Coordinates3D = { x: FIELD_WIDTH / 2, y: FIELD_HEIGHT / 2, z: 0 }, kickoff = true) {
        this.matchPause = true;
        this.ball.ballCoordinates = ballCoords;
        this.ball.speed = 0;
        this.ballOwner = null;
        this.flight.active = false;
        this.ballFlightGoal = false;
        this.currentCarryStreak = 0;
        this.lastPasser = null;
        this.resetPositionOfPlayers([...this.teamA.players, ...this.teamB.players]);
        this.mqttPublish.publishBallPosition(this.ball, this.matchId);
        this.mqttPublish.publishPlayersPosition([...this.teamA.players, ...this.teamB.players], this.matchId);
        console.log('Reseting positions');
        await new Promise(resolve => setTimeout(resolve, 5000));
        if (kickoff)
            this.kickoff(teamThatKickoff);
        else
            this.matchPause = false;
    }

    kickoff(team : TeamSimulate = null) {
        this.matchPause = false;
        let playersToKickOff : Player[];
        if (!team){
            playersToKickOff = this.teamA.players.filter(p =>
                !p.getPlayerPosition().position.includes("BACK") && p.getPlayerPosition().position !== "GOALKEEPER"
            );
        }else {
            playersToKickOff = team.players.filter(p =>
                !p.getPlayerPosition().position.includes("BACK") && p.getPlayerPosition().position !== "GOALKEEPER"
            );
        }
        const player1 = playersToKickOff[Math.floor(Math.random() * playersToKickOff.length)];
        playersToKickOff = playersToKickOff.filter(p => p !== player1);
        const player2 = playersToKickOff[Math.floor(Math.random() * playersToKickOff.length)];

        player1.getPlayerPosition().playerCoordinates.x = FIELD_WIDTH / 2;
        player1.getPlayerPosition().playerCoordinates.y = FIELD_HEIGHT / 2;
        player2.getPlayerPosition().playerCoordinates.x = FIELD_WIDTH / 2 + Math.random() * 6 - 3;
        player2.getPlayerPosition().playerCoordinates.y = FIELD_HEIGHT / 2 + Math.random() * 6 - 3;

        console.log(`Coup d'envoi! ${player1.getPlayerId()} passe à ${player2.getPlayerId()}`);
        this.lastPasser = player1;
        this.launchBall(BallFlightType.PASS, {x: player2.getPlayerPosition().playerCoordinates.x + Math.random() - 0.5, y: player2.getPlayerPosition().playerCoordinates.y + Math.random() - 0.5,}, 20, player2);
    }

    simulateStep() {
        const allPlayers = [...this.teamA.players, ...this.teamB.players];
        for (const player of allPlayers) {
            this.updatePlayerHealth(player);
        }
        this.updateBallPossession();
        this.mqttPublish.publishPlayersHealth(allPlayers, this.matchId);
        this.mqttPublish.publishBallPosition(this.ball, this.matchId);
    }

    async secondHalfStart() {
        this.teamA.side = "RIGHT";
        this.teamB.side = "LEFT";
        this.mqttPublish.publishMatchState(MatchStateEnum.SECOND_HALF_KICK_OFF, this.matchId, this.matchTime90minutes, this.score);
        await this.resetAllPlacements(this.teamB);
    }

    resetPositionOfPlayers(allPlayers: Player[]) {
        const positionsLeft = getPositionsWithPlacement("LEFT", FIELD_WIDTH, FIELD_HEIGHT).map(p => ({ ...p }));
        const positionsRight = getPositionsWithPlacement("RIGHT", FIELD_WIDTH, FIELD_HEIGHT).map(p => ({ ...p }));

        for (const player of allPlayers) {
            const side = this.getTeamFromPlayer(player).side;
            const positions = side === "LEFT" ? positionsLeft : positionsRight;

            const index = positions.findIndex(p => p.position === player.getPlayerPosition().position);
            if (index !== -1) {
                const placement = positions.splice(index, 1)[0];
                player.getPlayerPosition().playerCoordinates.x = placement.x;
                player.getPlayerPosition().playerCoordinates.y = placement.y;
            }
        }
    }
    async startSimulation(duration = 90, actionsPerSecond = 3) {
        console.log(`Début du match! Durée: ${duration} secondes`);
        this.mqttPublish.publishMatchState(MatchStateEnum.KICK_OFF, this.matchId, this.matchTime90minutes, this.score);
        this.kickoff();
        this.running = true;

        while (this.running && this.matchTime < duration) {
            if (this.matchTime === Math.round(duration / 2)) {
                this.mqttPublish.publishMatchState(MatchStateEnum.HALF_TIME, this.matchId, this.matchTime90minutes, this.score);
                console.log(`MI-TEMPS`);
                //this.matchPause = true;
                await new Promise(resolve => setTimeout(resolve, 5000));
                await this.secondHalfStart();
                //await new Promise(resolve => setTimeout(resolve, 10000));
            }

            while (this.matchPause) {
                await new Promise(resolve => setTimeout(resolve, 100));
            }

            for (let i = 0; i < actionsPerSecond; i++) {
                this.simulateStep();
                await new Promise(resolve => setTimeout(resolve, 1000 / actionsPerSecond));
            }

            this.matchTime++;
            this.matchTime90minutes = Number((this.matchTime / duration * 90).toFixed(2));
            this.mqttPublish.publishMatchState(MatchStateEnum.TIME_UPDATE, this.matchId, this.matchTime90minutes, this.score);
        }

        this.mqttPublish.publishMatchState(MatchStateEnum.FULL_TIME, this.matchId, this.matchTime90minutes, this.score);
        console.log(`\nFin du match!`);
        this.running = false;
    }
}

export default SimulateMatch;