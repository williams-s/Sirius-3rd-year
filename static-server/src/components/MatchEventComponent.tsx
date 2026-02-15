import {MatchStateEnum} from "../enums/generated/MatchStateEnum.ts";

export const MatchEventComponent = ({matchStateEnum}:{matchStateEnum:MatchStateEnum}) => {
    let textToDisplay = ""
    switch (matchStateEnum) {
        case MatchStateEnum.HALF_TIME:
            textToDisplay = "Mi-temps !"
            break;
        case MatchStateEnum.FULL_TIME:
            textToDisplay = "Fin du match !"
            break;
        case MatchStateEnum.SECOND_HALF_KICK_OFF:
            textToDisplay = "Début de la seconde mi-temps !"
            break;
        case MatchStateEnum.KICK_OFF:
            textToDisplay = "Début du match !"
            break;
        case MatchStateEnum.SCORE_UPDATE:
            textToDisplay = "BUUUUUUUUT !"
            break;
        default:
            textToDisplay = ""
            break;
    }

    return (
        <div className="w-full mx-auto mt-2 bg-gray-200 rounded-2xl p-1">
            <div className="text-center text-2xl font-bold text-black">
                {textToDisplay}
            </div>
        </div>
    )
}