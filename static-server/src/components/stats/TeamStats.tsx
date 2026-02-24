import { useEffect, useState } from "react";
import { ConnectToWebSocketSTOMP } from "../../utils/websocketConnection.ts";
import { liveMatchTopic } from "../../utils/topics.ts";
import type { Stats } from "../../types/generated/Stats.ts";
import {getCurrentTeamStats, getMyTeam} from "../../api/liveMatchApi.ts";
import {StatsComponent} from "./StatsComponent.tsx";
import type {TeamResponse} from "../../types/generated/TeamResponse.ts";

type Props = {
    matchId: string;
};

export const TeamStats = ({ matchId }: Props) => {
    const [stats, setStats] = useState<Stats | null>(null);
    const [team, setTeam] = useState<TeamResponse | null>(null);
    useEffect(() => {
        const getStatsForMyTeam = async () => {
            try {
                const teamData = await getMyTeam(Number(matchId));
                setTeam(teamData);
                if (teamData?.teamId) {
                    const statsData = await getCurrentTeamStats(Number(matchId), teamData.teamId);
                    setStats(statsData);

                    const client = ConnectToWebSocketSTOMP();
                    client.onConnect = () => {
                        client.subscribe(
                            liveMatchTopic(matchId, `stats-team-live/${teamData.teamId}`),
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
                }
            } catch (e) {
                console.error(e);
            }
        };
        getStatsForMyTeam();
    }, [matchId]);

    if (!team)
        return <div>Loading...</div>
    return (
        <div>
            <h2>{team.name}</h2>
            <StatsComponent stats={stats}/>
        </div>
    )
};