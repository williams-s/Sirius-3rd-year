import React,{useState, useEffect} from "react";
import type {LiveMatch} from "../types/generated/LiveMatch.ts";
import {ConnectToWebSocketSTOMP} from "../utils/websocketConnection.ts";

export const LiveMatchPage = () : React.FC => {
    //const [liveMatch,setLiveMatch] = useState<LiveMatch>();

    useEffect(() => {
        const client = ConnectToWebSocketSTOMP();

        client.subscribe("/topic/live-match", (liveMatchMessage: LiveMatch) => {
            console.log("Minute du match: :", liveMatchMessage.matchState.match_time);
        })
    }, []);

}