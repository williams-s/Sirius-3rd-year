import React, {useEffect, useState} from "react";
import {useParams} from "react-router-dom";
import {getPlayers} from "../../api/playerApi.ts";
import type {PlayerAttributes} from "../../types/generated/PlayerAttributes.ts";
import {PlayerCardAttributes} from "../../components/players/PlayerCardAttributes.tsx";

export const PlayersByTeamPage : React.FC = () => {
    const [players, setPlayers] = useState<PlayerAttributes[]>([]);
    const teamId = useParams().teamId;

    useEffect(() => {
        const fetchPlayers = async () => {
            try {
                if (teamId) {
                    const data = await getPlayers(Number(teamId));
                    if (data) {
                        setPlayers(data);
                    }
                }
            } catch (e) {
                console.error(e)
            }
        }
        fetchPlayers();
    }, []);


    return (
        <div className="relative h-screen overflow-y-auto p-4">
            <div className="grid grid-cols-3 gap-4 mt-12">
                {players.map(p => (
                    <div
                        key={p.playerId}
                        className="cursor-pointer transition-transform hover:scale-105"
                    >
                        <PlayerCardAttributes player={p}/>
                    </div>
                ))}
            </div>
        </div>
    );
}

