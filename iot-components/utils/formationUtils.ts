import _ from "lodash";
import {PlayerTeamInfo} from "../types/generated/PlayerTeamInfo";
import {PositionEnum} from "../enums/generated/PositionEnum";

export interface positionLines{
    goalkeepers: PlayerTeamInfo[],
    defenders: PlayerTeamInfo[],
    midfielders: PlayerTeamInfo[],
    attackers: PlayerTeamInfo[],
}

export function getExactAmountOfPlayers(players : PlayerTeamInfo[], position : PositionEnum ,amount = 1){
    let randomPlayers: PlayerTeamInfo[] = _.shuffle(players); //cf https://www.geeksforgeeks.org/lodash-_-shuffle-method/
    return (randomPlayers.filter(player => player.position === position).slice(0,amount));
}