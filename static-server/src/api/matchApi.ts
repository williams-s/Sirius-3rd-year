import {MATCH_API, TEST_API} from "../constants/back.ts";
import axios from "axios";
import type {MatchResponse} from "../types/generated/MatchResponse.ts";

export const getMatch = async (matchId : number) => {
    const url = `${MATCH_API}/${matchId}`;
    const response = await axios.get<MatchResponse>(url);
    console.log("Response:", response.data);
    return response.data;
}

export const getAllMatches = async (teamId : number) => {
    //const url = `${TEST_API}/match/all/${teamId}`;
    const url = `${MATCH_API}/${teamId}/all`;
    const response = await axios.get<MatchResponse[]>(url);
    console.log("Response:", response.data);
    return response.data;
}

