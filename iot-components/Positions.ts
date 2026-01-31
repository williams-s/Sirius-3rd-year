import {PositionEnum} from "./enums/generated/PositionEnum";

export const getPositionsWithPlacement = (side : string, maxWidth : number, maxHeight : number) : {position : PositionEnum, x : number, y : number}[] => {
    let defensiveLineXStart : number, midfieldLineXStart : number, attackingLineXStart : number, goalKeeperXStart : number;
    if (side === "LEFT") {
        defensiveLineXStart = 20;
        attackingLineXStart = maxWidth / 2 - 10;
        midfieldLineXStart = (defensiveLineXStart + attackingLineXStart) / 2;
        goalKeeperXStart = 8;
    } else {
        defensiveLineXStart = maxWidth - 20;
        attackingLineXStart = maxWidth / 2 + 10;
        midfieldLineXStart = (defensiveLineXStart + attackingLineXStart) / 2;
        goalKeeperXStart = maxWidth - 8;
    }
    return [
        {
            position: PositionEnum.GOALKEEPER,
            x: goalKeeperXStart,
            y: maxHeight / 2
        },
        {
            position: PositionEnum.LEFT_BACK,
            x: defensiveLineXStart,
            y: side === "LEFT" ? maxHeight - 5 : 5
        },
        {
            position: PositionEnum.RIGHT_BACK,
            x: defensiveLineXStart,
            y: side === "LEFT" ? 5 : maxHeight - 5
        },
        {
            position: PositionEnum.CENTER_BACK,
            x : defensiveLineXStart,
            y: maxHeight / 2 - 5
        },
        {
            position: PositionEnum.CENTER_BACK,
            x : defensiveLineXStart,
            y: maxHeight / 2 + 5
        },
        {
            position: PositionEnum.CENTER_MIDFIELDER,
            x : midfieldLineXStart,
            y: maxHeight / 2 - 5
        },
        {
            position: PositionEnum.CENTER_MIDFIELDER,
            x : midfieldLineXStart,
            y: maxHeight / 2 + 5
        },
        {
            position: PositionEnum.CENTER_ATTACKING_MIDFIELDER,
            x : (attackingLineXStart + midfieldLineXStart) / 2,
            y: maxHeight / 2
        },
        {
            position: PositionEnum.RIGHT_WINGER,
            x : attackingLineXStart,
            y: side === "LEFT" ? 5 : maxHeight - 5
        },
        {
            position: PositionEnum.LEFT_WINGER,
            x : attackingLineXStart,
            y: side === "LEFT" ? maxHeight - 5 : 5
        },
        {
            position: PositionEnum.STRIKER,
            x : attackingLineXStart,
            y: maxHeight / 2
        }
    ]
}


export const getPlacementByPosition = (side : string, maxWidth : number, maxHeight : number, position : PositionEnum) : {x : number, y : number} => {
    const positions = getPositionsWithPlacement(side, maxWidth, maxHeight);
    const positionWithPlacement = positions.find(p => p.position === position);
    return {x : positionWithPlacement.x, y : positionWithPlacement.y};
}