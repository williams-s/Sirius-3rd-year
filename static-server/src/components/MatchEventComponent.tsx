import {MatchEventEnum} from "../enums/generated/MatchEventEnum.ts";

export const MatchEventComponent = ({matchEvent}:{matchEvent:MatchEventEnum}) => {
    let textToDisplay = ""
    switch (matchEvent) {
        case MatchEventEnum.HALF_TIME:
            textToDisplay = "Mi-temps !"
            break;
        case MatchEventEnum.FULL_TIME:
            textToDisplay = "Fin du match !"
            break;
        case MatchEventEnum.SECOND_HALF_KICK_OFF:
            textToDisplay = "Début de la seconde mi-temps !"
            break;
        case MatchEventEnum.KICK_OFF:
            textToDisplay = "Début du match !"
            break;
        case MatchEventEnum.SCORE_UPDATE:
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