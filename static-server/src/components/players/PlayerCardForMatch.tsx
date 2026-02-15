import type {PlayerResponse} from "../../types/generated/PlayerResponse.ts";

export const PlayerCardForMatch = ({ player, color } : {player : PlayerResponse, color: string}) => {
    return (
        <div className="group flex items-stretch rounded-md overflow-hidden shadow hover:shadow-md transition-all duration-200 hover:-translate-y-px">

            <div
                className="flex items-center justify-center transition-colors px-3 min-w-[44px]"
                style={{ backgroundColor: color }}
            >
                <span className="text-white font-black text-sm leading-none select-none">
                    {player.shirtNumber}
                </span>
            </div>

            <div
                className="w-2.5 flex-shrink-0 self-stretch"
                style={{ background: `linear-gradient(to bottom right, ${color} 50%, white 50%)` }}
            />

            <div className="flex flex-col justify-center py-1.5 pr-3 pl-1 flex-1 bg-white gap-0">
                <p className="font-semibold text-gray-800 text-xs leading-tight">
                    {player.firstName} <span className="uppercase">{player.name}</span>
                </p>
            </div>
        </div>
    );
};