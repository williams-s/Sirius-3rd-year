import React, { useEffect, useState } from "react";
import { useNavigate } from "react-router-dom";
import type { TeamResponse } from "../../types/generated/TeamResponse.ts";
import { getAllTeams } from "../../api/teamApi.ts";
import { TeamCard } from "./TeamCard.tsx";

export const TeamSelector = ({navigateTo,text="Liste des équipes du club"} : {navigateTo : string, text?: string}) => {
    const [teams, setTeams] = useState<TeamResponse[]>([]);
    const navigate = useNavigate();

    useEffect(() => {
        const fetchTeams = async () => {
            try {
                const data = await getAllTeams();
                if (data) setTeams(data);
            } catch (e) {
                console.error(e);
            }
        };
        fetchTeams();
    }, []);

    return (
        <div className="relative h-screen overflow-y-auto p-4">
            <h2 className="text-2xl font-bold text-white text-center tracking-wide border-b border-gray-700 pb-3 mb-4">
                {text}
            </h2>
            <div className="grid grid-cols-3 gap-4 mt-12">
                {teams.map(t => (
                    <div
                        key={t.teamId}
                        onClick={() => navigate(`/${navigateTo}/${t.teamId}`)}
                        className="cursor-pointer transition-transform hover:scale-105"
                    >
                        <TeamCard team={t}/>
                    </div>
                ))}
            </div>
        </div>
    );
};