import {CLUB_API} from "../constants/back.ts";
import axios from "axios";
import type {ClubResponse} from "../types/generated/ClubResponse.ts";

export const getMyClub = async () => {
    const url = `${CLUB_API}/me`;
    const response = await axios.get<ClubResponse>(url);
    console.log("Response:", response.data);
    return response.data;
}