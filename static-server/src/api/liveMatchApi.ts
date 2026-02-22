import axios from "axios";
import {LIVE_MATCH_API} from "../constants/back.ts";
import type {LiveMatch} from "../types/generated/LiveMatch.ts";
import type {Stats} from "../types/generated/Stats.ts";
import type {HeatMapPlayer} from "../types/generated/HeatMapPlayer.ts";

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