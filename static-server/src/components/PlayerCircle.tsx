import type {PlayerPosition} from "../types/generated/PlayerPosition.ts";
import type {Coordinates2D} from "../types/generated/Coordinates2D.ts";
import {Circle} from "react-konva";

export const PlayerCircle = (player: PlayerPosition, fieldDimensions ) => {
    const coords: Coordinates2D = player.player_coordinates;
    const normalizedCoords = {
        x: coords.x / fieldDimensions.bot * 105,
        y: coords.y / fieldDimensions.right * 68
    }
    return (
        <Circle x={normalizedCoords.x} y={normalizedCoords.y} fill={"blue"} radius={20}/>
    )
}