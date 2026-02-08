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


export const LiveMatchPage : React.FC = () => {
    const [playersPosition,setPlayersPosition] = useState<PlayerPosition[]>();
    const [ballEvent,setBallEvent] = useState<BallEvent>();
    const [matchState,setMatchState] = useState<MatchState>();
    const [isLoading, setIsLoading] = useState(true);
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
                }
            } catch (error) {
                if (axios.isAxiosError(error)){
                    if (error.response?.status === 404){

                    }
                    else {
                        console.error(error)
                    }
                }else {
                    console.error(error)
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
                    console.log(matchStateData);
                    setMatchState(matchStateData)
                } catch (error) {
                    console.error("Erreur de parsing du message:", error);
                }
            })
        }
        client.activate();

        return () => {
            client.deactivate();
        };
    }, []);


    if (isLoading || !playersPosition || !ballEvent) {
        return <div>Loading match data...</div>;
    }

    return (
        <div className="flex w-screen h-screen bg-slate-900">
            <div className="pt-4">
                <LiveMatchField playerPositions={playersPosition} ballEvent={ballEvent}/>
            </div>
            {
                matchState && <Scoreboard matchState={matchState}/>
            }
        </div>
    )

}