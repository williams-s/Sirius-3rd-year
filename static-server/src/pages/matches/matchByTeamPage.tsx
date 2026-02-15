import React, {useEffect, useState} from "react";
import type {MatchResponse} from "../../types/generated/MatchResponse.ts";
import {getAllMatches} from "../../api/matchApi.ts";
import {MatchCard} from "../../components/MatchDetailsComponent.tsx";
import {useNavigate, useParams} from "react-router-dom";
import {MatchStatusEnum} from "../../enums/generated/MatchStatusEnum.ts";


export const MatchByTeamPage : React.FC = () => {
    const [matches, setMatches] = useState<MatchResponse[]>([]);
    const navigate = useNavigate();
    const [statusFilter, setStatusFilter] = useState<MatchStatusEnum|string>("ALL");
    const teamId = useParams().teamId;
    const filters = [
        { label: "Tous", value: "ALL" },
        { label: "Prochains matchs", value: MatchStatusEnum.SCHEDULED },
        { label: "En direct", value: MatchStatusEnum.LIVE },
        { label: "Terminés", value: MatchStatusEnum.FINISHED },
        { label: "Annulés", value: MatchStatusEnum.CANCELLED}
    ];


    useEffect(() => {
        const getMatches = async () => {
            try {
                if (teamId){
                    const data = await getAllMatches(Number(teamId));
                    if (data){
                        setMatches(data);
                    }
                }
            } catch (e){
                console.error(e)
            }
        }
        getMatches();
    }, []);

    const filteredMatches = statusFilter === "ALL" ? matches
        : matches.filter(m => m.status === statusFilter);


    return (
        <div className="relative h-screen overflow-y-auto p-4">

            <div className="sticky z-10 top-0 flex gap-10">
                {filters.map(f => (
                    <button key={f.value} onClick={() => setStatusFilter(f.value)}
                            className={`rounded-lg text-sm font-medium transition-colors
                        ${statusFilter === f.value ? "bg-blue-600" : "bg-gray-700"}`}
                    >
                        {f.label}
                    </button>
                ))}
            </div>

            <div className="grid grid-cols-3 gap-4 mt-12">
                {filteredMatches.map(m => (
                    <div
                        key={m.idMatch}
                        onClick={() => navigate("/live/" + m.idMatch)}
                        className="cursor-pointer transition-transform hover:scale-105"
                    >
                        <MatchCard match={m}/>
                    </div>
                ))}
            </div>
        </div>
    );
}