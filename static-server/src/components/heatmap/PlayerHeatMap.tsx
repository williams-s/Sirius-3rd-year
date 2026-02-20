import type { HeatMapPlayer } from "../../types/generated/HeatMapPlayer.ts";
import { FootballField, getLinesPosition } from "../FootballField.tsx";
import { useEffect, useRef, useState } from "react";
import { Stage } from "react-konva";
import { HeatMapOverlay } from "./HeatMapOverlay.tsx";
import { ConnectToWebSocketSTOMP } from "../../utils/websocketConnection.ts";
import { liveMatchTopic } from "../../utils/topics.ts";

type Props = {
    matchId: string;
    playerId: number;
    width?: number;
    height?: number;
};

export const PlayerHeatMap = ({
      matchId,
      playerId,
      width,
      height
  }: Props) => {

    const containerRef = useRef<HTMLDivElement>(null);
    const [heatMapPlayer, setHeatMapPlayer] = useState<HeatMapPlayer>();
    const [dimensions, setDimensions] = useState({
        width: width || 0,
        height: height || 0
    });

    useEffect(() => {
        if (width && height) {
            setDimensions({ width, height });
            return;
        }

        const resize = () => {
            if (containerRef.current) {
                setDimensions({
                    width: containerRef.current.offsetWidth,
                    height: containerRef.current.offsetHeight
                });
            }
        };

        resize();
        window.addEventListener("resize", resize);
        return () => window.removeEventListener("resize", resize);
    }, [width, height]);

    useEffect(() => {
        const client = ConnectToWebSocketSTOMP();

        client.onConnect = () => {
            client.subscribe(
                liveMatchTopic(matchId, "heat-map-player-position/" + playerId),
                (message) => {
                    try {
                        const data: HeatMapPlayer = JSON.parse(message.body);
                        setHeatMapPlayer(data);
                    } catch (error) {
                        console.error("Erreur parsing heatmap:", error);
                    }
                }
            );
        };

        client.activate();

        return () => {
            client.deactivate();
        };
    }, [matchId, playerId]);

    if (!heatMapPlayer) {
        return <div ref={containerRef} style={{ width: "100%", height: "100%" }}>Loading...</div>;
    }

    const fieldInformations = {
        x: 0,
        y: 0,
        width: dimensions.width,
        height: dimensions.height
    };

    const linesPosition = getLinesPosition(fieldInformations);

    return (
        <div ref={containerRef} style={{ width: "100%", height: "100%" }}>
            <Stage width={dimensions.width} height={dimensions.height}>
                <FootballField fieldInformations={fieldInformations}>
                    <HeatMapOverlay
                        positions={heatMapPlayer.positions}
                        fieldDimensions={linesPosition}
                    />
                </FootballField>
            </Stage>
        </div>
    );
};
