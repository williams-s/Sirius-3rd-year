import type {Coordinates2D} from "../types/generated/Coordinates2D.ts";
import {Circle} from "react-konva";
import type {PlayerLiveMatchDetail} from "../types/generated/PlayerLiveMatchDetail.ts";

interface FieldDimensions {
    bot : number;
    right : number;
}

export const PlayerCircle = (
    {
        player,
        fieldDimensions
    } : {player : PlayerLiveMatchDetail, fieldDimensions : FieldDimensions}
) => {
    const coords: Coordinates2D = player.player_position_data.player_coordinates;
    const normalizedCoords = {
        y: coords.x * fieldDimensions.bot / 105,
        x: coords.y * fieldDimensions.right / 68
    }
    return (
        <Circle x={normalizedCoords.x} y={normalizedCoords.y} fill={"blue"} radius={20}/>
    )
}