import type {Stats} from "../../types/generated/Stats.ts";

export const StatsComponent = ({stats} : {stats : Stats | null}) => {
    if (!stats) return <p className="text-gray-400 text-sm">Loading stats...</p>;

    const rows = [
        { label: "Goals",         value: stats.goals },
        { label: "Assists",       value: stats.assists },
        { label: "Shots",         value: `${stats.shotsOnTarget} / ${stats.shots}` },
        { label: "Passes",        value: `${stats.passesSuccess} / ${stats.passes}` },
        { label: "Tackles",       value: `${stats.tacklesSuccess} / ${stats.tackles}` },
        { label: "Duels",         value: `${stats.duelsWon} / ${stats.duels}` },
        { label: "Dribbles",      value: `${stats.dribblesSuccess} / ${stats.dribbles}` },
        { label: "Interceptions", value: stats.interceptions },
        { label: "Touches",       value: stats.touches },
        { label: "Fouls",         value: stats.fouls },
        { label: "Saves",         value: stats.saves },
        { label: "Distance",      value: `${stats.distanceCovered.toFixed(2)} m` },
    ];

    return (
        <div className="flex flex-col gap-1">
            {rows.map(({ label, value }) => (
                <div key={label} className="flex justify-between text-sm px-2 py-1 rounded hover:bg-white/5">
                    <span className="text-gray-400">{label}</span>
                    <span className="text-white font-medium">{value}</span>
                </div>
            ))}
        </div>
    );
}