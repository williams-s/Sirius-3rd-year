import axios from "axios";
import {LIVE_MATCH_API} from "../constants/back.ts";
import type {LiveMatch} from "../types/generated/LiveMatch.ts";
import type {Stats} from "../types/generated/Stats.ts";
import type {HeatMapPlayer} from "../types/generated/HeatMapPlayer.ts";
import type {PlayerHealthStats} from "../types/generated/PlayerHealthStats.ts";
import type {TeamResponse} from "../types/generated/TeamResponse.ts";
import type {TeamHealthStats} from "../types/generated/TeamHealthStats.ts";

export const getCurrentLiveMatchDetails = async (matchId : number) => {
    const url = `${LIVE_MATCH_API}/${matchId}`;
    const response = await axios.get<LiveMatch>(url);
    console.log("Response:", response.data);
    return response.data;
}

export const getCurrentHeatMap = async (matchId : number, playerId : number) => {
    const url = `${LIVE_MATCH_API}/${matchId}/heatMap/${playerId}`;
    const response = await axios.get<HeatMapPlayer>(url);
    console.log("Response:", response.data);
    return response.data;
}

export const getCurrentStats = async (matchId : number, playerId : number) => {
    const url = `${LIVE_MATCH_API}/${matchId}/stats/${playerId}`;
    const response = await axios.get<Stats>(url);
    console.log("Response:", response.data);
    return response.data;
}

export const getCurrentTeamStats = async (matchId : number, teamId : number) => {
    const url = `${LIVE_MATCH_API}/${matchId}/teamStats/${teamId}`;
    const response = await axios.get<Stats>(url);
    console.log("Response:", response.data);
    return response.data;
}

export const getCurrentHealth = async (matchId : number, playerId : number) => {
    const url = `${LIVE_MATCH_API}/${matchId}/playerHealthStats/${playerId}`;
    const response = await axios.get<PlayerHealthStats>(url);
    console.log("Response:", response.data);
    return response.data;
}

export const getCurrentTeamHealth = async (matchId : number, teamId : number) => {
    const url = `${LIVE_MATCH_API}/${matchId}/teamHealthStats/${teamId}`;
    const response = await axios.get<TeamHealthStats>(url);
    console.log("Response:", response.data);
    return response.data;
}

export const getMyTeam = async (matchId : number) => {
    const url = `${LIVE_MATCH_API}/${matchId}/myTeam`;
    const response = await axios.get<TeamResponse>(url);
    console.log("Response:", response.data);
    return response.data;
}