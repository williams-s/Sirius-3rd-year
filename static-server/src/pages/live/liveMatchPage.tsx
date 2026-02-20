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
import {PlayerHeatMap} from "../../components/heatmap/PlayerHeatMap.tsx";
import {getPlayer} from "../../api/playerApi.ts";


export const LiveMatchPage : React.FC = () => {
    const [playersPosition,setPlayersPosition] = useState<PlayerPosition[]>();
    const [ballEvent,setBallEvent] = useState<BallEvent>();
    const [matchState,setMatchState] = useState<MatchState>();
    const [matchDetails, setMatchDetails] = useState<MatchResponse>();
    const [isLoading, setIsLoading] = useState(true);
    const [players, setPlayers] = useState<PlayerResponse[]>();
    const matchId = useParams().matchId;
    const [authorized,setAuthorized] = useState(false);
    const [selectedPlayer, setSelectedPlayer] = useState<PlayerResponse | null>(null);
    const [showStats, setShowStats] = useState(false);
    const [showHeatMap, setShowHeatMap] = useState(false);
    const [authorizedToSeePlayer, setAuthorizedToSeePlayer] = useState(false);
    useEffect(() => {
        if (!matchId) {
            return;
        }
        const fetchLiveMatch = async () => {
            try {
                const data = await getCurrentLiveMatchDetails(Number(matchId));
                setAuthorized(true);
                if (data) {
                    setBallEvent(data.ballEvent);
                    setMatchState(data.matchState);
                    setPlayersPosition(data.playersPositions);
                    setPlayers(data.matchSheet);
                }
            } catch (error) {
                if (axios.isAxiosError(error)) {
                    if (error.response?.status === 410) {
                        setAuthorized(true);
                        try {
                            const data = await getMatch(Number(matchId));
                            if (data)
                                setMatchDetails(data);
                        } catch (e) {
                            console.error(e);
                        }
                    } else {
                        //setAuthorized(true);
                        setAuthorized(false);
                        return;
                    }
                }
            } finally {
                setIsLoading(false);
            }

            const client = ConnectToWebSocketSTOMP();
            client.onConnect = () => {
                console.log("STOMP connecté");
                client.subscribe(liveMatchTopic(matchId, "players-position"), (message) => {
                    const playerPositionsData: PlayerPosition[] = JSON.parse(message.body);
                    setPlayersPosition(playerPositionsData);
                });
                client.subscribe(liveMatchTopic(matchId, "ball-events"), (message) => {
                    const ballEventData: BallEvent = JSON.parse(message.body);
                    setBallEvent(ballEventData);
                });
                client.subscribe(liveMatchTopic(matchId, "match-state"), (message) => {
                    const matchStateData: MatchState = JSON.parse(message.body);
                    setMatchState(matchStateData);
                });
                client.subscribe(liveMatchTopic(matchId, "match-sheet"), (message) => {
                    const matchSheetData: PlayerResponse[] = JSON.parse(message.body);
                    setPlayers(matchSheetData);
                });
            };

            client.activate();

            return () => {
                client.deactivate();
            };
        }
        fetchLiveMatch();
    }, []);



    useEffect(() => {
        if (!selectedPlayer) {
            return;
        }

        const fetchPlayer = async () => {
            try {
                const data = await getPlayer(selectedPlayer.playerId);
                if (data) {
                    setAuthorizedToSeePlayer(true);
                    setShowStats(true);
                    setShowHeatMap(false);
                }
            } catch (error) {
                console.error("Erreur getPlayer:", error);
                //setAuthorizedToSeePlayer(true);
                setShowStats(false);
                setShowHeatMap(false);
                setAuthorizedToSeePlayer(false);
                setSelectedPlayer(null);
            }
        }
        fetchPlayer();

    }, [selectedPlayer]);


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

    if (!authorized){
        return (
            <div>Accès refusé</div>
        )
    }

    if (!playersPosition || !ballEvent){
        return (
            <div>Pas de données pour l'instant</div>
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
                            <div onClick={() => setSelectedPlayer(p)} style={{cursor: "pointer"}}>
                                <PlayerCardForMatch key={p.playerId} player={p} color="blue" />
                            </div>
                        ))}
                    </div>


                    <div className="w-px bg-slate-500 flex-shrink-0" />

                    <div className="flex flex-col flex-1 overflow-y-auto space-y-2">
                        <h2 className="text-sm font-bold uppercase text-white tracking-widest mb-1 sticky top-0 bg-slate-400 pb-1">
                            {matchState?.score.awayTeam.name ?? `Équipe ${teamIds[1]}`}
                        </h2>
                        {teamB.map(p => (
                            <div onClick={() => setSelectedPlayer(p)} style={{cursor: "pointer"}}>
                                <PlayerCardForMatch key={p.playerId} player={p} color="red"/>
                            </div>
                        ))}
                    </div>

                </div>
            </div>
            {selectedPlayer && (
                authorizedToSeePlayer && (
                <div className="fixed inset-0 flex items-center justify-center">
                    <div className="bg-slate-800 p-6 w-[80vw] h-[90vh]">
                        <div className="flex gap-20">
                            <button
                                onClick={() => {
                                    setSelectedPlayer(null);
                                    setShowHeatMap(false);
                                    setShowStats(false);
                                }}>
                                ✕
                            </button>
                            <button onClick={() => {
                                setShowStats(true)
                                setShowHeatMap(false)
                            }}
                            >Stats</button>
                            <button onClick={() => {
                                setShowHeatMap(true)
                                setShowStats(false)
                            }}
                            >Heatmap</button>
                        </div>

                        <h2 className="text-white text-xl font-bold mb-4 text-center">
                            {selectedPlayer.firstName} {selectedPlayer.name}
                        </h2>

                        <div className="w-full h-[90%]">
                            {
                                showHeatMap &&
                                <PlayerHeatMap
                                    matchId={matchId!}
                                    playerId={selectedPlayer.playerId}
                                />
                            }
                            {
                                showStats &&
                                <div>
                                    <h2 className="text-white text-xl font-bold mb-4 text-center">
                                        Stats
                                    </h2>
                                </div>
                            }
                        </div>

                    </div>
                </div>
                )
            )}
        </div>
    );
}