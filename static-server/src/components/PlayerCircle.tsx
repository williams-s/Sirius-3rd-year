import type {Coordinates2D} from "../types/generated/Coordinates2D.ts";
import {Circle, Text, Group} from "react-konva";
import type {PlayerPosition} from "../types/generated/PlayerPosition.ts";
import {FIELD_HEIGHT, FIELD_WIDTH} from "../constants/FieldConstants.ts";

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
        teamIds,
        shirtNumber
    } : {
        player : PlayerPosition,
        fieldDimensions : FieldDimensions,
        teamIds : TeamIds,
        shirtNumber : number | null
    }
) => {
    const coords: Coordinates2D = player.playerCoordinates;
    const normalizedCoords = {
        y: coords.x * fieldDimensions.bot / FIELD_WIDTH,
        x: coords.y * (fieldDimensions.right) / FIELD_HEIGHT
    }

    return (
        <Group x={normalizedCoords.x} y={normalizedCoords.y}>
            <Circle fill={player.teamId === teamIds.firstTeamId ? "blue" : "red"} radius={20}/>
            {shirtNumber !== null && (
                <Text
                    text={String(shirtNumber)}
                    fill="white"
                    fontSize={12}
                    fontStyle="bold"
                    align="center"
                    width={40}
                    x={-20}
                    y={-7}
                />
            )}
        </Group>
    )
}