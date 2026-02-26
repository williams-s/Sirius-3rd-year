import React, {useEffect, useState} from "react";
import type {MatchResponse} from "../../types/generated/MatchResponse.ts";
import {ConnectToWebSocketSTOMP} from "../../utils/websocketConnection.ts";
import {getMyLiveMatches} from "../../api/liveMatchApi.ts";
import {MatchCard} from "../../components/MatchDetailsComponent.tsx";
import {useNavigate} from "react-router-dom";
import {MatchStatusEnum} from "../../enums/generated/MatchStatusEnum.ts";
import {getMyClub} from "../../api/clubApi.ts";

export const LiveIndex : React.FC = () => {
    const [matchs, setMatchs] = useState<MatchResponse[]>([]);
    const navigate = useNavigate();
    useEffect(() => {
        const subForNotif = async () => {
            const matchsData = await getMyLiveMatches();
            const clubData = await getMyClub();
            //const clubData = {clubId : 2};
            if (matchsData) {
                setMatchs(matchsData);
                const client = ConnectToWebSocketSTOMP();
                client.onConnect = () => {
                    console.log("Connected to live matches ")
                    client.subscribe(`/topic/notif-live-match/${clubData.clubId}`,(message) => {
                        try {
                            const match: MatchResponse = JSON.parse(message.body);
                            setMatchs(prev => {

                                if (match.status === MatchStatusEnum.FINISHED) {
                                    return prev.filter(m => m.idMatch !== match.idMatch);
                                }

                                const index = prev.findIndex(m => m.idMatch === match.idMatch);
                                if (index !== -1) {
                                    const updated = [...prev];
                                    updated[index] = match;
                                    return updated;
                                }
                                return [...prev, match];
                            });
                        } catch (e) {
                            console.error(e);
                        }
                    });
                }
                client.activate();
            }
        }
        subForNotif();
    }, []);

    if (matchs.length === 0){
        return <div>Aucun match en direct</div>
    }

    return (
        <div className="grid grid-cols-3 ml-4 gap-4 mt-12">
            {matchs.map(m => (
                <div
                    key={m.idMatch}
                    onClick={() => navigate("/live/" + m.idMatch)}
                    className="cursor-pointer transition-transform hover:scale-105"
                >
                    <MatchCard match={m}/>
                </div>
            ))}
        </div>
    );
}