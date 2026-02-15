import type {MatchResponse} from "../types/generated/MatchResponse.ts";
import {MatchStatusEnum} from "../enums/generated/MatchStatusEnum.ts";
import {formatDate} from "../utils/dateFormat.ts";
import {Ban , RadioTower, Trophy, CalendarCheck } from "lucide-react";

export const MatchCard = ({match} : {match:MatchResponse}) => {

    const homeTeam = match.homeTeam;
    const awayTeam = match.awayTeam;


    return (
        <div className="w-full max-w-2xl">
            <div className="bg-white rounded-lg shadow mb-4">
                <div className="bg-gray-800 text-white py-3 px-6 rounded-t-lg flex items-center justify-between">
                    <div className="flex items-center gap-2">
                        <Trophy size={18}/>
                        <span>{match.competition} - {match.matchDay} - {match.season}</span>
                    </div>
                    <div className="flex items-center gap-2">
                        <Header matchStatus={match.status}/>
                    </div>
                </div>

                <div className="p-6">
                    <div className="grid grid-cols-3 gap-6 items-center">
                        <div className="text-center">
                            <h3 className="text-lg font-semibold text-gray-800 mb-3">{homeTeam.name}</h3>
                            <div className="text-5xl font-bold text-gray-900">{match.homeScore}</div>
                        </div>

                        <div className="text-center text-gray-400 text-2xl font-medium">
                            -
                        </div>

                        <div className="text-center">
                            <h3 className="text-lg font-semibold text-gray-800 mb-3">{awayTeam.name}</h3>
                            <div className="text-5xl font-bold text-gray-900">{match.awayScore}</div>
                        </div>
                    </div>
                </div>

                <div className="bg-gray-200 text-black font-bold py-3 px-6 rounded-b-lg flex items-center justify-center">
                    <div className="text-center">
                        <span>{formatDate(match.date)}</span>
                    </div>
                </div>

            </div>
        </div>
    )

};
const Header = ({matchStatus}:{matchStatus:MatchStatusEnum}) => {
    switch (matchStatus){
        case MatchStatusEnum.FINISHED:
            return (
                <>
                    <span>Match terminé</span>
                </>
            )
        case MatchStatusEnum.SCHEDULED:
            return (
                <>
                    <CalendarCheck size={18}/>
                    <span>Match planifié</span>
                </>
            )
        case MatchStatusEnum.CANCELLED:
            return (
                <>
                    <Ban size={18}/>
                    <span>Match annulé</span>
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