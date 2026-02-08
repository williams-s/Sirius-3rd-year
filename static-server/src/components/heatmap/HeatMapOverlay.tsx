import {Rect} from 'react-konva';
import {useMemo} from 'react';

interface HeatMapOverlayProps {
    positions: number[][];
    fieldDimensions: {
        left: number;
        top: number;
        right: number;
        bot: number;
    };
}

export function HeatMapOverlay({positions, fieldDimensions}: HeatMapOverlayProps) {
    const maxValue = useMemo(() => {
        return Math.max(...positions.flat());
    }, [positions]);

    const rows = positions.length;
    const cols = positions[0]?.length || 0;

    const fieldWidth = fieldDimensions.right - fieldDimensions.left;
    const fieldHeight = fieldDimensions.bot - fieldDimensions.top;

    const cellWidth = fieldWidth / cols;
    const cellHeight = fieldHeight / rows;

    const getColor = (value: number): string => {
        if (value === 0) return 'rgba(0, 0, 0, 0)';

        const intensity = value / maxValue;

        if (intensity < 0.33) {
            const alpha = 0.3 + (intensity / 0.33) * 0.3;
            return `rgba(0, 150, 255, ${alpha})`;
        } else if (intensity < 0.66) {
            const alpha = 0.4 + ((intensity - 0.33) / 0.33) * 0.3;
            return `rgba(255, 200, 0, ${alpha})`;
        } else {
            const alpha = 0.5 + ((intensity - 0.66) / 0.34) * 0.4;
            return `rgba(255, 0, 0, ${alpha})`;
        }
    };

    return (
        <>
            {positions.map((row, i) =>
                row.map((value, j) => (
                    <Rect
                        key={`${i}-${j}`}
                        x={fieldDimensions.left + j * cellWidth}
                        y={fieldDimensions.top + i * cellHeight}
                        width={cellWidth}
                        height={cellHeight}
                        fill={getColor(value)}
                    />
                ))
            )}
        </>
    );
}