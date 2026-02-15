import React, {useEffect, useState} from "react";
import {TeamSelector} from "../../components/teams/TeamSelector.tsx";

export const PlayersIndex: React.FC = () => {
    return (
        <TeamSelector text={"Choisir une équipe pour voir ses joueurs"} navigateTo={"players"} />
    )
}