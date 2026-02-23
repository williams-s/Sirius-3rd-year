import { useEffect, useState } from "react";
import { ConnectToWebSocketSTOMP } from "../../utils/websocketConnection.ts";
import { liveMatchTopic } from "../../utils/topics.ts";
import type { Stats } from "../../types/generated/Stats.ts";
import {getCurrentStats} from "../../api/liveMatchApi.ts";

type Props = {
    matchId: string;
    playerId: number;
};

export const PlayerStats = ({ matchId, playerId }: Props) => {
    const [stats, setStats] = useState<Stats | null>(null);

    useEffect(() => {

        const currentStats = async (matchId : number, playerId : number) =>{
            try {
                const data = await getCurrentStats(matchId, playerId);
                setStats(data);
            } catch (e) {
                console.error(e);
            }
        }
        currentStats(Number(matchId),playerId);

        const client = ConnectToWebSocketSTOMP();

        client.onConnect = () => {
            client.subscribe(
                liveMatchTopic(matchId, `stats-player-position/${playerId}`),
                (message) => {
                    try {
                        setStats(JSON.parse(message.body));
                    } catch (e) {
                        console.error("Error parsing stats:", e);
                    }
                }
            );
        };

        client.activate();
        return () => { client.deactivate(); };
    }, [matchId, playerId]);

    if (!stats) return <p className="text-gray-400 text-sm">Loading stats...</p>;

    const rows = [
        { label: "Goals",         value: stats.goals },
        { label: "Assists",       value: stats.assists },
        { label: "Shots",         value: `${stats.shotsOnTarget} / ${stats.shots}` },
        { label: "Passes",        value: `${stats.passesSuccess} / ${stats.passes}` },
        { label: "Tackles",       value: `${stats.tacklesSuccess} / ${stats.tackles}` },
        { label: "Duels",         value: `${stats.duelsWon} / ${stats.duels}` },
        { label: "Dribbles",      value: `${stats.dribblesSuccess} / ${stats.dribbles}` },
        { label: "Interceptions", value: stats.interceptions },
        { label: "Touches",       value: stats.touches },
        { label: "Fouls",         value: stats.fouls },
        { label: "Saves",         value: stats.saves },
        { label: "Distance",      value: `${stats.distanceCovered.toFixed(2)} m` },
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