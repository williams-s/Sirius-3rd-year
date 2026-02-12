const {
    getWinnerPlayerVSPlayer,
} = require("./actionsForPlayers.js");

const {updateQuery} = require("../../sqlQueries.js");
let teamWithBall = {
    team: "",
    players: [],
};

const firstTeamObj = {
    team: "",
    id: 0,
    players: [],
    subs: [],
    score: 0
};
const secondTeamObj = {
    team: "",
    id: 0,
    players: [],
    subs: [],
    score: 0
};

let excluded = [];

let lastPassPlayer = null;
let currentPlayerWithBall = {};
let freekick = false;
let corner = false;

const MATCH_TIME = 90;
const ACTIONS_PER_MINUTE = 12;

/**
 * @summary Fonction qui simule un match de football
 * @param {Object} firstTeam - La premiere equipe
 * @param {Object} secondTeam - La deuxieme equipe
 * @param {Number} matchId - L'id du match
 * @returns {Object} - Les deux equipes avec leurs stats et leurs joueurs respectifs
 */
async function simulateMatch(firstTeam, secondTeam, matchId) {
    //On stocke les infos nécessaires des deux equipes (le nom, les joueurs et les remplacants)
    excluded = [];
    initTeamsStats(firstTeam, secondTeam);
    //On met les stats des joueurs et des remplacants a 0 (buts passes tacles etc)
    initPlayerStats(secondTeamObj.players);
    initPlayerStats(firstTeamObj.players);
    initPlayerStats(firstTeamObj.subs);
    initPlayerStats(secondTeamObj.subs);

    //La premiere equipe a le ballon et c un joueur de cette equipe qui a la balle
    teamWithBall.team = firstTeamObj.team;
    teamWithBall.players = firstTeamObj.players;
    currentPlayerWithBall = teamWithBall.players[5];

    //console.log(firstTeamObj,secondTeamObj)

    //Boucle sur le temps du match
    for (let minute = 0; minute < MATCH_TIME; minute++) {
        if (minute === 60) {
            substitution(firstTeamObj);
            substitution(secondTeamObj);
        }
        for (let nbAction = 0; nbAction < ACTIONS_PER_MINUTE; nbAction++) {
            //On simule une action pour le joueur qui a la balle
            //if (minute === 60) console.log('hey',currentPlayerWithBall);
            const actionTab = playerAction(currentPlayerWithBall);
            //for (const action of actionTab) {
                //console.log(action); // On affiche les resultats de l'action du joueur
            //}
        }
        // On ajoute des minutes
        addMinutes();
    }
    //Fin du match
    //console.log(currentPlayerWithBall);
    console.log("\nFIN DU MATCH !!!");
    console.log("Score final : " + firstTeamObj.team + " " +firstTeamObj.score + " - " + secondTeamObj.score + " " + secondTeamObj.team);
    await saveStatsFromMatch(matchId); //On update les stats dans la table sql in_game_stats
    return {
        firstTeam : firstTeamObj,
        secondTeam : secondTeamObj
    }
}



/**
 * @summary Fonction qui simule l'action d'un joueur
 * @param {Object} player - Le joueur qui a la balle
 * @returns {Array<string>} - Les resultats suite a son action
 */
function playerAction(player) {
    //On recupe l equipe qui n'a pas la balle
    const teamWithoutBall = teamWithBall.team === firstTeamObj.team ? secondTeamObj : firstTeamObj;
    //On stocke le resultat de l action du joueur
    const playerVSPlayer = getWinnerPlayerVSPlayer(player,teamWithoutBall.players, teamWithBall.team,freekick,corner);
    if (freekick) freekick = false;
    if (corner) corner = false;
    const {optionWinner, playerWinner, optionLoser, playerLoser, actionStr} = playerVSPlayer;
    let actionWinner = null;
    let actionLoser = null;
    let actionsStrTab = actionStr.split("///"); //Pour séparer les actions a l'affichage (cf actionForPlayers.js)

    //Si optionWinner != null
    if (optionWinner) {
        actionWinner = optionWinner.action;
        //On met a jour les stats du joueur qui a gagne le duel
        updatePlayerStats(actionWinner, true, playerWinner); //true pcq il a gagne
    }

    //Si optionLoser != null
    if (optionLoser) {
        actionLoser = optionLoser.action;
        if (actionStr.includes("faute")) {
            updatePlayerStats("foul_commited",true,playerLoser);
            freekick = true;
            //console.log(playerLoser.name, playerLoser.fouls_commited);

        }
        //Si le joueur a cadré mais s'est fait arreter
        if (optionWinner && actionLoser === "shot") { //En gros si OptionWinner existe mais que le tir a raté ca veut dire qu'il a cadré son tir
            updatePlayerStats(actionLoser, true, playerLoser); //true pcq c un tir cadré
            if (actionStr.includes("Penalty")) {
                updatePlayerStats("penalty",false,playerLoser);
            }
            if (actionStr.includes("Freekick")) {
                updatePlayerStats("freekick",false,playerLoser);
            }
        }
        else {
            //On met a jour les stats du joueur qui a perdu le duel
            updatePlayerStats(actionLoser, false, playerLoser); //false pcq il a perdu
        }
    }

    //Si le joueur qui a la balle alors on donne la balle a lautre equipe
    if (player === playerLoser) {
        changePossession(firstTeamObj, secondTeamObj, playerWinner);
    }
    else {
        //Si le joueur a fait une passe reussie
        if (actionWinner === "pass") {
            lastPassPlayer = player; //On dit que c lui qui a fait la derniere passe
            changePlayerWithBall(actionWinner, teamWithBall, player,optionWinner,teamWithoutBall); //On change le joueur qui a la balle
        }
        else if (actionWinner === "shot") { //Si le joueur est winner avec un un tir ca veut dire qu il a marque
            //On met a jour le score et on change l equipe qui a la balle
            goalForTeam(teamWithBall);
            if (actionStr.includes("Penalty")) {
                updatePlayerStats("penalty",true,playerWinner);
            }
            if (actionStr.includes("Freekick")) {
                updatePlayerStats("freekick",true,playerWinner);
            }
            changePossession(firstTeamObj, secondTeamObj, teamWithoutBall.players[5]);
        }
        else if (actionStr.includes("faute")){

        }
    }
    return actionsStrTab;
}



/**
 * @summary Fonction qui change l'equipe qui a la balle apres un duel
 * @param {Object} firstTeam - La premiere equipe
 * @param {Object} secondTeam - La deuxieme equipe
 * @param {Object} player - Le joueur qui a gagné le duel
 */
function changePossession(firstTeam,secondTeam,player) {
    lastPassPlayer = null; //On reset le joueur qui a fait la derniere passe car il fait partie de l'equipe qui a perdu le ballon
    // Si c est la premiere equipe qui a la balle
    if (teamWithBall.team === firstTeam.team) {
        // On change l equipe qui a la balle
        teamWithBall.team = secondTeam.team;
        teamWithBall.players = secondTeam.players;
    }
    else {
        teamWithBall.team = firstTeam.team;
        teamWithBall.players = firstTeam.players;
    }
    giveBallToPlayer(player); //On donne le ballon au joueur qui a gagné le duel
}

/**
 * @summary Fonction qui change le joueur qui a la balle apres une action
 * @param {String} action - L'action du joueur (pass, shot, dribble, etc)
 * @param {Object} teamWithBall - L'equipe qui a la balle
 * @param {Object} player - Le joueur qui a la balle
 * @param {Object} teamWithoutBall - L'equipe qui n'a pas la balle
 * @param {Object} option - Les options de l'action du joueur (cf actionForPlayers.js)
 */
function changePlayerWithBall(action, teamWithBall, player, option,teamWithoutBall) {
    const toPlayerAtPosition = option.toPlayerAtPosition; //Le poste du joueur qui va recevoir la balle
    //console.log("toPlayerAtPosition",toPlayerAtPosition);
    const players = teamWithBall.players.filter(p => p !== player && p.position.includes(toPlayerAtPosition)); //Faut pas qu'il se fasse la passe a lui meme mdr
    //console.log('ici',players[0]);
    if (players[0] === undefined) {
        //console.log('ici else')
        changePossession(firstTeamObj, secondTeamObj, teamWithoutBall.players[5]);
    }
    else {
        if (players !== []) {
            if (action === "pass") {
                //On fait un random pour savoir qui a la balle
                let random = Math.floor(Math.random() * players.length);
                currentPlayerWithBall = players[random];
                lastPassPlayer = player; //Le joueur vient de faire une passe
            }
        }
        else {
            //console.log('ici else')
            changePossession(firstTeamObj, secondTeamObj, teamWithoutBall.players[5]);
        }
    }
}
//Change le joueur qui a le ballon
function giveBallToPlayer(player) {
    currentPlayerWithBall = player;
}

function substitution(teamObj) {
    console.log("CHANGEMENT !")
    changingPlayers(teamObj,"DEFENSEUR");
    changingPlayers(teamObj,"MILIEU");
    changingPlayers(teamObj,"ATTAQUANT");
    teamObj.players = teamObj.players.filter((p) => p!== undefined);
    //console.log("bbbb", teamObj.players.length)
    //console.log(currentPlayerWithBall);
}


function changingPlayers(teamObj,positionLine) {
    let playersFromPosition = teamObj.players.filter((p) => p.position.includes(positionLine));
    let subPosition = teamObj.subs.filter((p) => p.position.includes(positionLine));
    let random1 = Math.floor(Math.random() * playersFromPosition.length);
    teamObj.players = teamObj.players.filter((p) => p !== (playersFromPosition[random1]))
    excluded.push(playersFromPosition[random1]);
    //console.log(excluded.length);
    teamObj.players.push(subPosition[0]);
    teamObj.subs = teamObj.subs.filter((p) => !(subPosition.includes(p)))

}
/**
 * @summary Update les stats du joueur qui a marqué le but et de son equipe avec la passe D
 * @param {Object} team - L'équipe qui a marqué le but.
 */
function goalForTeam(team) {
    //Ajoute un but aux stats du joueur
    updatePlayerStats("goal", true, currentPlayerWithBall);

    //Si y a une passe d on l'update pour le joueur qui a fait la passe
    if (lastPassPlayer !== null) {
        updatePlayerStats("assist", true, lastPassPlayer);
    }

    console.log("ET C'EST LE BUUUUUUUUUUUUUUT ! pour l'equipe : " + team.team);

    //Ajoute un but au score de l'equipe
    team.team === firstTeamObj.team ? firstTeamObj.score++ : secondTeamObj.score++;
}

/**
 * @summary On va recup les bons champs pour update les stats dans la table in_game_stats
 * @param {String} action - L'action du joueur (shot, pass, dribble, etc)
 * @param {Boolean} success - Si l'action a reussi ou pas
 * @returns {Array} On renvoie les champs pour l'update
 */
function matchActionWithSQL(action, success) {
    switch (action) {
        case "shot":
            return success ? ["shots_total", "shots_on_target"] : ["shots_total"];
        case "pass":
            return success ? ["passes_total", "passes_successful"] : ["passes_total"];
        case "dribble":
            return success ? ["dribbles_total", "dribbles_successful"] : ["dribbles_total"];
        case "interception":
            return success ? ["interceptions"] : [];
        case "tackle":
            return success ? ["tackles_total", "tackles_successful"] : ["tackles_total"];
        case "save":
            return success ? ["saves_total"] : [];
        case "goal":
            return success ? ["goals"] : [];
        case "assist":
            return success ? ["assists"] : [];
        case "foul_commited":
            return success ? ["fouls_commited"] : [];
        case "penalty":
            return success ? ["penalty_total","penalty_scored"] : ["penalty_total"];
        case "freekick":
            return success ? ["freekick_total","freekick_scored"] : ["freekick_total"];
        default:
            return [];
    }
}
/**
 * @summary Initialise les stats des joueurs à 0
 * @param {Array<Object>} players - Les joueurs à initialiser
 */
function initPlayerStats(players) {
    for (player of players) {
        player.shots_on_target = 0;
        player.shots_total = 0;
        player.passes_successful = 0;
        player.passes_total = 0;
        player.dribbles_successful = 0;
        player.dribbles_total = 0;
        player.interceptions = 0;
        player.tackles_successful = 0;
        player.tackles_total = 0;
        player.saves_total = 0;
        player.goals = 0;
        player.assists = 0;
        player.minutes_played = 0;
        player.crosses_total = 0;
        player.crosses_successful = 0;
        player.fouls_commited = 0;
        player.fouls_suffered = 0;
        player.yellow_card = 0;
        player.red_card = 0;
        player.key_passes = 0;
        player.distance_covered = 0;
        player.aerial_duels_won = 0;
        player.penalty_total = 0;
        player.penalty_scored = 0;
        player.freekick_total = 0;
        player.freekick_scored = 0;
    }
}

function initTeamsStats(firstTeam,secondTeam) {
    firstTeamObj.team = firstTeam.team;
    firstTeamObj.id = firstTeam.teamId;
    firstTeamObj.players = firstTeam.players;
    firstTeamObj.subs = firstTeam.subs;

    secondTeamObj.team = secondTeam.team;
    secondTeamObj.id = secondTeam.teamId;
    secondTeamObj.players = secondTeam.players;
    secondTeamObj.subs = secondTeam.subs;

    firstTeamObj.score = 0;
    secondTeamObj.score = 0;
}


/**
 * @summary Update les stats d'un joueur dans la table in_game_stats selon l'action
 * @param {String} action - L'action du joueur (shot, pass, dribble, etc)
 * @param {Boolean} success - Si l'action a reussi ou pas
 * @param {Object} player - Le joueur concerné
 */
function updatePlayerStats(action, success, player) {
    const fields = matchActionWithSQL(action, success);
    let isNewFoul = false;
    for (const field of fields) {
        if (field === "fouls_commited") {
            isNewFoul = true;
        }
        player[field]++;//On ajoute 1 a la stat
    }
    if (isNewFoul) {
        giveCard(player);
    }
}

function giveCard(player) {
    if (player.fouls_commited === 2) {
        //console.log("YELLLLOW");
        player.yellow_card++;
    }
    if (player.fouls_commited === 3) {
        //console.log("REDDDDD");
        player.red_card++;
        excluded.push(player);
        firstTeamObj.players = firstTeamObj.players.filter((p) => p!== player)
        secondTeamObj.players = secondTeamObj.players.filter((p) => p!== player)
    }
}

/**
 * @summary Ajoute 1 minute aux joueurs titulaires de chaque equipe
 */
function addMinutes() {
    for (player of firstTeamObj.players) {
        if (player.minutes_played) {
            player.minutes_played++;
        } else {
            player.minutes_played = 1;
        }
    }
    for (player of secondTeamObj.players) {
        if (player.minutes_played) {
            player.minutes_played++;
        } else {
            player.minutes_played = 1;
        }
    }
}

/**
 * @summary Enregistre les stats des joueurs dans la table in_game_stats
 */
async function saveStatsFromMatch(matchId) {
    //On recup tous les joueurs titu et remplacants
    //console.log(firstTeamObj.subs,secondTeamObj.subs);
    //console.log(excluded.length);
    let players = firstTeamObj.players.concat(firstTeamObj.subs);
    players = players.concat(secondTeamObj.players);
    players = players.concat(secondTeamObj.subs);
    players = players.concat(excluded);

    //console.log(firstTeamObj.players.length);
    //(players.map((p) => console.log(p.id_player,p.status)));
    //On recup les ids des joueurs
    let ids = players.map(p => (
        {
            id_player: p.id_player,
            id_match: matchId
        }));

    //console.log(ids);
    //On supprime les champs qui ne sont pas utiles dans l'update
    for (const player of players) {
        delete player.name;
        delete player.first_name;
        delete player.position;
        delete player.shirt_number;
        delete player.status;
        delete player.id_player;
    }

    await updateQuery("in_game_stats",players,ids);
}



module.exports = {simulateMatch}