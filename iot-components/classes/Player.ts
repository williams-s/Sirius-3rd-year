import {PlayerPosition} from "../types/generated/PlayerPosition";
import {PlayerHealth} from "../types/generated/PlayerHealth";
import {PositionEnum} from "../enums/generated/PositionEnum";


export class Player {
    private playerId : number;
    private teamId : number;
    private playerPosition : PlayerPosition;
    private playerHealth : PlayerHealth;
    private matchId : number;
    constructor(matchId : number, playerId : number,teamId : number, position : PositionEnum, x : number, y : number) {
        this.matchId = matchId;
        this.playerId = playerId;
        this.teamId = teamId;
        this.initPlayerPosition(position, x, y);
        this.initPlayerHealth();
    }

    getPlayerId() : number {
        return this.playerId;
    }

    getTeamId() : number {
        return this.teamId;
    }

    getPlayerPosition() : PlayerPosition {
        return this.playerPosition;
    }

    getPlayerHealth() : PlayerHealth {
        return this.playerHealth;
    }

    private initPlayerPosition(position : PositionEnum, x : number, y : number): void {
        this.playerPosition = {
            matchId: this.matchId,
            playerId: this.playerId,
            teamId: this.teamId,
            position: position,
            playerCoordinates: {x,y},
            hasBall: false,
            distanceCovered: 0
        }
    }

    private initPlayerHealth(): void {
        this.playerHealth = {
            matchId : this.matchId,
            playerId : this.playerId,
            teamId : this.teamId,
            heartRate : 100,
            stamina : 100,
            temperature : 37
        }
    }


    setPlayerCoordinates(x : number,y : number): void {
        this.playerPosition.playerCoordinates.x = x;
        this.playerPosition.playerCoordinates.y = y;
    }
}