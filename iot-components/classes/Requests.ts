import axios from "axios";
import {PlayerTeamInfo} from "../types/generated/PlayerTeamInfo";
import {TeamResponse} from "../types/generated/TeamResponse";

export class Requests {
    private server; //= "localhost:8082";

    constructor(server: string) {
        this.server = server;
    }

    async getTeamsFromMatch(matchId : number){
        return await axios.get<TeamResponse[]>(`${this.server}/api/mock/match/${matchId}/teams`);
    }

    async getPlayersFromThatTeam(teamId : number){
        return await axios.get<PlayerTeamInfo[]>(`${this.server}/api/mock/playerBelongsTeam/${teamId}`)
    }

}