import {PLAYER_API, TEST_API} from "../constants/back.ts";
import type {PlayerResponse} from "../types/generated/PlayerResponse.ts";
import axios from "axios";
import type {PlayerAttributes} from "../types/generated/PlayerAttributes.ts";

export const getPlayer = async (playerId : number)=> {
    const url = `${PLAYER_API}/${playerId}`;
    const response = await axios.get<PlayerResponse>(url);
    console.log("Response:", response.data);
    return response.data;
}

export const getPlayers = async (teamId : number) => {
    //const url = `${TEST_API}/player/all/${teamId}`;
    const url = `${PLAYER_API}/${teamId}/all`;
    const response = await axios.get<PlayerAttributes[]>(url);
    console.log("Response:", response.data);
    return response.data;
}