import {LIVE_MATCH_TOPIC} from "../constants/back.ts";

export const liveMatchTopic = (matchId : string, topic : string) => {
    return `${LIVE_MATCH_TOPIC}/${matchId}/${topic}`;
}