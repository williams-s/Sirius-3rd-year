import type {HeatMapPlayer} from "../../types/generated/HeatMapPlayer.ts";
import {FootballField, getLinesPosition} from "../FootballField.tsx";
import {useEffect, useState} from "react";
import {Stage} from "react-konva";
import {HeatMapOverlay} from "./HeatMapOverlay.tsx";

export const PlayerHeatMap = ({heatMapPlayer} : {heatMapPlayer : HeatMapPlayer}) => {

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
                <HeatMapOverlay
                    positions={heatMapPlayer.positions}
                    fieldDimensions={linesPosition}
                />
            </FootballField>
        </Stage>
    );
}