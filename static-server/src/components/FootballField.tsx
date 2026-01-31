import {Stage, Layer, Rect, Line, Circle} from 'react-konva';
import {useEffect, useState} from "react";
import {PlayerCircle} from "./PlayerCircle.tsx";
import {BallCircle} from "./BallCircle.tsx";
import type {PlayerPosition} from "../types/generated/PlayerPosition.ts";
import type {BallEvent} from "../types/generated/BallEvent.ts";

export function FootballField({ballEvent,playerPositions}: {ballEvent :BallEvent, playerPositions :PlayerPosition[]}) {


    const [firstTeamId, setFirstTeamId] = useState<number>(0);
    const [secondTeamId, setSecondTeamId] = useState<number>(0);

    const [dimensions, setDimensions] = useState({
        width: window.innerWidth /2,
        height: window.innerHeight /1.02
    });

    const fieldInformations = {
        x: 30,
        y: 0,
        width: dimensions.width - 50,
        height: dimensions.height - 20,
    };

    const linesPosition = {
        left: fieldInformations.x + 20,
        top: fieldInformations.y + 20,
        right: fieldInformations.width - 20,
        bot: fieldInformations.height - 20
    }

    const centerPoint = {
        x: (linesPosition.left + linesPosition.right) /2,
        y: (linesPosition.top + linesPosition.bot) /2,
    }

    const radiusCenterCircle = Math.min(fieldInformations.width, fieldInformations.height) * 0.15

    const penaltyAreaDimensions = {
        x: (linesPosition.right + linesPosition.left) / 3,
        width: (linesPosition.right + linesPosition.left) / 3,
        height: fieldInformations.height / 12
    }

    useEffect(() => {
        const handleResize = () => {
            setDimensions({
                width: window.innerWidth /2,
                height: window.innerHeight
            });
        };

        window.addEventListener('resize', handleResize);

        return () => window.removeEventListener('resize', handleResize);
    }, []);

    return (
        <Stage width={dimensions.width} height={dimensions.height}>
            <Layer x={fieldInformations.x} y={fieldInformations.y} >
                <Rect x={fieldInformations.x/2} width={fieldInformations.width} height={fieldInformations.height} fill="#2e7d32" />
                <Line points={[linesPosition.left, linesPosition.top,
                               linesPosition.right, linesPosition.top,
                               linesPosition.right,linesPosition.bot,
                               linesPosition.left, linesPosition.bot,
                               linesPosition.left,linesPosition.top]}
                      stroke="white" strokeWidth={3} />

                <Rect x={penaltyAreaDimensions.x} y={linesPosition.top} width={penaltyAreaDimensions.width} height={penaltyAreaDimensions.height}
                      stroke="white" strokeWidth={2} />
                <Rect x={penaltyAreaDimensions.x} y={linesPosition.bot-penaltyAreaDimensions.height} width={penaltyAreaDimensions.width} height={penaltyAreaDimensions.height}
                      stroke="white" strokeWidth={2} />
                <Line points={[linesPosition.left,centerPoint.y,linesPosition.right,centerPoint.y]} stroke="white" strokeWidth={3}/>
                <Circle x={centerPoint.x} y={centerPoint.y} radius={radiusCenterCircle} stroke="white" strokeWidth={3}/>
                {playerPositions.map(p => {

                    if (firstTeamId === 0){
                        setFirstTeamId(p.teamId)
                    }
                    else {
                        if (secondTeamId === 0){
                            if (p.teamId !== firstTeamId)
                                setSecondTeamId(p.teamId)
                        }
                    }
                    return (
                    <PlayerCircle player={p} fieldDimensions={linesPosition} teamIds={{firstTeamId, secondTeamId}}/>
                    )
                })}
                <BallCircle ball={ballEvent} fieldDimensions={linesPosition}/>
            </Layer>
        </Stage>
    );
}