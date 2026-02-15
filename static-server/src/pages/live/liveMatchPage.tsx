import React,{useState, useEffect} from "react";
import {ConnectToWebSocketSTOMP} from "../../utils/websocketConnection.ts";
import {useParams} from "react-router-dom";
import type {PlayerPosition} from "../../types/generated/PlayerPosition.ts";
import type {BallEvent} from "../../types/generated/BallEvent.ts";
import {liveMatchTopic} from "../../utils/topics.ts";
import type {MatchState} from "../../types/generated/MatchState.ts";
import {Scoreboard} from "../../components/Scoreboard.tsx";
import {LiveMatchField} from "../../components/LiveMatchField.tsx";
import {getCurrentLiveMatchDetails} from "../../api/liveMatchApi.ts";
import axios from "axios";
import {getMatch} from "../../api/matchApi.ts";
import type {MatchResponse} from "../../types/generated/MatchResponse.ts";
import {MatchCard} from "../../components/MatchDetailsComponent.tsx";
import type {PlayerResponse} from "../../types/generated/PlayerResponse.ts";
import {PlayerCardForMatch} from "../../components/players/PlayerCardForMatch.tsx";


export const LiveMatchPage : React.FC = () => {
    const [playersPosition,setPlayersPosition] = useState<PlayerPosition[]>();
    const [ballEvent,setBallEvent] = useState<BallEvent>();
    const [matchState,setMatchState] = useState<MatchState>();
    const [matchDetails, setMatchDetails] = useState<MatchResponse>();
    const [isLoading, setIsLoading] = useState(true);
    const [players, setPlayers] = useState<PlayerResponse[]>();
    const matchId = useParams().matchId;
    useEffect(() => {
        //console.log("Live match page")
        const client = ConnectToWebSocketSTOMP();
        if (!matchId) {
            return;
        }
        client.onConnect = async () => {
            console.log("STOMP connecté");
            try {
                const data = await getCurrentLiveMatchDetails(Number(matchId));
                if (data) {
                    setBallEvent(data.ballEvent);
                    setMatchState(data.matchState);
                    setPlayersPosition(data.playersPositions);
                    setPlayers(data.matchSheet);
                    console.log(data.matchSheet);
                }
            } catch (error) {
                if (axios.isAxiosError(error)){
                    if (error.response?.status === 404){
                        try {
                            const data = await getMatch(Number(matchId));
                            if (data){
                                setMatchDetails(data);
                            }
                        } catch (e) {
                            console.error(e);
                        }
                    }
                    else {
                        console.error(error);
                    }
                }else {
                    console.error(error);
                }
            } finally {
                setIsLoading(false);
            }
            client.subscribe(liveMatchTopic(matchId,"players-position"), (message) => {
                try {
                    const playerPositionsData: PlayerPosition[] = JSON.parse(message.body);
                    //console.log(playerPositionsData);
                    setPlayersPosition(playerPositionsData);
                } catch (error) {
                    console.error("Erreur de parsing du message:", error);
                }
            });
            client.subscribe(liveMatchTopic(matchId,"ball-events"), (message) => {
                try {
                    const ballEventData: BallEvent = JSON.parse(message.body);
                    //console.log(ballEvent);
                    setBallEvent(ballEventData);
                } catch (error) {
                    console.error("Erreur de parsing du message:", error);
                }
            });
            client.subscribe(liveMatchTopic(matchId,"match-state"), (message) => {
                try {
                    const matchStateData: MatchState = JSON.parse(message.body);
                    //console.log(matchStateData);
                    setMatchState(matchStateData)
                } catch (error) {
                    console.error("Erreur de parsing du message:", error);
                }
            });
            client.subscribe(liveMatchTopic(matchId,"match-sheet"), (message) => {
                try {
                    const matchSheetData: PlayerResponse[] = JSON.parse(message.body);
                    console.log(matchSheetData);
                    setPlayers(matchSheetData);
                } catch (error){
                    console.error("Erreur ",error);
                }
            });
        }
        client.activate();

        return () => {
            client.deactivate();
        };
    }, []);


    if (isLoading) {
        return <div>Loading match data...</div>;
    }

    if (matchDetails && (!playersPosition && !ballEvent)){
        return (
            <div className="flex w-screen h-screen bg-slate-400 flex-col justify-center items-center">
                <MatchCard match={matchDetails}/>
            </div>
        )
    }

    if (!playersPosition || !ballEvent){
        return (
            <div>Not working</div>
        )
    }
    const teamIds = players ? [...new Set(playersPosition.map(p => p.teamId))].sort() : [];
    const teamA = players?.filter(p => p.teamId === teamIds[0]) ?? [];
    const teamB = players?.filter(p => p.teamId === teamIds[1]) ?? [];

    return (
        <div className="flex w-full h-full bg-slate-400 overflow-hidden">

            <div className="pt-4 flex-shrink-0 overflow-hidden h-full">
                <LiveMatchField
                    playerPositions={playersPosition}
                    ballEvent={ballEvent}
                />
            </div>

            <div className="flex flex-col flex-1 min-w-0 ml-6 overflow-hidden">

                {matchState && (
                    <div className="flex-shrink-0 pt-4">
                        <Scoreboard matchState={matchState}/>
                    </div>
                )}

                <div className="flex flex-1 gap-4 mt-4 overflow-hidden">

                    <div className="flex flex-col flex-1 overflow-y-auto space-y-2">
                        <h2 className="text-sm font-bold uppercase text-white tracking-widest mb-1 sticky top-0 bg-slate-400 pb-1">
                            {matchState?.score.homeTeam.name ?? `Équipe ${teamIds[0]}`}
                        </h2>
                        {teamA.map(p => (
                            <PlayerCardForMatch key={p.playerId} player={p} color="blue" />
                        ))}
                    </div>

                    <div className="w-px bg-slate-500 flex-shrink-0" />

                    <div className="flex flex-col flex-1 overflow-y-auto space-y-2">
                        <h2 className="text-sm font-bold uppercase text-white tracking-widest mb-1 sticky top-0 bg-slate-400 pb-1">
                            {matchState?.score.awayTeam.name ?? `Équipe ${teamIds[1]}`}
                        </h2>
                        {teamB.map(p => (
                            <PlayerCardForMatch key={p.playerId} player={p} color="red"/>
                        ))}
                    </div>

                </div>
            </div>

        </div>
    );
}