import {MqttPublish} from "./classes/MqttPublish.js";
import {Player} from "./classes/Player.js";
import {getPositionsWithPlacement} from "./Positions.js";
import {PositionEnum} from "./enums/generated/PositionEnum";
import {FIELD_HEIGHT, FIELD_WIDTH, TeamSimulate} from "./Constants.js";
import SimulateMatch from "./SimulateMatch.js";
import {BallEvent} from "./types/generated/BallEvent.js";
import {TeamScore} from "./types/generated/TeamScore";


const args = process.argv.slice(2);
const matchId = Number(args[0]);

const deltaTimeMs = 33;

const mqttPublish = new MqttPublish();
console.log("Connecting to MQTT broker...");


const teamA : TeamSimulate = {
    teamId : 1,
    players : [],
    side : "LEFT",
    name: "PSG"
}
const teamB : TeamSimulate = {
    teamId : 2,
    players : [],
    side : "RIGHT",
    name: "OM"
}





const initPlayers = (teamId : number, count : number, idStart : number, side : string) => {

    const positions = getPositionsWithPlacement(side, FIELD_WIDTH, FIELD_HEIGHT);
    let playerId = idStart;
    for (let i = 0; i < count; i++) {
        const positionWithPlacement = positions[i];
        const player = new Player(matchId, playerId, teamId, positionWithPlacement.position, positionWithPlacement.x, positionWithPlacement.y)
        playerId++;
        if (side === "LEFT") {
            teamA.players.push(player);
        } else {
            teamB.players.push(player)
        }
    }
}


initPlayers(1, 11, 1, "LEFT");
initPlayers(2, 11, 12, "RIGHT");


const ball : BallEvent = {
    matchId,
    ballCoordinates: {x: FIELD_WIDTH / 2, y: FIELD_HEIGHT / 2, z: 0 },
    speed: 0
}

const match = new SimulateMatch(teamA, teamB, ball, mqttPublish, matchId);

let updateInterval: NodeJS.Timeout | null = null;

mqttPublish.connect().then((connected) => {
    if (connected) {
        try {
            match.running = true;
            match.startSimulation();

            updateInterval = setInterval(() => {
                if (!match.running) {
                    if (updateInterval) {
                        clearInterval(updateInterval);
                    }
                    mqttPublish.disconnect();
                    process.exit(0);
                    return;
                }

                // Mettre à jour les positions des joueurs
                for (let p of [...match.teamA.players, ...match.teamB.players]) {
                    match.updatePlayerPosition(p, deltaTimeMs);
                }

                // Publier les positions
                mqttPublish.publishPlayersPosition([...match.teamA.players, ...match.teamB.players], matchId);
            }, deltaTimeMs);

        } catch (error) {
            console.error("Erreur:", error);
            match.running = false;
            if (updateInterval) {
                clearInterval(updateInterval);
            }
            mqttPublish.disconnect();
            process.exit(1);
        }
    } else {
        console.log("Impossible de démarrer la simulation");
        process.exit(1);
    }
});