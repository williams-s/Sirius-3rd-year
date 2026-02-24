import { useEffect, useState } from "react";
import { ConnectToWebSocketSTOMP } from "../../utils/websocketConnection.ts";
import { liveMatchTopic } from "../../utils/topics.ts";
import type { Stats } from "../../types/generated/Stats.ts";
import {getCurrentStats} from "../../api/liveMatchApi.ts";
import {StatsComponent} from "./StatsComponent.tsx";

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
                liveMatchTopic(matchId, `stats-player-live/${playerId}`),
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

    return <StatsComponent stats={stats}/>
};