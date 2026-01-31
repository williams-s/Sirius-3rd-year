import React,{useState, useEffect} from "react";
import {ConnectToWebSocketSTOMP} from "../../utils/websocketConnection.ts";
import {FootballField} from "../../components/FootballField.tsx";
import {useParams} from "react-router-dom";
import type {PlayerPosition} from "../../types/generated/PlayerPosition.ts";
import type {BallEvent} from "../../types/generated/BallEvent.ts";

export const LiveMatchPage : React.FC = () => {
    const [playersPosition,setPlayersPosition] = useState<PlayerPosition[]>();
    const [ballEvent,setBallEvent] = useState<BallEvent>();
    const matchId = useParams().matchId;
    useEffect(() => {
        //console.log("Live match page")
        const client = ConnectToWebSocketSTOMP();
        client.onConnect = () => {
            console.log("STOMP connecté");
            client.subscribe("/topic/live-match/" + matchId + "/players-position", (message) => {
                try {
                    const playerPositionsData: PlayerPosition[] = JSON.parse(message.body);
                    console.log(playerPositionsData);
                    setPlayersPosition(playerPositionsData);
                } catch (error) {
                    console.error("Erreur de parsing du message:", error);
                }
            });
            client.subscribe("/topic/live-match/" + matchId + "/ball-events", (message) => {
                try {
                    const ballEvent: BallEvent = JSON.parse(message.body);
                    console.log(ballEvent);
                    setBallEvent(ballEvent);
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

    if (!playersPosition || !ballEvent) {
        return <div>Loading match data...</div>;
    }

    return (
        <div className="flex w-screen h-screen bg-slate-900">
            <div className="pt-4">
                <FootballField playerPositions={playersPosition} ballEvent={ballEvent}/>
            </div>
            {/*<Scoreboard matchState={liveMatch.matchState}/>*/}
        </div>
    )

}