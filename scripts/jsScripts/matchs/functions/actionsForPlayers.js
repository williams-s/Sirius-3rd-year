//On definit les options pour les joueurs 
//Pour les milieux
const PASS_SUCCESSFUL_FOR_MIDFIELDER_RATE = {
    value : "PASS_SUCCESSFUL_FOR_MIDFIELDER_RATE", probability : 0.8, action: "pass",
    toPosition: {
        "MILIEU" : 0.7,
        "DEFENSEUR" : 0.8,
        "ATTAQUANT" : 0.35,
        "GARDIEN" : 0.1
    }
};
const DRIBBLE_SUCCESSFUL_FOR_MIDFIELDER_RATE = {
    value : "DRIBBLE_SUCCESSFUL_FOR_MIDFIELDER_RATE", probability : 0.6, action: "dribble"
};
const TACKLE_SUCCESSFUL_FOR_MIDFIELDER_RATE = {
    value : "TACKLE_SUCCESSFUL_FOR_MIDFIELDER_RATE", probability : 0.4, action: "tackle"
};
const SHOT_ON_TARGET_FOR_MIDFIELDER_RATE = {
    value : "SHOT_ON_TARGET_FOR_MIDFIELDER_RATE", probability : 0.1, action: "shot"
}
const SHOT_MISS_FOR_MIDFIELDER_RATE = {
    value : "SHOT_MISS_FOR_MIDFIELDER_RATE", probability : 0.3, action: "shot"
}


//Pour les attaquants
const SHOT_ON_TARGET_FOR_FORWARD_RATE = {
    value : "SHOT_ON_TARGET_FOR_FORWARD_RATE", probability : 0.4, action: "shot"
};
const SHOT_MISS_FOR_FORWARD_RATE = {
    value : "SHOT_MISS_FOR_FORWARD_RATE", probability : 0.3, action: "shot"
};
const PASS_SUCCESSFUL_FOR_FORWARD_RATE = {
    value : "PASS_SUCCESSFUL_FOR_FORWARD_RATE", probability : 0.6, action: "pass",
    toPosition: {
        "MILIEU" : 0.5,
        "DEFENSEUR" : 0.2,
        "ATTAQUANT" : 0.5,
        "GARDIEN" : 0.001
    }
};
const DRIBBLE_SUCCESSFUL_FOR_FORWARD_RATE = {
    value : "DRIBBLE_SUCCESSFUL_FOR_FORWARD_RATE", probability : 0.4, action: "dribble"
};
const TACKLE_SUCCESSFUL_FOR_FORWARD_RATE = {
    value : "TACKLE_SUCCESSFUL_FOR_FORWARD_RATE", probability : 0.2, action: "tackle"
};


//Pour les defenseurs
const TACKLE_SUCCESSFUL_FOR_DEFENDER_RATE = {
    value : "TACKLE_SUCCESSFUL_FOR_DEFENDER_RATE", probability : 0.7, action: "tackle"
};
const PASS_SUCCESSFUL_FOR_DEFENDER_RATE = {
    value : "PASS_SUCCESSFUL_FOR_DEFENDER_RATE", probability : 0.85, action: "pass",
    toPosition: {
        "MILIEU" : 0.6,
        "DEFENSEUR" : 0.8,
        "ATTAQUANT" : 0.2,
        "GARDIEN" : 0.9
    }
};
const DRIBBLE_SUCCESSFUL_FOR_DEFENDER_RATE = {
    value : "DRIBBLE_SUCCESSFUL_FOR_DEFENDER_RATE", probability : 0.6, action: "dribble"
};
const SHOT_ON_TARGET_FOR_DEFENDER_RATE = {
    value : "SHOT_ON_TARGET_FOR_DEFENDER_RATE", probability : 0.3, action: "shot"
};
const SHOT_MISS_FOR_DEFENDER_RATE = {
    value : "SHOT_MISS_FOR_DEFENDER_RATE", probability : 0.2, action: "shot"
};

//Pour les gardiens
const SAVE_SUCCESSFUL_FOR_GOALKEEPER_RATE = {
    value : "SAVE_SUCCESSFUL_FOR_GOALKEEPER_RATE", probability : 0.85, action: "save"
}

const PASS_SUCCESSFUL_FOR_GOALKEEPER_RATE = {
    value : "PASS_SUCCESSFUL_FOR_GOALKEEPER_RATE", probability : 0.95, action: "pass",
    toPosition: {
        "MILIEU" : 0.5,
        "DEFENSEUR" : 0.8,
        "ATTAQUANT" : 0.2
    }
}

//Pour les interceptions
const INTERCEPTION_SUCCESSFUL = {
    value : "INTERCEPTION_SUCCESSFUL", probability : 0.8, action: "interception",
    fromPosition : {
        "MILIEU" : 0.2,
        "DEFENSEUR" : 0.4,
        "ATTAQUANT" : 0.1,
        "GARDIEN" : 0.1
    }
};

const FOUL_COMMITTED = {
    value: "FOUL_COMMITTED", probability : 0.13, action: "foul"
}

//On définit les options d'attaques pour les joueurs,
//la proba signifie le taux de choix de l option comparee aux autres options
let optionsForMid = [
    {value : "DRIBBLE_OPTION_FOR_MIDFIELDER_RATE", probability : 0.5, action: "dribble"},
    {value : "PASS_OPTION_FOR_MIDFIELDER_RATE", probability : 3 , action: "pass", toPosition: "MILIEU"},
    {value : "PASS_OPTION_FOR_MIDFIELDER_RATE", probability : 1.3 , action: "pass", toPosition: "ATTAQUANT"},
    {value : "PASS_OPTION_FOR_MIDFIELDER_RATE", probability : 1.3 , action: "pass", toPosition: "DEFENSEUR"},
    {value : "PASS_OPTION_FOR_MIDFIELDER_RATE", probability : 0.01 , action: "pass", toPosition: "GARDIEN"},
    {value : "SHOT_ON_TARGET_OPTION_FOR_MIDFIELDER_RATE", probability : 0.05, action: "shot"},
    {value : "SHOT_MISS_OPTION_FOR_MIDFIELDER_RATE", probability : 0.05, action: "shot"}
];

let optionsForAtt = [
    {value : "SHOT_ON_TARGET_OPTION_FOR_FORWARD_RATE", probability : 0.2, action: "shot"},
    {value : "SHOT_MISS_OPTION_FOR_FORWARD_RATE", probability : 0.4, action: "shot"},
    {value : "PASS_OPTION_FOR_FORWARD_RATE", probability : 1 , action: "pass", toPosition: "MILIEU"},
    {value : "PASS_OPTION_FOR_FORWARD_RATE", probability : 1 , action: "pass", toPosition: "ATTAQUANT"},
    {value : "PASS_OPTION_FOR_FORWARD_RATE", probability : 0.009 , action: "pass", toPosition: "DEFENSEUR"},
    {value : "PASS_OPTION_FOR_FORWARD_RATE", probability : 0.001 , action: "pass", toPosition: "GARDIEN"},
    {value : "DRIBBLE_OPTION_FOR_FORWARD_RATE", probability : 2, action: "dribble"}
];

let optionsForDef = [
    {value : "PASS_OPTION_FOR_DEFENDER_RATE", probability : 2.5 , action: "pass", toPosition: "MILIEU"},
    {value : "PASS_OPTION_FOR_DEFENDER_RATE", probability : 0.1 , action: "pass", toPosition: "ATTAQUANT"},
    {value : "PASS_OPTION_FOR_DEFENDER_RATE", probability : 1.8 , action: "pass", toPosition: "DEFENSEUR"},
    {value : "PASS_OPTION_FOR_DEFENDER_RATE", probability : 0.2 , action: "pass", toPosition: "GARDIEN"},
    {value : "DRIBBLE_OPTION_FOR_DEFENDER_RATE", probability : 0.4, action: "dribble"},
    {value : "SHOT_ON_TARGET_OPTION_FOR_DEFENDER_RATE", probability : 0.05, action: "shot"},
    {value : "SHOT_MISS_OPTION_FOR_DEFENDER_RATE", probability : 0.05, action: "shot"}
];

let optionsForGK = [
    {value : "PASS_OPTION_FOR_GOALKEEPER_RATE", probability : 0.4 , action: "pass", toPosition: "MILIEU"},
    {value : "PASS_OPTION_FOR_GOALKEEPER_RATE", probability : 0.05 , action: "pass", toPosition: "ATTAQUANT"},
    {value : "PASS_OPTION_FOR_GOALKEEPER_RATE", probability : 1. , action: "pass", toPosition: "DEFENSEUR"},
];


/**
 * @summary On choisit une option d attaque selon les proba et le poste du joueur
 * @param {Object} player - Le joueur qui attaque
 * @param {String} teamName - Le nom de l equipe qui attaque
 * @param {boolean} freekick - Si c'est un coup franc
 * @param {boolean} corner - Si c'est un corner
 * @return {Object} - L option choisi
 */
function chooseOptionForAttacking (player, teamName, freekick = false,corner = false) {
    //console.log(player,teamName);
    if (freekick) {
        //console.log("YESSSS : freekick ");
        if (player.position.includes("ATTAQUANT")) {
            const probaPenalty = 8;
            const probaShotOnFreekick = 75;
            const probaPassOnFreekick = 17;
            const random = Math.floor(Math.random() * 100);
            if (random <= probaPenalty) {
                console.log("PENALTY !");
                return randomOption([
                    {value : "SHOT_ON_TARGET_OPTION_FOR_FORWARD_RATE", probability : 0.8, action: "shot"},
                    {value : "SHOT_MISS_OPTION_FOR_FORWARD_RATE", probability : 0.2, action: "shot"}
                ],player,teamName,"Penalty")
            }
            if (random > probaPassOnFreekick && random <= probaShotOnFreekick) {
                console.log("COUP FRANC DIRECT !")
                return randomOption([
                    {value : "SHOT_ON_TARGET_OPTION_FOR_FORWARD_RATE", probability : 0.6, action: "shot"},
                    {value : "SHOT_MISS_OPTION_FOR_FORWARD_RATE", probability : 0.3, action: "shot"}
                ],player,teamName,"Freekick")
            }
        }
        if (player.position.includes("MILIEU")) {
            const probaPenalty = 6;
            const probaShotOnFreekick = 60;
            const probaPassOnFreekick = 34;
            const random = Math.floor(Math.random() * 100);
            if (random <= probaPenalty) {
                console.log("PENALTY!")
                return randomOption([
                    {value : "SHOT_ON_TARGET_OPTION_FOR_MIDFIELDER_RATE", probability : 0.8, action: "shot"},
                    {value : "SHOT_MISS_OPTION_FOR_MIDFIELDER_RATE", probability : 0.2, action: "shot"}
                ],player,teamName,"Penalty")
            }
            if (random > probaPassOnFreekick && random <= probaShotOnFreekick) {
                console.log("COUP FRANC DIRECT !")
                return randomOption([
                    {value : "SHOT_ON_TARGET_OPTION_FOR_MIDFIELDER_RATE", probability : 0.7, action: "shot"},
                    {value : "SHOT_MISS_OPTION_FOR_MIDFIELDER_RATE", probability : 0.4, action: "shot"}
                ],player,teamName,"Freekick")
            }
        }
    }
    const ratesOptions = matchPositionWithOption(player);
    return randomOption(ratesOptions,player,teamName);
}

//Renvoie le bon tableau d options selon le poste 
function matchPositionWithOption (player) {
    const position = (player.position).split("_")[0];
    if (position === "MILIEU") {
        return optionsForMid;
    }
    if (position === "ATTAQUANT") {
        return optionsForAtt;
    }
    if (position === "DEFENSEUR") {
        return optionsForDef;
    }
    if (position === "GARDIEN") {
        return optionsForGK;
    }
}



/**
 * @summary On renvoie le gagnant et le perdant avec leurs options respectives
 * @param {Object} attacking - Le joueur qui attaque
 * @param {Array<Object>} defendingLine - Les defenseurs
 * @param {String} team - Le nom de l equipe qui attaque
 * @param {boolean} freekick - Si c'est un coup franc
 * @param {boolean} corner - Si c'est un corner
 * @return {Object} - Un objet avec l option gagnante le joueur qui a gagne l option perdante le joueur qui a perdu et un string qui decrit l action
 */
function getWinnerPlayerVSPlayer (attacking, defendingLine, team,freekick = false,corner = false) {
    //On choisit une option d attaque
    //console.log(attacking);
    let option = chooseOptionForAttacking(attacking,team,freekick,corner);
    let opt = option[0];
    let action = opt.action;
    let str = option[1];
    let defending = null;
    //Si le joueur fait un tir c le gardien qui s oppose
    if (action === "shot") {
        for (let player of defendingLine) {
            if (player.position === "GARDIEN") {
                defending = player;
            }
        }
    }
    //Si le joueur qui attaque fait une autre action on prend les joueurs de champs
    else {
        //On selectionne les defenseurs en fonction de l option de l attaquant (pass, dribble, etc)
        defendingLine = chooseDefensiveLine(opt,attacking,defendingLine);
        defending = defendingLine[Math.floor(Math.random() * defendingLine.length)];
        //console.log(opt,attacking,defending);
        //Random pour le joueur qui s oppose
    }
    //On determine le gagnant et le perdant selon les options de l attaquant et du defenseur
    return matchAttackingOptionWithDefendingOption(opt,attacking,defending,str);
}


/**
 * @summary On choisit la bonne option defensive en fonction de l option d attaque selon les joueurs et leurs postes
 * @param {Object} optionAttack - L option d attaque
 * @param {Object} attackingPlayer - Le joueur qui attaque
 * @param {Object} defendingPlayer - Le joueur qui defend
 * @param {String} str - Un string qui decrit l action
 * @return {Object} - Un objet avec l option gagnante le joueur qui a gagne l option perdante le joueur qui a perdu et un string qui decrit l action
 */
function matchAttackingOptionWithDefendingOption (optionAttack,attackingPlayer,defendingPlayer,str) {
    const attackingOption = optionAttack.value;
    let res = {
        attacking : "",
        defending : ""
    }
    if (str.includes("Penalty") && !(attackingOption.includes("MISS_OPTION"))) {
        console.log("Penalty cadre");
        res.attacking = {probability: 0.8, action: "shot"};
        res.defending = {probability: 0.2, action: "save"};
        return resultsOfDuel(res.attacking,attackingPlayer,res.defending,defendingPlayer,str);
    }
    if (str.includes("Freekick") && !(attackingOption.includes("MISS_OPTION"))) {
        console.log("Coup franc cadre");
        res.attacking = {probability: 0.3, action: "shot"};
        res.defending = {probability: 0.7, action: "save"};
        return resultsOfDuel(res.attacking,attackingPlayer,res.defending,defendingPlayer,str);
    }
    //On choisit la bonne option defensive selon l option offensive
    if (attackingOption === "DRIBBLE_OPTION_FOR_MIDFIELDER_RATE") {
        res.attacking = DRIBBLE_SUCCESSFUL_FOR_MIDFIELDER_RATE;
        res.defending = TACKLE_SUCCESSFUL_FOR_MIDFIELDER_RATE;
    }
    if (attackingOption === "PASS_OPTION_FOR_MIDFIELDER_RATE") {
        let duelForPass = choosePositionThatReceivePass(optionAttack, PASS_SUCCESSFUL_FOR_MIDFIELDER_RATE);
        res.attacking = duelForPass.attack;
        res.defending = duelForPass.defense;
        str += duelForPass.str;
    }
    if (attackingOption === "SHOT_ON_TARGET_OPTION_FOR_MIDFIELDER_RATE") {
        //console.log("Shot option");
        res.attacking = SHOT_ON_TARGET_FOR_MIDFIELDER_RATE;
        res.defending = SAVE_SUCCESSFUL_FOR_GOALKEEPER_RATE;
    }
    if (attackingOption === "SHOT_MISS_OPTION_FOR_MIDFIELDER_RATE") { //Si le joueur rate le cadre on sait qui a gagne et qui a perdu directement
        str += "Mais rate le cadre";
        return {
            optionWinner: null,
            optionLoser: SHOT_MISS_FOR_MIDFIELDER_RATE,
            playerWinner: defendingPlayer,
            playerLoser: attackingPlayer,
            actionStr: str
        }
    }

    if (attackingOption === "SHOT_ON_TARGET_OPTION_FOR_FORWARD_RATE") {
        res.attacking = SHOT_ON_TARGET_FOR_FORWARD_RATE;
        res.defending = SAVE_SUCCESSFUL_FOR_GOALKEEPER_RATE;
    }
    if (attackingOption === "SHOT_MISS_OPTION_FOR_FORWARD_RATE") {
        str += "Mais rate le cadre";
        return {
            optionWinner: null,
            optionLoser: SHOT_MISS_FOR_FORWARD_RATE,
            playerWinner: defendingPlayer,
            playerLoser: attackingPlayer,
            actionStr: str
        }
    }
    if (attackingOption === "PASS_OPTION_FOR_FORWARD_RATE") {
        let duelForPass = choosePositionThatReceivePass(optionAttack, PASS_SUCCESSFUL_FOR_FORWARD_RATE);
        res.attacking = duelForPass.attack;
        res.defending = duelForPass.defense;
        str += duelForPass.str;
    }
    if (attackingOption === "DRIBBLE_OPTION_FOR_FORWARD_RATE") {
        res.attacking = DRIBBLE_SUCCESSFUL_FOR_FORWARD_RATE;
        res.defending = TACKLE_SUCCESSFUL_FOR_DEFENDER_RATE;
    }

    if (attackingOption === "PASS_OPTION_FOR_DEFENDER_RATE") {
        let duelForPass = choosePositionThatReceivePass(optionAttack, PASS_SUCCESSFUL_FOR_DEFENDER_RATE);
        res.attacking = duelForPass.attack;
        res.defending = duelForPass.defense;
        str += duelForPass.str;
    }
    if (attackingOption === "DRIBBLE_OPTION_FOR_DEFENDER_RATE") {
        res.attacking = DRIBBLE_SUCCESSFUL_FOR_DEFENDER_RATE;
        res.defending = TACKLE_SUCCESSFUL_FOR_FORWARD_RATE;
    }
    if (attackingOption === "SHOT_ON_TARGET_OPTION_FOR_DEFENDER_RATE") {
        res.attacking = SHOT_ON_TARGET_FOR_DEFENDER_RATE;
        res.defending = SAVE_SUCCESSFUL_FOR_GOALKEEPER_RATE;
    }
    if (attackingOption === "SHOT_MISS_OPTION_FOR_DEFENDER_RATE") {
        str += "Mais rate le cadre";
        return {
            optionWinner: null,
            optionLoser: SHOT_MISS_FOR_DEFENDER_RATE,
            playerWinner: defendingPlayer,
            playerLoser: attackingPlayer,
            actionStr: str
        }
    }

    if (attackingOption === "PASS_OPTION_FOR_GOALKEEPER_RATE") {
        let duelForPass = choosePositionThatReceivePass(optionAttack, PASS_SUCCESSFUL_FOR_GOALKEEPER_RATE);
        res.attacking = duelForPass.attack;
        res.defending = duelForPass.defense;
        str += duelForPass.str;
    }

    return resultsOfDuel(res.attacking, attackingPlayer, res.defending ,defendingPlayer,str);
}


/**
 * @summary Choisit le gagnant et le perdant selon les proba des options d attaque et de defense des joueurs
 *
 * @param {Object} attacking - L'option offensive avec sa probabilite et son action
 * @param {Object} attackingPlayer - Le joueur qui attaque
 * @param {Object} defending - L'option défensive avec sa probabilite et son action
 * @param {Object} defendingPlayer - Le joueur qui defend
 * @param {String} str - Le string qui decrit l action
 *
 * @returns {Object} L'objet :
 * - optionWinner: L'option qui a gagne (attacking ou defending)
 * - playerWinner: Le joueur qui a gagne
 * - optionLoser: L'option qui a perdu (attacking ou defending)
 * - playerLoser: Le joueur qui a perdu
 * - actionStr: Le string qui decrit l action avec des messages en plus
 */
function resultsOfDuel (attacking, attackingPlayer ,defending, defendingPlayer,str) {
    let probabilityAttacking = attacking.probability * 100;
    let probabilityDefending = defending.probability * 100 + probabilityAttacking;
    const random = (Math.random() * probabilityDefending).toFixed(2);
    str += strDefense(str,defendingPlayer,defending.action);
    if (random <= probabilityAttacking) {
        str += " mais c'est rate";
        return {
            optionWinner : attacking,
            playerWinner : attackingPlayer,
            optionLoser : defending,
            playerLoser : defendingPlayer,
            actionStr : str
        };
    }
    if (random > probabilityAttacking && random <= probabilityDefending) {
        return isFoulCommitted(defending,defendingPlayer,attackingPlayer,attacking,str);
    }
}

//Update le string qui decrit l action
function strDefense (str, player, action) {
    if (player === undefined) {
        return action;
    }
    return "Le joueur " + player.name + " " + player.first_name + " #" + player.shirt_number +" de l'autre equipe tente " + action ;
}

/**
 * @summary Retourne un tableau avec l option aleatoire et le string qui decrit l action
 *
 * @param {Array<Object>} options - Les options avec leur probabilite et leur action (ex : optionsForMid)
 * @param {Object} player - Le joueur qui fait l action
 * @param {String} teamName - Le nom de l equipe du joueur
 * @param {String} strToAdd - Ajoute une precision si c un coup franc ou un penalty
 * @return {Array<Object,String>} - Un tableau avec l option et le string qui decrit l action
 */
function randomOption (options,player,teamName,strToAdd = "") {
    const {name,first_name,shirt_number,position} = player;
    let tabOptions = [];
    let prevProba = 0;
    let maxProba = 0;
    for (opt of options) {
        let tmp = opt.probability * 100;
        opt.valueForRandom = tmp + prevProba;
        prevProba += tmp;
        tabOptions.push(opt);
        maxProba = opt.valueForRandom;
    }
    let random = Math.random() * maxProba;
    for (tabOpt of tabOptions) {
        if (random <= tabOpt.valueForRandom) {
            const {action} = tabOpt;
            let str = "Le joueur " + name + " " + first_name + " #" + shirt_number +" de " + teamName + " au poste : " + position  + " fait " + action + " (" + strToAdd + ") ///";
            return [tabOpt,str];
        }
    }
}

/**
 * @summary Retourne un tableau avec les joueurs qui sont a la position correspondante a l option d attaque
 * @param {Object} opt - L option d attaque
 * @param {Object} attacking - Le joueur qui attaque
 * @param {Array<Object>} defensiveLine - Les joueurs de l'equipe adverse qui defendent
 * @return {Array<Object>} - Les joueurs qui ont le poste pour recupe le ballon selon l'attaquant
 */
function chooseDefensiveLine(opt,attacking,defensiveLine) {
    if (opt.action === "pass") {
        const toPosition = opt.toPosition;
        if (toPosition === "MILIEU") {
            return defensiveLine.filter(player => player.position.includes("MILIEU"));
        }
        if (toPosition === "DEFENSEUR" || toPosition === "GARDIEN") {
            return defensiveLine.filter(player => player.position.includes("ATTAQUANT"));
        }
        if (toPosition === "ATTAQUANT") {
            return defensiveLine.filter(player => player.position.includes("DEFENSEUR"));
        }
    }
    if (opt.action === "dribble") {
        return defensiveLine.filter(player => player.position.includes(setOpponentPlayer(attacking)));
    }
}

/**
 * @summary Change la proba de la passe selon la destination
 * @param {Object} optionAttack - L'option d'attaque (ex : optionsForMid)
 * @param {Object} attackSuccess - L'objet avec les proba (ex : PASS_SUCCESSFUL_FOR_MIDFIELDER_RATE)
 * @return {Object} - Un objet qui decrit l action et contient l'objet d'attaque et de defense
 */
function choosePositionThatReceivePass(optionAttack,attackSuccess) {
    const toPosition = optionAttack.toPosition;
    attackSuccess.probability = attackSuccess.toPosition[toPosition];
    attackSuccess.toPlayerAtPosition = toPosition;
    INTERCEPTION_SUCCESSFUL.probability = INTERCEPTION_SUCCESSFUL.fromPosition[setOppositePostion(toPosition)];
    return {
        attack : attackSuccess,
        defense : INTERCEPTION_SUCCESSFUL,
        str : "Vers le poste : " + toPosition + " ///"
    }
}
//Renvoie le poste qui oppose le joueur
function setOpponentPlayer (player) {
    const position = player.position.split("_")[0];
    if (position === "MILIEU") {
        return "MILIEU";
    }
    if (position === "DEFENSEUR" || position === "GARDIEN") {
        return "ATTAQUANT";
    }
    if (position === "ATTAQUANT") {
        return "DEFENSEUR";
    }
}

//Renvoie le poste qui oppose la position
function setOppositePostion(position) {
    if (position === "MILIEU") {
        return "MILIEU";
    }
    if (position === "DEFENSEUR" || position === "GARDIEN") {
        return "ATTAQUANT";
    }
    if (position === "ATTAQUANT") {
        return "DEFENSEUR";
    }
}

function isFoulCommitted (defending,defendingPlayer,attackingPlayer,attacking,str) {
    if (defending.action === "tackle") {
        let probaFoul = FOUL_COMMITTED.probability * 100;
        const random = (Math.random() * 100).toFixed(2);
        if (random <= probaFoul) {
            str += "et c'est une faute !";
            return {
                optionWinner : attacking,
                playerWinner : attackingPlayer,
                optionLoser : defending,
                playerLoser : defendingPlayer,
                actionStr : str
            }
        }
    }
    str += " et c'est reussi";
    return {
        optionWinner : defending,
        playerWinner : defendingPlayer,
        optionLoser : attacking,
        playerLoser : attackingPlayer,
        actionStr : str
    }
}

module.exports = {
    getWinnerPlayerVSPlayer
}