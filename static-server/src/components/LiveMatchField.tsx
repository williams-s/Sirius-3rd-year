import {Stage} from 'react-konva';
import {useEffect, useState} from "react";
import {PlayerCircle} from "./PlayerCircle.tsx";
import {BallCircle} from "./BallCircle.tsx";
import {FootballField, getLinesPosition} from "./FootballField.tsx";
import type {PlayerPosition} from "../types/generated/PlayerPosition.ts";
import type {BallEvent} from "../types/generated/BallEvent.ts";

export function LiveMatchField({ballEvent, playerPositions}: {
    ballEvent: BallEvent,
    playerPositions: PlayerPosition[]
}) {
    const [firstTeamId, setFirstTeamId] = useState<number>(0);
    const [secondTeamId, setSecondTeamId] = useState<number>(0);

    const [dimensions, setDimensions] = useState({
        width: window.innerWidth / 2,
        height: window.innerHeight / 1.02
    });

    const fieldInformations = {
        x: 30,
        y: 0,
        width: dimensions.width - 50,
        height: dimensions.height - 20,
    };

    const linesPosition = getLinesPosition(fieldInformations);

    useEffect(() => {
        if (playerPositions.length > 0) {
            const teams = new Set(playerPositions.map(p => p.teamId));
            const teamArray = Array.from(teams);
            if (teamArray.length >= 1 && firstTeamId === 0) setFirstTeamId(teamArray[0]);
            if (teamArray.length >= 2 && secondTeamId === 0) setSecondTeamId(teamArray[1]);
        }
    }, [playerPositions]);

    useEffect(() => {
        const handleResize = () => {
            setDimensions({
                width: window.innerWidth / 2,
                height: window.innerHeight
            });
        };

        window.addEventListener('resize', handleResize);
        return () => window.removeEventListener('resize', handleResize);
    }, []);

    return (
        <Stage width={dimensions.width} height={dimensions.height}>
            <FootballField fieldInformations={fieldInformations}>
                {playerPositions.map((p) => (
                    <PlayerCircle
                        key={p.playerId}
                        player={p}
                        fieldDimensions={linesPosition}
                        teamIds={{firstTeamId, secondTeamId}}
                    />
                ))}
                <BallCircle ball={ballEvent} fieldDimensions={linesPosition}/>
            </FootballField>
        </Stage>
    );
}