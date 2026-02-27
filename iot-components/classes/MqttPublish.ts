import {PlayerPosition} from "../types/generated/PlayerPosition";
import {Player} from "./Player";
import {PlayerHealth} from "../types/generated/PlayerHealth";
import {EventTypeEnum} from "../enums/generated/EventTypeEnum";
import {BallEvent} from "../types/generated/BallEvent";
import {MatchStateEnum} from "../enums/generated/MatchStateEnum";

import mqtt from 'mqtt';
import {MatchState} from "../types/generated/MatchState";
import {Score} from "../types/generated/Score";
import {MatchEvent} from "../types/generated/MatchEvent";

const MQTT_BROKER = process.env.MQTT_BROKER ?? "172.31.249.162:1883"

export class MqttPublish {
    private client : any;
    constructor() {
        this.client = mqtt.connect("mqtt://" + MQTT_BROKER, {
            reconnectPeriod: 0
        });
    }

    connect(): Promise<boolean> {
        return new Promise((resolve) => {
            if (this.client.connected) {
                console.log('Déjà connecté au broker MQTT');
                resolve(true);
                return;
            }

            this.client.once('connect', () => {
                console.log('Connecté au broker MQTT');
                resolve(true);
            });

            this.client.once('error', (err: Error) => {
                console.error(`Erreur de connexion: ${err}`);
                resolve(false);
            });
        });
    }

    disconnect(){
        this.client.end();
        console.log("Disconnected from MQTT broker");
    }

    publishActionEvent(player : Player, eventType : EventTypeEnum, matchId : number, ballTouched : boolean) {
        /*const data = {
            event_type: actionType,
            team: player.team,
        };*/

        /*if (target) {
            data.target_player = target.id;
        }*/
        const playerId = player.getPlayerId();
        const teamId = player.getTeamId();
        this.client.publish("match/events", JSON.stringify(
            {
                matchId,
                playerId,
                teamId,
                eventType,
                ballTouched
            }));
        //console.log(`${actionType}: ${player.id} (${player.position})`);
    }

    publishPlayersHealth(allPlayers : Player[], matchId : number) {
        //const allPlayers = [...this.teamA.players, ...this.teamB.players];
        /*for (let player of allPlayers) {
            const player_health = {
                stamina: player.stamina.toFixed(1),
                heart_rate: player.heart_rate,
                temperature: player.temperature.toFixed(2)
            }
            const data = {
                team: player.team,
                player_health: player_health
            };
            this.client.publish("players/health", JSON.stringify(
                {
                    match_id: this.matchId,
                    player_id: player.id,
                    player_health_data: data,
                    timestamp: new Date().toISOString()
                }
            ));
        }*/
        const playersHealth : PlayerHealth[] = allPlayers.map((player)=>{
            return player.getPlayerHealth();
        })
        this.client.publish("players/health", JSON.stringify({matchId, playersHealth}));
    }


    publishMatchSheet(playersIds : number[], matchId: number){
        this.client.publish("match/sheet", JSON.stringify({matchId, playersIds}))
    }

    publishPlayersPosition(allPlayers : Player[], matchId : number) {
        //const allPlayers = [...this.teamA.players, ...this.teamB.players];
        const playersPosition : PlayerPosition[] = allPlayers.map((player)=>{
            return player.getPlayerPosition();
        })
        this.client.publish("players/position", JSON.stringify({matchId, playersPosition}));
        /*for (let player of allPlayers) {
            const data = {
                team: player.team,
                position: player.position,
                player_coordinates: {x: player.x.toFixed(2), y: player.y.toFixed(2)},
                distance_covered: player.distanceCovered.toFixed(2),
                has_ball: player.hasBall || false
            };
            this.client.publish("players/position", JSON.stringify(
                {
                    match_id: this.matchId,
                    player_id: player.id,
                    player_position_data: data,
                    timestamp: new Date().toISOString(),
                }));*/
     //}
    }

    publishBallPosition(ball : BallEvent, matchId : number) {
        //const ball_coordinates = {x: this.ball.x.toFixed(2), y: this.ball.y.toFixed(2), z: this.ball.z.toFixed(2)};
        const ballCoordinates = ball.ballCoordinates;
        const data = {
            matchId,
            ballCoordinates,
            speed: ball.speed,
            //timestamp: new Date().toISOString()
            //ball_coordinates: ball_coordinates,
            //speed: this.ball.speed.toFixed(2)
        };
        this.client.publish("ball/events", JSON.stringify(data));
    }

    publishGoalEvent(player : Player, matchId : number, matchTime90minutes : number, score: Score, lastPasser? : Player) {
        const playerId = player.getPlayerId();
        const teamId = player.getTeamId();
        const goalEvent: MatchEvent = {
            matchId,
            playerId,
            teamId,
            eventType: EventTypeEnum.GOAL,
            ballTouched: false
        }
        this.client.publish("match/events", JSON.stringify(goalEvent));
        if (lastPasser) {
            const assistEvent: MatchEvent = {
                matchId,
                playerId: lastPasser.getPlayerId(),
                teamId,
                eventType: EventTypeEnum.ASSIST,
                ballTouched: false
            }
            this.client.publish("match/events", JSON.stringify(assistEvent));
        }
        this.publishMatchState(MatchStateEnum.SCORE_UPDATE,matchId,matchTime90minutes,score);
        console.log(`BUT!`);
        //this.lastPasser = null;
    }

    publishMatchState(matchStateEnum : MatchStateEnum, matchId : number, matchTime90minutes : number, score: Score) {
        const data : MatchState = {
            matchId,
            matchStateEnum,
            matchTime: matchTime90minutes,
            score
        }
        this.client.publish("match/state", JSON.stringify(data));
    }

}