/**
 * @summary Sépare les joueurs d'un match en deux equipes
 * @param {Array} players - Les joueurs du match
 * @returns {Array} - Les deux equipes séparées avec leur liste de joueurs et leur nom
*/
function sortPlayersByTeam(players) {
    let firstTeam = {};
    let secondTeam = {};
    let x = 0, y = 0;
    let xSub = 0, ySub = 0;
    firstTeam.players = [];
    firstTeam.subs = [];
    secondTeam.players = [];
    secondTeam.subs = [];
    for (const player of players) {
        const status = player.status;
        if (!firstTeam.team) { // Si il n'y a pas encore de premiere equipe, on la remplit
            if (status === "REMPLACANT") {
                firstTeam = getCorrectTeam(player, firstTeam, xSub, true);
                xSub++;
            }
            else {
                firstTeam = getCorrectTeam(player, firstTeam, x);
                x++;
            }
        } else if (player.team !== firstTeam.team) { // Si le joueur n'est pas de la meme equipe que la premiere equipe, on la remplit
            if (status === "REMPLACANT") {
                secondTeam = getCorrectTeam(player, secondTeam, ySub, true);
                ySub++;
            }
            else {
                secondTeam = getCorrectTeam(player, secondTeam, y);
                y++;
            }
        } else { // Si le joueur est de la meme equipe que la premiere equipe, on la remplit
            if (status === "REMPLACANT") {
                firstTeam = getCorrectTeam(player, firstTeam, xSub, true);
                xSub++;
            }
            else {
                firstTeam = getCorrectTeam(player, firstTeam, x);
                x++;
            }
        }
    }
    return [firstTeam, secondTeam];
}

//Ajoute le joueur a la bonne equipe avec son statut
function getCorrectTeam(player, team, index, isSub = false) {
    // On ajoute le nom de l'equipe
    team.team = player.team;
    team.teamId = player.id_team;
    // On cree la liste de joueurs de l'equipe
    team.players = team.players || [];
    if (!isSub) {
        // Si le joueur n'est pas un remplaçant, ie il est titulaire , on l'ajoute a la liste des joueurs
        team.players[index] = {
            name: player.name,
            first_name: player.first_name,
            position: player.position,
            shirt_number: player.shirt_number,
            status: player.status,
            id_player: player.id_player
        };
    }
    else {
        // Si cest un remplacant on l'ajoute a la liste des remplacants
        team.subs[index] = {
            name: player.name,
            first_name: player.first_name,
            position: player.position,
            shirt_number: player.shirt_number,
            status: player.status,
            id_player: player.id_player
        };
    }
    return team;
}

module.exports = {sortPlayersByTeam}