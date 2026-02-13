import {MATCH_API} from "../constants/back.ts";
import axios from "axios";
import type {MatchResponse} from "../types/generated/MatchResponse.ts";

export const getMatch = async (matchId : number) => {
    const url = `${MATCH_API}/${matchId}`;
    const response = await axios.get<MatchResponse>(url);
    console.log("Response:", response.data);
    return response.data;
}