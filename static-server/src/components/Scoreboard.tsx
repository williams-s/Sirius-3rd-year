import type {MatchState} from "../types/generated/MatchState.ts";
import React from 'react';
import {Clock, RadioTower, CirclePause} from 'lucide-react';
import {convertDecimalTime} from "../utils/timeConverter.ts";
import {MatchStateEnum} from "../enums/generated/MatchStateEnum.ts";
import {MatchEventComponent} from "./MatchEventComponent.tsx";

export const Scoreboard = ({matchState}:{matchState:MatchState}) => {
    const homeTeam = matchState.score.homeTeam;
    const awayTeam = matchState.score.awayTeam;
    const matchTime = convertDecimalTime(matchState.matchTime);
    const minutes = matchTime.minutes;
    const seconds = matchTime.seconds;

    const matchStateEnum = matchState.matchStateEnum;
    return (
        <div className="flex flex-col p-4">
            <div className="w-full">
                <div className="bg-white rounded-lg shadow mb-4">
                    <div className="bg-gray-800 text-white py-3 px-6 rounded-t-lg flex items-center justify-between">
                        <div className="flex items-center gap-2">
                            <Clock size={18} />
                            <span>{minutes}:{seconds}</span>
                        </div>
                        <div className="flex items-center gap-2">
                            <ScoreboardHeader matchStateEnum={matchStateEnum}/>
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
            {matchStateEnum !== MatchStateEnum.TIME_UPDATE && (
                <MatchEventComponent matchStateEnum={matchStateEnum}/>
            )}
        </div>
    );
};

const ScoreboardHeader = ({matchStateEnum}:{matchStateEnum:MatchStateEnum}) => {
    switch (matchStateEnum){
        case MatchStateEnum.FULL_TIME:
            return (
                <>
                    <span>Match terminé</span>
                </>
            )
        case MatchStateEnum.HALF_TIME:
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