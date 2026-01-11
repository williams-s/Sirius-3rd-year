import React,{useState, useEffect} from "react";
import type {LiveMatch} from "../../types/generated/LiveMatch.ts";
import {ConnectToWebSocketSTOMP} from "../../utils/websocketConnection.ts";
import {FootballField} from "../../components/FootballField.tsx";

export const LiveMatchPage : React.FC = () => {
    //const [liveMatch,setLiveMatch] = useState<LiveMatch>();
    useEffect(() => {
        const client = ConnectToWebSocketSTOMP();
        client.onConnect = () => {
            console.log("STOMP connecté");
            client.subscribe("/topic/live-match", (message) => {
                try {
                    const liveMatchData: LiveMatch = JSON.parse(message.body);
                    console.log("Minute du match:", liveMatchData.matchState.match_time);
                    //setLiveMatch(liveMatchData);
                } catch (error) {
                    console.error("Erreur de parsing du message:", error);
                }
            });
        }

        return () => {
            client.deactivate();
        };
    }, []);

    return (
        <div>
            <FootballField>

            </FootballField>
        </div>
    )

}