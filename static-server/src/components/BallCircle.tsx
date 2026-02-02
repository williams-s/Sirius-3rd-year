import {Circle} from "react-konva";
import type {BallEvent} from "../types/generated/BallEvent.ts";
import {FIELD_HEIGHT, FIELD_WIDTH} from "../constants/FieldConstants.ts";

interface FieldDimensions {
    bot : number;
    right : number;
}

export const BallCircle = ({
    ball,
    fieldDimensions
}:{ball:BallEvent, fieldDimensions: FieldDimensions}
) => {
    const ballCoordinates = ball.ballCoordinates;
    const normalizedCoords = {
        y: ballCoordinates.x * fieldDimensions.bot / FIELD_WIDTH,
        x: ballCoordinates.y * (fieldDimensions.right + 50) / FIELD_HEIGHT
    }
    return (
        <Circle x={normalizedCoords.x} y={normalizedCoords.y} fill={"white"} radius={8}/>
    )
}