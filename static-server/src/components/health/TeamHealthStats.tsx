import { useEffect, useState } from "react";
import { ConnectToWebSocketSTOMP } from "../../utils/websocketConnection.ts";
import { liveMatchTopic } from "../../utils/topics.ts";
import {getCurrentTeamHealth, getMyTeam} from "../../api/liveMatchApi.ts";
import type {TeamHealthStats} from "../../types/generated/TeamHealthStats.ts";
import type {TeamResponse} from "../../types/generated/TeamResponse.ts";
import {getPlayers} from "../../api/playerApi.ts";
import type {PlayerAttributes} from "../../types/generated/PlayerAttributes.ts";

type Props = {
    matchId: string;
};

export const TeamHealthStatsComponent = ({ matchId }: Props) => {
    const [health, setHealth] = useState<TeamHealthStats | null>(null);
    const [team, setTeam] = useState<TeamResponse | null>(null);
    const [players, setPlayers] = useState<PlayerAttributes[]>([]);
    useEffect(() => {
        const getStatsForMyTeam = async () => {
            try {
                const teamData = await getMyTeam(Number(matchId));
                setTeam(teamData);
                if (teamData?.teamId) {
                    const healthData = await getCurrentTeamHealth(Number(matchId), teamData.teamId);
                    setHealth(healthData);
                    const playersData = await getPlayers(Number(teamData.teamId));
                    setPlayers(playersData);
                    const client = ConnectToWebSocketSTOMP();
                    client.onConnect = () => {
                        client.subscribe(
                            liveMatchTopic(matchId, `health-team-live/${teamData.teamId}`),
                            (message) => {
                                try {
                                    setHealth(JSON.parse(message.body));
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

    if (!health || !team) return <p className="text-gray-400 text-sm">Loading stats...</p>;

    return (
        <div>
            <h2 className={"text-center"}>{team.name}</h2>
            <br/>
            <div className="flex flex-col gap-1">
                <div className="flex justify-between text-sm px-2 py-1 rounded hover:bg-white/5">
                    <span className="text-gray-400">Nom</span>
                    <span className="text-gray-400">BPM</span>
                    <span className="text-gray-400">Temperature</span>
                    <span className="text-gray-400">Stamina</span>
                </div>
                <br/>
                <br/>
                {health.playerHealthStatsDTOList.map(playerHealthStats => (
                    <div key={playerHealthStats.playerId} className="flex justify-between text-sm px-2 py-1 rounded hover:bg-white/5">
                        <span className="text-gray-400">{(() => {const player = players.find(p => p.playerId === playerHealthStats.playerId); return `${player?.firstName} ${player?.name}`;})()}</span>
                        <span className="text-white font-medium">{`${playerHealthStats.currentHeartRate} BPM`}</span>
                        <span className="text-white font-medium">{`${playerHealthStats.currentTemperature.toFixed(2)} °C`}</span>
                        <span className="text-white font-medium">{`${playerHealthStats.currentStamina.toFixed(2)} %`}</span>
                    </div>
                ))}
                <br/>
                <br/>
                <br/>
                <div className="flex justify-between text-sm px-2 py-1 rounded hover:bg-white/5">
                    <span className="text-gray-400">Moyenne équipe</span>
                    <span className="text-white font-medium">{`${health.avgHeartRate.toFixed(2)} BPM`}</span>
                    <span className="text-white font-medium">{`${health.avgTemperature.toFixed(2)} °C`}</span>
                    <span className="text-white font-medium">{`${health.avgStamina.toFixed(2)} %`}</span>
                </div>
            </div>
        </div>
    );
};