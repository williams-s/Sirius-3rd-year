export const getPositionsWithPlacement = (side, maxWidth, maxHeight) => {
    let defensiveLineXStart, midfieldLineXStart, attackingLineXStart, goalKeeperXStart;
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
            position: "GOALKEEPER",
            x: goalKeeperXStart,
            y: maxHeight / 2
        },
        {
            position: "LEFT_BACK",
            x: defensiveLineXStart,
            y: side === "LEFT" ? maxHeight - 5 : 5
        },
        {
            position: "RIGHT_BACK",
            x: defensiveLineXStart,
            y: side === "LEFT" ? 5 : maxHeight - 5
        },
        {
            position: "CENTER_BACK",
            x : defensiveLineXStart,
            y: maxHeight / 2 - 5
        },
        {
            position: "CENTER_BACK",
            x : defensiveLineXStart,
            y: maxHeight / 2 + 5
        },
        {
            position: "CENTER_MIDFIELDER",
            x : midfieldLineXStart,
            y: maxHeight / 2 - 5
        },
        {
            position: "CENTER_MIDFIELDER",
            x : midfieldLineXStart,
            y: maxHeight / 2 + 5
        },
        {
            position: "CENTER_ATTACKING_MIDFIELDER",
            x : (attackingLineXStart + midfieldLineXStart) / 2,
            y: maxHeight / 2
        },
        {
            position: "RIGHT_WINGER",
            x : attackingLineXStart,
            y: side === "LEFT" ? 5 : maxHeight - 5
        },
        {
            position: "LEFT_WINGER",
            x : attackingLineXStart,
            y: side === "LEFT" ? maxHeight - 5 : 5
        },
        {
            position: "STRIKER",
            x : attackingLineXStart,
            y: maxHeight / 2
        }
    ]
}