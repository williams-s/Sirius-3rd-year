import type {Coordinates2D} from "../types/generated/Coordinates2D.ts";
import {Circle} from "react-konva";
import type {PlayerPosition} from "../types/generated/PlayerPosition.ts";

interface FieldDimensions {
    bot : number;
    right : number;
}

interface TeamIds {
    firstTeamId : number;
    secondTeamId : number;
}

export const PlayerCircle = (
    {
        player,
        fieldDimensions,
        teamIds
    } : {player : PlayerPosition, fieldDimensions : FieldDimensions, teamIds : TeamIds}
) => {
    const coords: Coordinates2D = player.playerCoordinates;
    const normalizedCoords = {
        y: coords.x * fieldDimensions.bot / 105,
        x: coords.y * fieldDimensions.right / 68
    }
    return (
        <Circle x={normalizedCoords.x} y={normalizedCoords.y} fill={player.teamId === teamIds.firstTeamId ? "blue" : "red"} radius={20}/>
    )
}