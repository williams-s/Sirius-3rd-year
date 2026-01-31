import type {MatchState} from "../types/generated/MatchState.ts";
import React from 'react';
import {Clock, RadioTower, CirclePause} from 'lucide-react';
import {convertDecimalTime} from "../utils/timeConverter.ts";
import {MatchEventEnum} from "../enums/generated/MatchEventEnum.ts";
import {MatchEventComponent} from "./MatchEventComponent.tsx";

export const Scoreboard = ({matchState}:{matchState:MatchState}) => {
    const homeTeam = matchState.score.homeTeam;
    const awayTeam = matchState.score.awayTeam;
    const matchTime = convertDecimalTime(matchState.match_time);
    const minutes = matchTime.minutes;
    const seconds = matchTime.seconds;

    const matchEvent = matchState.match_event;
    console.log(matchEvent);
    return (
        <div className="min-h-screen w-screen flex flex-col p-8">
            <div className="w-[80%] mx-auto">
                <div className="bg-white rounded-lg shadow mb-4">
                    <div className="bg-gray-800 text-white py-3 px-6 rounded-t-lg flex items-center justify-between">
                        <div className="flex items-center gap-2">
                            <Clock size={18} />
                            <span>{minutes}:{seconds}</span>
                        </div>
                        <div className="flex items-center gap-2">
                            <ScoreboardHeader matchEvent={matchEvent}/>
                        </div>
                    </div>

                    <div className="p-6">
                        <div className="grid grid-cols-3 gap-6 items-center">
                            <div className="text-center">
                                <h3 className="text-lg font-semibold text-gray-800 mb-3">{homeTeam.name}</h3>
                                <div className="text-5xl font-bold text-gray-900">{homeTeam.score}</div>
                            </div>

                            <div className="text-center text-gray-400 text-2xl font-medium">
                                -
                            </div>

                            <div className="text-center">
                                <h3 className="text-lg font-semibold text-gray-800 mb-3">{awayTeam.name}</h3>
                                <div className="text-5xl font-bold text-gray-900">{awayTeam.score}</div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            {matchEvent !== MatchEventEnum.TIME_UPDATE && (
                <MatchEventComponent matchEvent={matchEvent}/>
            )}
        </div>
    );
};

const ScoreboardHeader = ({matchEvent}:{matchEvent:MatchEventEnum}) => {
    switch (matchEvent){
        case MatchEventEnum.FULL_TIME:
            return (
                <>
                    <span>Match terminé</span>
                </>
            )
        case MatchEventEnum.HALF_TIME:
            return (
                <>
                    <CirclePause size={18}/>
                    <span>Mi-temps</span>
                </>
            )
        default:
            return (
                <>
                    <RadioTower size={18}/>
                    <div className="w-3 h-3 rounded-full animate-pulse bg-red-500"></div>
                    <span>En direct</span>
                </>
            )
    }
}