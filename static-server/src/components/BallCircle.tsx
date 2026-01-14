import {Circle} from "react-konva";
import type {BallEvent} from "../types/generated/BallEvent.ts";

interface FieldDimensions {
    bot : number;
    right : number;
}

export const BallCircle = ({
    ball,
    fieldDimensions
}:{ball:BallEvent, fieldDimensions: FieldDimensions}
) => {
    const ballCoordinates = ball.ball_coordinates;
    const normalizedCoords = {
        y: ballCoordinates.x * fieldDimensions.bot / 105,
        x: ballCoordinates.y * fieldDimensions.right / 68
    }
    return (
        <Circle x={normalizedCoords.x} y={normalizedCoords.y} fill={"white"} radius={8}/>
    )
}