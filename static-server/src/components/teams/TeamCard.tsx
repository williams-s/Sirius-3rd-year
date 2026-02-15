import type {TeamResponse} from "../../types/generated/TeamResponse.ts";

export const TeamCard = ({ team } : {team : TeamResponse}) => {
    return (
        <div className="bg-gray-800 rounded-xl p-4 border transition-colors">
            <div className="flex items-center gap-3">
                <div className="flex flex-col gap-1">
                    <h2 className="text-white font-bold ">{team.name}</h2>
                    <p className="text-gray-400 text-sm">{team.stadium}</p>
                    <p className="text-gray-400 text-sm">{team.league}</p>
                    <p className="text-gray-400 text-sm">{team.coach}</p>
                </div>
            </div>
        </div>
    );
};