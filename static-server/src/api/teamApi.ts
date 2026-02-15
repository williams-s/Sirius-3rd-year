import {MATCH_API, TEAM_API, TEST_API} from "../constants/back.ts";
import axios from "axios";
import type {TeamResponse} from "../types/generated/TeamResponse.ts";

export const getAllTeams = async () => {
    //const url = `${TEST_API}/team/1`;
    const url = `${TEAM_API}/me`;
    const response = await axios.get<TeamResponse[]>(url);
    console.log("Response:", response.data);
    return response.data;
}

