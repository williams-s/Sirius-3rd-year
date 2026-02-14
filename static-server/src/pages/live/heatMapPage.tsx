import React, {useEffect, useState} from "react";
import {useParams} from "react-router-dom";
import {ConnectToWebSocketSTOMP} from "../../utils/websocketConnection.ts";
import {liveMatchTopic} from "../../utils/topics.ts";
import type {HeatMapPlayer} from "../../types/generated/HeatMapPlayer.ts";
import {PlayerHeatMap} from "../../components/heatmap/PlayerHeatMap.tsx";

export const HeatMapPage : React.FC = () => {
    const matchId = useParams().matchId;
    const playerId = useParams().playerId;
    const [heatMapPlayer, setHeatMapPlayer] = useState<HeatMapPlayer>();
    useEffect(() => {
        const client = ConnectToWebSocketSTOMP();
        if (!matchId || !playerId) {
            return;
        }
        client.onConnect = () => {
            console.log("STOMP connecté");
            client.subscribe(liveMatchTopic(matchId,"heat-map-player-position/" + playerId), (message) => {
                try {
                    const heatMapPlayerData : HeatMapPlayer = JSON.parse(message.body);
                    setHeatMapPlayer(heatMapPlayerData);
                } catch (error) {
                    console.error("Erreur de parsing du message:", error);
                }
            });
        };
        client.activate();
        return () => {
            client.deactivate();
        };
    }, []);

    if (!heatMapPlayer)
        return <div>Loading...</div>;
    return <PlayerHeatMap heatMapPlayer={heatMapPlayer} />;
}