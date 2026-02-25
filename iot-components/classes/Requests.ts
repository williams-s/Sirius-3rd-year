import axios from "axios";
import {PlayerTeamInfo} from "../types/generated/PlayerTeamInfo";
import {TeamResponse} from "../types/generated/TeamResponse";
import * as https from 'https';

const axiosInstance = axios.create({
    httpsAgent: new https.Agent({ rejectUnauthorized: false })
});

export class Requests {
    private server; //= "localhost:8082";

    constructor(server: string) {
        this.server = server;
    }

    async getTeamsFromMatch(matchId : number){
        return await axiosInstance.get<TeamResponse[]>(`${this.server}/api/mock/match/${matchId}/teams`);
    }

    async getPlayersFromThatTeam(teamId : number){
        return await axiosInstance.get<PlayerTeamInfo[]>(`${this.server}/api/mock/playerBelongsTeam/${teamId}`)
    }

    async getSideForTeam(matchId : number, teamId : number){
        return await axiosInstance.get<string>(`${this.server}/api/mock/match/${matchId}/team/${teamId}/side`)
    }

}