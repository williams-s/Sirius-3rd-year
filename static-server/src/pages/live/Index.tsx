import React,{useState, useEffect} from "react";
import type {LiveMatch} from "../../types/generated/LiveMatch.ts";
import {ConnectToWebSocketSTOMP} from "../../utils/websocketConnection.ts";
import {FootballField} from "../../components/FootballField.tsx";
import {Scoreboard} from "../../components/Scoreboard.tsx";

export const LiveMatchPage : React.FC = () => {
    const [liveMatch,setLiveMatch] = useState<LiveMatch>();
    useEffect(() => {
        //console.log("Live match page")
        const client = ConnectToWebSocketSTOMP();
        client.onConnect = () => {
            console.log("STOMP connecté");
            client.subscribe("/topic/live-match", (message) => {
                try {
                    const liveMatchData: LiveMatch = JSON.parse(message.body);
                    setLiveMatch(liveMatchData);
                } catch (error) {
                    console.error("Erreur de parsing du message:", error);
                }
            });
        }
        client.activate();

        return () => {
            client.deactivate();
        };
    }, []);

    if (!liveMatch) {
        return <div>Loading match data...</div>;
    }

    return (
        <div className="flex w-screen h-screen bg-slate-900">
            <div className="pt-4">
                <FootballField liveMatch={liveMatch}/>
            </div>
            <Scoreboard matchState={liveMatch.matchState}/>
        </div>
    )

}