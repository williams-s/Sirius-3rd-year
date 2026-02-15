import {Layer, Rect, Line, Circle} from 'react-konva';
import {
    FIELD_HEIGHT,
    FIELD_WIDTH,
    GOAL_START_Y,
    GOAL_WIDTH,
    PENALTY_AREA_START_Y,
    PENALTY_AREA_WIDTH,
    PENALTY_AREA_DEPTH,
    GOAL_AREA_START_Y,
    GOAL_AREA_WIDTH,
    GOAL_AREA_DEPTH,
    PENALTY_SPOT_DISTANCE
} from "../constants/FieldConstants.ts";
import type {ReactNode} from "react";

interface FootballFieldBaseProps {
    fieldInformations: {
        x: number;
        y: number;
        width: number;
        height: number;
    };
    children?: ReactNode;
}

export function FootballField({fieldInformations, children}: FootballFieldBaseProps) {
    const linesPosition = {
        left: fieldInformations.x + 20,
        top: fieldInformations.y + 20,
        right: fieldInformations.width - 20,
        bot: fieldInformations.height - 20
    };

    const centerPoint = {
        x: (linesPosition.left + linesPosition.right) / 2,
        y: (linesPosition.top + linesPosition.bot) / 2,
    };

    const fieldScreenWidth = linesPosition.right - linesPosition.left;
    const fieldScreenHeight = linesPosition.bot - linesPosition.top;

    const scaleX = fieldScreenWidth / FIELD_HEIGHT;
    const scaleY = fieldScreenHeight / FIELD_WIDTH;

    const radiusCenterCircle = Math.min(fieldInformations.width, fieldInformations.height) * 0.15;

    return (
        <Layer x={fieldInformations.x} y={fieldInformations.y}>
            <Rect
                x={fieldInformations.x / 2}
                width={fieldInformations.width}
                height={fieldInformations.height}
                fill="#2e7d32"
            />
            <Line
                points={[
                    linesPosition.left, linesPosition.top,
                    linesPosition.right, linesPosition.top,
                    linesPosition.right, linesPosition.bot,
                    linesPosition.left, linesPosition.bot,
                    linesPosition.left, linesPosition.top
                ]}
                stroke="white"
                strokeWidth={3}
            />
            <Rect
                x={PENALTY_AREA_START_Y * scaleX + linesPosition.left}
                y={linesPosition.top}
                width={PENALTY_AREA_WIDTH * scaleX}
                height={PENALTY_AREA_DEPTH * scaleY}
                stroke="white"
                strokeWidth={2}
            />
            <Rect
                x={PENALTY_AREA_START_Y * scaleX + linesPosition.left}
                y={linesPosition.bot - PENALTY_AREA_DEPTH * scaleY}
                width={PENALTY_AREA_WIDTH * scaleX}
                height={PENALTY_AREA_DEPTH * scaleY}
                stroke="white"
                strokeWidth={2}
            />
            <Rect
                x={GOAL_AREA_START_Y * scaleX + linesPosition.left}
                y={linesPosition.top}
                width={GOAL_AREA_WIDTH * scaleX}
                height={GOAL_AREA_DEPTH * scaleY}
                stroke="white"
                strokeWidth={2}
            />
            <Rect
                x={GOAL_AREA_START_Y * scaleX + linesPosition.left}
                y={linesPosition.bot - GOAL_AREA_DEPTH * scaleY}
                width={GOAL_AREA_WIDTH * scaleX}
                height={GOAL_AREA_DEPTH * scaleY}
                stroke="white"
                strokeWidth={2}
            />
            <Circle
                x={centerPoint.x}
                y={linesPosition.top + PENALTY_SPOT_DISTANCE * scaleY}
                radius={3}
                fill="white"
            />
            <Circle
                x={centerPoint.x}
                y={linesPosition.bot - PENALTY_SPOT_DISTANCE * scaleY}
                radius={3}
                fill="white"
            />
            <Rect
                x={GOAL_START_Y * scaleX + linesPosition.left}
                y={linesPosition.top - 5}
                width={GOAL_WIDTH * scaleX}
                height={5}
                stroke="white"
                strokeWidth={2}
                fill="white"
            />
            <Rect
                x={GOAL_START_Y * scaleX + linesPosition.left}
                y={linesPosition.bot}
                width={GOAL_WIDTH * scaleX}
                height={5}
                stroke="white"
                strokeWidth={2}
                fill="white"
            />
            <Line
                points={[linesPosition.left, centerPoint.y, linesPosition.right, centerPoint.y]}
                stroke="white"
                strokeWidth={3}
            />
            <Circle
                x={centerPoint.x}
                y={centerPoint.y}
                radius={radiusCenterCircle}
                stroke="white"
                strokeWidth={3}
            />
            {children}
        </Layer>
    );
}

export function getLinesPosition(fieldInformations: {x: number, y: number, width: number, height: number}) {
    return {
        left: fieldInformations.x + 20,
        top: fieldInformations.y + 20,
        right: fieldInformations.width - 20,
        bot: fieldInformations.height - 20
    };
}