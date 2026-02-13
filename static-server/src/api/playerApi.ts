import {PLAYER_API} from "../constants/back.ts";
import type {PlayerResponse} from "../types/generated/PlayerResponse.ts";
import axios from "axios";

export const getPlayer = async (playerId : number)=> {
    const url = `${PLAYER_API}/${playerId}`;
    const response = await axios.get<PlayerResponse>(url);
    console.log("Response:", response.data);
    return response.data;
}

export const getPlayers = async (playerIds : number[]) => {
    const players : PlayerResponse[] = [];
    for (const id of playerIds){
        players.push(await getPlayer(id));
    }
    return players;
}