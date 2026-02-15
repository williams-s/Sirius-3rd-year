import {TeamSelector} from "../../components/teams/TeamSelector.tsx";

export const MatchesIndex: React.FC = () => {
    return (
        <TeamSelector text={"Choisir une équipe pour voir ses matchs"} navigateTo={"matches"} />
    )
}