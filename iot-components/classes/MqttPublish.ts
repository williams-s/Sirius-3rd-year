import {PlayerPosition} from "../types/generated/PlayerPosition";
import {Player} from "./Player";
import {PlayerHealth} from "../types/generated/PlayerHealth";
import {EventTypeEnum} from "../enums/generated/EventTypeEnum";
import {BallEvent} from "../types/generated/BallEvent";
import {MatchEvent} from "../types/generated/MatchEvent";
import {MatchEventEnum} from "../enums/generated/MatchEventEnum";

import mqtt from 'mqtt';
const MQTT_BROKER = "172.31.249.162:1883"

export class MqttPublish {
    private client : any;
    constructor() {
        this.client = mqtt.connect("mqtt://" + MQTT_BROKER);
    }

    connect(){
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
        this.client.publish("players/health", JSON.stringify({playersHealth}));
    }

    publishPlayersPosition(allPlayers : Player[], matchId : number) {
        //const allPlayers = [...this.teamA.players, ...this.teamB.players];
        const playersPosition : PlayerPosition[] = allPlayers.map((player)=>{
            return player.getPlayerPosition();
        })
        this.client.publish("players/position", JSON.stringify({playersPosition}));
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

    publishGoalEvent(player : Player, matchId : number, matchTime90minutes : number, lastPasser? : Player) {
        /*const team = player.team;
        const data = {
            event_type: "GOAL",
            team: team,
        };*/
        const playerId = player.getPlayerId();
        const teamId = player.getTeamId();
        this.client.publish("match/events", JSON.stringify(
            {
                matchId,
                playerId,
                teamId,
                ballTouched : false,
                eventType: "GOAL",
                //timestamp: new Date().toISOString(),
            }));
        if (lastPasser) {
            this.client.publish("match/events", JSON.stringify(
                {
                    matchId,
                    playerId,
                    teamId,
                    ballTouched : false,
                    eventType: "ASSIST",
                    //timestamp: new Date().toISOString(),
                }));
        }
        const data2 = {
            matchId,
            teamId,
            timestamp: new Date().toISOString(),
            matchEvent: "SCORE_UPDATE",
            matchTime: matchTime90minutes,
            //score: this.getScore()
        }
        this.client.publish("match/state", JSON.stringify(data2));
        console.log(`BUT!`);
        //this.lastPasser = null;
    }

    publishMatchState(matchEvent : MatchEventEnum, matchId : number, matchTime90minutes : number) {
        const data = {
            matchId,
            //timestamp: new Date().toISOString(),
            matchEvent,
            matchTime: matchTime90minutes
            //score: this.getScore()
        };
        this.client.publish("match/state", JSON.stringify(data));
    }

}