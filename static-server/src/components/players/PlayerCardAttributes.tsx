import type { PlayerAttributes } from "../../types/generated/PlayerAttributes.ts";

export const PlayerCardAttributes = ({ player }: { player: PlayerAttributes }) => {
    return (
        <div className="bg-gray-800 rounded-xl p-4 border border-gray-700 transition-colors">
            <div className="flex items-center gap-3">
                <div className="flex flex-col gap-1">
                    <h2 className="text-white font-bold">
                        {player.firstName} <span className="uppercase">{player.name}</span>
                    </h2>
                    <p className="text-gray-400 text-sm">{player.nationality}</p>
                    <p className="text-gray-400 text-sm">{player.position} {player.strongFoot}</p>
                    <p className="text-gray-400 text-sm"> {player.height} cm  {player.weight} kg</p>
                </div>
            </div>
        </div>
    );
};