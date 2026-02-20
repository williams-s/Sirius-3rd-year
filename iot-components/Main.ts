import {MqttPublish} from "./classes/MqttPublish.js";
import {Player} from "./classes/Player.js";
import {getPositionsWithPlacement} from "./utils/Positions.js";
import {PositionEnum} from "./enums/generated/PositionEnum";
import {FIELD_HEIGHT, FIELD_WIDTH, TeamSimulate} from "./utils/Constants.js";
import SimulateMatch from "./classes/SimulateMatch.js";
import {BallEvent} from "./types/generated/BallEvent.js";
import {Requests} from "./classes/Requests";
import {PlayerTeamInfo} from "./types/generated/PlayerTeamInfo";
import {getExactAmountOfPlayers, positionLines} from "./utils/formationUtils";


const matchId = Number(process.env.MATCH_ID ?? 1);
const API_URL = process.env.API_BASE_URL ?? "http://localhost:8082";
const deltaTimeMs = 33;

const mqttPublish = new MqttPublish();
console.log("Connecting to MQTT broker...");


const teamA : TeamSimulate = {
    teamId : 0,
    players : [],
    side : "LEFT",
    name: ""
}
const teamB : TeamSimulate = {
    teamId : 0,
    players : [],
    side : "RIGHT",
    name: ""
}

const request = new Requests(API_URL);
const positions_left = getPositionsWithPlacement("LEFT", FIELD_WIDTH, FIELD_HEIGHT);
const positions_right = getPositionsWithPlacement("RIGHT", FIELD_WIDTH, FIELD_HEIGHT);



const getLines = (players : PlayerTeamInfo[]) => {
    const lines : positionLines = {
        goalkeepers : players.filter(player => player.position === PositionEnum.GOALKEEPER),
        defenders : players.filter(player => player.position.includes("BACK")),
        midfielders : players.filter(player => player.position.includes("MIDFIELDER")),
        attackers : players.filter(player => player.position.includes("STRIKER") || player.position.includes("WINGER"))
    };
    return lines;
}

const addPlayer = (team: TeamSimulate, players: PlayerTeamInfo[], position : PositionEnum, amount : number) => {
    const playersToAdd = getExactAmountOfPlayers(players, position, amount);
    for (const player of playersToAdd){
        let placement :  {
            position: PositionEnum
            x: number
            y: number
        }
        if (team.side === "LEFT")
            placement = positions_left.find(p => p.position === player.position);
        else
            placement = positions_right.find(p => p.position === player.position);
        team.players.push(new Player(matchId,player.playerId, player.teamId, player.position,placement.x,placement.y))
    }
}

const defaultFormation = (team: TeamSimulate, allLines : positionLines) => {
    addPlayer(team, allLines.goalkeepers, PositionEnum.GOALKEEPER, 1);
    addPlayer(team, allLines.defenders, PositionEnum.CENTER_BACK, 2);
    addPlayer(team, allLines.defenders, PositionEnum.RIGHT_BACK, 1);
    addPlayer(team, allLines.defenders, PositionEnum.LEFT_BACK, 1);

    addPlayer(team, allLines.midfielders, PositionEnum.CENTER_MIDFIELDER, 2);
    addPlayer(team, allLines.midfielders, PositionEnum.CENTER_ATTACKING_MIDFIELDER, 1);

    addPlayer(team, allLines.attackers, PositionEnum.LEFT_WINGER, 1);
    addPlayer(team, allLines.attackers, PositionEnum.STRIKER, 1);
    addPlayer(team, allLines.attackers, PositionEnum.RIGHT_WINGER, 1);
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


//initPlayers(1, 11, 1, "LEFT");
//initPlayers(2, 11, 12, "RIGHT");

const main = async () => {
    const teams = await request.getTeamsFromMatch(matchId);
    if (teams.data){
        const data = teams.data;
        if (data.length >= 2){
            teamA.teamId = data[0].teamId;
            teamA.name = data[0].name;

            teamB.teamId = data[1].teamId;
            teamB.name = data[1].name;

            const playersA = await request.getPlayersFromThatTeam(data[0].teamId);
            const playersB = await request.getPlayersFromThatTeam(data[1].teamId);

            if (playersA.data && playersB.data){
                const playersALines = getLines(playersA.data);
                const playersBLines = getLines(playersB.data);

                defaultFormation(teamA, playersALines);
                defaultFormation(teamB, playersBLines);

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
                            const players = [...match.teamA.players, ...match.teamB.players].map(p => p.getPlayerId());
                            console.log(players);
                            mqttPublish.publishMatchSheet(players, matchId);
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
                                match.updatePlayersPositions([...match.teamA.players, ...match.teamB.players],deltaTimeMs);

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
            }
        }
    }
}

main();

