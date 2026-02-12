const {GET_ALL_PLAYERS_FROM_TEAM_THAT_PLAY_THE_MATCH,insertQuery} = require("../sqlQueries");
const _ = require("lodash");
const formations = ["4-4-2","4-3-3","3-5-2","3-4-3"];

const registerOnMatch = async (id_match) => {
    let homePlayers = (await GET_ALL_PLAYERS_FROM_TEAM_THAT_PLAY_THE_MATCH(id_match,"home")).rows;
    let awayPlayers = (await GET_ALL_PLAYERS_FROM_TEAM_THAT_PLAY_THE_MATCH(id_match,"away")).rows;

    let home = {};
    let away = {};

    home.idTeam = homePlayers[0].id_team_home;
    away.idTeam = awayPlayers[0].id_team_away;

    home.goalkeepers = homePlayers.filter(player => player.position === "GARDIEN");
    home.defenders = homePlayers.filter(player => player.position.includes("DEFENSEUR"));
    home.midfielders = homePlayers.filter(player => player.position.includes("MILIEU"));
    home.attackers = homePlayers.filter(player => player.position.includes("ATTAQUANT"));

    home.formation = formations[Math.floor(Math.random() * formations.length)];

    away.goalkeepers = awayPlayers.filter(player => player.position === "GARDIEN");
    away.defenders = awayPlayers.filter(player => player.position.includes("DEFENSEUR"));
    away.midfielders = awayPlayers.filter(player => player.position.includes("MILIEU"));
    away.attackers = awayPlayers.filter(player => player.position.includes("ATTAQUANT"));

    away.formation = formations[Math.floor(Math.random() * formations.length)];
    matchPlayerWithFormation(home);
    matchPlayerWithFormation(away);
    getSubs(home,homePlayers,home.startPlayers);
    getSubs(away,awayPlayers,away.startPlayers);

    for (const player of home.startPlayers) {
        player.id_team = player.id_team_home;
        player.status = 'TITULAIRE';
        delete player.id_team_home;
        await insertQuery("in_game_stats",player);
    }
    for (const player of away.startPlayers) {
        player.id_team = player.id_team_away;
        player.status = 'TITULAIRE';
        delete player.id_team_away;
        await insertQuery("in_game_stats",player);
    }
    for (const player of home.subs) {
        player.id_team = player.id_team_home;
        player.status = 'REMPLACANT';
        delete player.id_team_home;
        await insertQuery("in_game_stats",player);
    }
    for (const player of away.subs) {
        player.id_team = player.id_team_away;
        player.status = 'REMPLACANT';
        delete player.id_team_away;
        await insertQuery("in_game_stats",player);
    }
    return {home,away};
}


function getExactAmountOfPlayers(players,position,amount = 1){
    let randomPlayers = _.shuffle(players); //cf https://www.geeksforgeeks.org/lodash-_-shuffle-method/
    return (randomPlayers.filter(player => player.position === position).slice(0,amount));
}

function getSubs(team,allPlayers,startPlayers) {
    let subs = [];
    let tmp = _.shuffle(allPlayers);
    let positionToAddInSubs = ['DEFENSEUR','MILIEU','ATTAQUANT'];
    let i = 0;
    while (subs.length !== 3) {
        for (let p of tmp) {
            if (!(startPlayers.includes(p))) {
                if (p.position.includes(positionToAddInSubs[i])) {
                    subs.push(p);
                    i++;
                }
            }
            if (subs.length === 3) {
                break;
            }
        }
    }
    team.subs = subs;
}

function matchPlayerWithFormation(team) {
    const {formation,defenders,midfielders,attackers,goalkeepers} = team;
    const linesPlayers = formation.split("-");
    const defendersLine = linesPlayers[0];
    const midfieldersLine = linesPlayers[1];
    const attackersLine = linesPlayers[2];
    team.goalkeepers = getExactAmountOfPlayers(goalkeepers,"GARDIEN",1);
    if (defendersLine === "4") {
        let centerBacks = getExactAmountOfPlayers(defenders,"DEFENSEUR_CENTRAL",2);
        let leftBacks = getExactAmountOfPlayers(defenders, "DEFENSEUR_GAUCHE",1);
        let rightBacks = getExactAmountOfPlayers(defenders, "DEFENSEUR_DROIT",1);
        team.defenders = [...centerBacks,...leftBacks,...rightBacks];
    }
    if (defendersLine === "3") {
        team.defenders = getExactAmountOfPlayers(defenders, "DEFENSEUR_CENTRAL", 3);
    }
    if (defendersLine === "5") {
        let centerBacks = getExactAmountOfPlayers(defenders,"DEFENSEUR_CENTRAL",3);
        let leftBacks = getExactAmountOfPlayers(defenders, "DEFENSEUR_GAUCHE",1);
        let rightBacks = getExactAmountOfPlayers(defenders, "DEFENSEUR_DROIT",1);
        team.defenders = [...centerBacks,...leftBacks,...rightBacks];
    }
    if (midfieldersLine === "2") {
        team.midfielders = getExactAmountOfPlayers(midfielders, "MILIEU_CENTRAL", 2);
    }
    if (midfieldersLine === "3") {
        team.midfielders = getExactAmountOfPlayers(midfielders, "MILIEU_CENTRAL", 3);
    }
    if (midfieldersLine === "4") {
        let defensiveMidfielders = getExactAmountOfPlayers(midfielders, "MILIEU_DEFENSIF", 1);
        let offensiveMidfielders = getExactAmountOfPlayers(midfielders, "MILIEU_OFFENSIF", 1);
        let leftMidfielders = getExactAmountOfPlayers(midfielders, "MILIEU_GAUCHE", 1);
        let rightMidfielders = getExactAmountOfPlayers(midfielders, "MILIEU_DROIT", 1);
        team.midfielders = [...defensiveMidfielders,...offensiveMidfielders,...leftMidfielders,...rightMidfielders];
    }
    if (midfieldersLine === "5") {
        let defensiveMidfielders = getExactAmountOfPlayers(midfielders, "MILIEU_DEFENSIF", 2);
        let offensiveMidfielders = getExactAmountOfPlayers(midfielders, "MILIEU_OFFENSIF", 1);
        let leftMidfielders = getExactAmountOfPlayers(midfielders, "MILIEU_GAUCHE", 1);
        let rightMidfielders = getExactAmountOfPlayers(midfielders, "MILIEU_DROIT", 1);
        team.midfielders = [...defensiveMidfielders,...offensiveMidfielders,...leftMidfielders,...rightMidfielders];
    }
    if (attackersLine === "1") {
        team.attackers = getExactAmountOfPlayers(attackers, "ATTAQUANT_CENTRAL", 1);
    }
    if (attackersLine === "2") {
        team.attackers = getExactAmountOfPlayers(attackers, "ATTAQUANT_CENTRAL", 2);
    }
    if (attackersLine === "3") {
        let strikers = getExactAmountOfPlayers(attackers, "ATTAQUANT_CENTRAL", 1);
        let leftWingers = getExactAmountOfPlayers(attackers, "ATTAQUANT_GAUCHE", 1);
        let rightWingers = getExactAmountOfPlayers(attackers, "ATTAQUANT_DROIT", 1);
        team.attackers = [...strikers,...leftWingers,...rightWingers];
    }
    if (attackersLine === "4") {
        let strikers = getExactAmountOfPlayers(attackers, "ATTAQUANT_CENTRAL", 2);
        let leftWingers = getExactAmountOfPlayers(attackers, "ATTAQUANT_GAUCHE", 1);
        let rightWingers = getExactAmountOfPlayers(attackers, "ATTAQUANT_DROIT", 1);
        team.attackers = [...strikers,...leftWingers,...rightWingers];
    }
    team.startPlayers = [...team.goalkeepers,...team.defenders,...team.midfielders,...team.attackers];
    return team;
}



/*async function main (id_match) {
    let x = await registerOnMatch(id_match);
    //console.log(x);
}*/

//main(1).then(_ => process.exit(0));

module.exports = {registerOnMatch};
