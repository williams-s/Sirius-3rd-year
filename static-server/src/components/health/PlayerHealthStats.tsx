import { useEffect, useState } from "react";
import { ConnectToWebSocketSTOMP } from "../../utils/websocketConnection.ts";
import { liveMatchTopic } from "../../utils/topics.ts";
import {getCurrentHealth} from "../../api/liveMatchApi.ts";
import type {PlayerHealthStats} from "../../types/generated/PlayerHealthStats.ts";

type Props = {
    matchId: string;
    playerId: number;
};

export const PlayerHealthStatsComponent = ({ matchId, playerId }: Props) => {
    const [health, setHealth] = useState<PlayerHealthStats | null>(null);

    useEffect(() => {

        const currentStats = async (matchId : number, playerId : number) =>{
            try {
                const data = await getCurrentHealth(matchId, playerId);
                setHealth(data);
            } catch (e) {
                console.error(e);
            }
        }
        currentStats(Number(matchId),playerId);

        const client = ConnectToWebSocketSTOMP();

        client.onConnect = () => {
            client.subscribe(
                liveMatchTopic(matchId, `health-player-live/${playerId}`),
                (message) => {
                    try {
                        setHealth(JSON.parse(message.body));
                    } catch (e) {
                        console.error("Error parsing health:", e);
                    }
                }
            );
        };

        client.activate();
        return () => { client.deactivate(); };
    }, [matchId, playerId]);

    if (!health) return <p className="text-gray-400 text-sm">Loading stats...</p>;

    const rows = [
        { label: "Min Heart Rate",         value: `${health.minHeartRate} BPM`},
        { label: "Current Heart Rate",       value: `${health.currentHeartRate} BPM`},
        { label: "Max Heart Rate",         value: `${health.maxHeartRate} BPM`},
        { label: "Avg Heart Rate",        value: `${health.avgHeartRate.toFixed(2)} BPM`},
        { label: "Min Temperature",       value: `${health.minTemperature.toFixed(2)} °C`},
        { label: "Current Temperature",         value: `${health.currentTemperature.toFixed(2)} °C`},
        { label: "Max Temperature",      value: `${health.maxTemperature.toFixed(2)} °C`},
        { label: "Avg Temperature", value: `${health.avgTemperature.toFixed(2)} °C`},
        { label: "Current Stamina",       value: `${health.currentStamina.toFixed(2)} %` },
    ];

    return (
        <div className="flex flex-col gap-1">
            {rows.map(({ label, value }) => (
                <div key={label} className="flex justify-between text-sm px-2 py-1 rounded hover:bg-white/5">
                    <span className="text-gray-400">{label}</span>
                    <span className="text-white font-medium">{value}</span>
                </div>
            ))}
        </div>
    );
};