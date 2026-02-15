import axios from "axios";
import {LIVE_MATCH_API} from "../constants/back.ts";
import type {LiveMatch} from "../types/generated/LiveMatch.ts";

export const getCurrentLiveMatchDetails = async (matchId : number) => {
    const url = `${LIVE_MATCH_API}/${matchId}`;
    const response = await axios.get<LiveMatch>(url);
    console.log("Response:", response.data);
    return response.data;
}