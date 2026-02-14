const {GET_ALL_PLAYERS_FROM_TEAM_THAT_PLAY_THE_MATCH,insertQuery, executeQuery} = require("../sqlQueries");
const _ = require("lodash");
const formations = ["4-4-2","4-3-3","3-5-2","3-4-3"];

const registerOnMatch = async (id_team_home, id_team_away) => {
    //let homePlayers = (await GET_ALL_PLAYERS_FROM_TEAM_THAT_PLAY_THE_MATCH(id_match,"home")).rows;
    //let awayPlayers = (await GET_ALL_PLAYERS_FROM_TEAM_THAT_PLAY_THE_MATCH(id_match,"away")).rows;

    let homePlayers = await executeQuery("SELECT player_belongs_team.id_player, player_belongs_team.id_team, players.position from player_belongs_team JOIN players ON player_belongs_team.id_player = players.id_players where id_team = $1", [id_team_home]);
    let awayPlayers = await executeQuery("SELECT player_belongs_team.id_player, player_belongs_team.id_team, players.position from player_belongs_team JOIN players ON player_belongs_team.id_player = players.id_players where id_team = $1", [id_team_away]);



    let homeData = homePlayers.rows;
    let awayData = awayPlayers.rows;

    let home = {};
    let away = {};

    //console.log(homeData);
    //console.log(awayData);

    home.idTeam = homeData[0].id_team;
    away.idTeam = awayData[0].id_team;

    home.goalkeepers = homeData.filter(player => player.position === "GOALKEEPER");
    home.defenders = homeData.filter(player => player.position.includes("BACK"));
    home.midfielders = homeData.filter(player => player.position.includes("MIDFIELDER"));
    home.attackers = homeData.filter(player => player.position.includes("STRIKER") || player.position.includes("WINGER"));

    home.formation = "4-3-3" //formations[Math.floor(Math.random() * formations.length)];

    away.goalkeepers = awayData.filter(player => player.position === "GOALKEEPER");
    away.defenders = awayData.filter(player => player.position.includes("BACK"));
    away.midfielders = awayData.filter(player => player.position.includes("MIDFIELDER"));
    away.attackers = awayData.filter(player => player.position.includes("STRIKER") || player.position.includes("WINGER"));

    away.formation = "4-3-3" //formations[Math.floor(Math.random() * formations.length)];
    matchPlayerWithFormation(home);
    matchPlayerWithFormation(away);
    //getSubs(home,homePlayers,home.startPlayers);
    //getSubs(away,awayPlayers,away.startPlayers);

   /* for (const player of home.startPlayers) {
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
    }*/
    /*for (const player of home.subs) {
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
    }*/
    console.log(home,away);
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
    team.goalkeepers = getExactAmountOfPlayers(goalkeepers,"GOALKEEPER",1);
    if (defendersLine === "4") {
        let centerBacks = getExactAmountOfPlayers(defenders,"CENTER_BACK",2);
        let leftBacks = getExactAmountOfPlayers(defenders, "LEFT_BACK",1);
        let rightBacks = getExactAmountOfPlayers(defenders, "RIGHT_BACK",1);
        team.defenders = [...centerBacks,...leftBacks,...rightBacks];
    }
    if (defendersLine === "3") {
        team.defenders = getExactAmountOfPlayers(defenders, "CENTER_BACK", 3);
    }
    if (defendersLine === "5") {
        let centerBacks = getExactAmountOfPlayers(defenders,"CENTER_BACK",3);
        let leftBacks = getExactAmountOfPlayers(defenders, "LEFT_BACK",1);
        let rightBacks = getExactAmountOfPlayers(defenders, "RIGHT_BACK",1);
        team.defenders = [...centerBacks,...leftBacks,...rightBacks];
    }
    if (midfieldersLine === "2") {
        team.midfielders = getExactAmountOfPlayers(midfielders, "CENTER_MIDFIELDER", 2);
    }
    if (midfieldersLine === "3") {
        team.midfielders = getExactAmountOfPlayers(midfielders, "CENTER_MIDFIELDER", 3);
    }
    if (midfieldersLine === "4") {
        let defensiveMidfielders = getExactAmountOfPlayers(midfielders, "CENTER_DEFENSIVE_MIDFIELDER", 1);
        let offensiveMidfielders = getExactAmountOfPlayers(midfielders, "CENTER_ATTACKING_MIDFIELDER", 1);
        let leftMidfielders = getExactAmountOfPlayers(midfielders, "LEFT_WINGER", 1);
        let rightMidfielders = getExactAmountOfPlayers(midfielders, "RIGHT_WINGER", 1);
        team.midfielders = [...defensiveMidfielders,...offensiveMidfielders,...leftMidfielders,...rightMidfielders];
    }
    if (midfieldersLine === "5") {
        let defensiveMidfielders = getExactAmountOfPlayers(midfielders, "CENTER_DEFENSIVE_MIDFIELDER", 2);
        let offensiveMidfielders = getExactAmountOfPlayers(midfielders, "CENTER_ATTACKING_MIDFIELDER", 1);
        let leftMidfielders = getExactAmountOfPlayers(midfielders, "LEFT_WINGER", 1);
        let rightMidfielders = getExactAmountOfPlayers(midfielders, "RIGHT_WINGER", 1);
        team.midfielders = [...defensiveMidfielders,...offensiveMidfielders,...leftMidfielders,...rightMidfielders];
    }
    if (attackersLine === "1") {
        team.attackers = getExactAmountOfPlayers(attackers, "STRIKER", 1);
    }
    if (attackersLine === "2") {
        team.attackers = getExactAmountOfPlayers(attackers, "STRIKER", 2);
    }
    if (attackersLine === "3") {
        let strikers = getExactAmountOfPlayers(attackers, "STRIKER", 1);
        let leftWingers = getExactAmountOfPlayers(attackers, "LEFT_WINGER", 1);
        let rightWingers = getExactAmountOfPlayers(attackers, "RIGHT_WINGER", 1);
        team.attackers = [...strikers,...leftWingers,...rightWingers];
    }
    if (attackersLine === "4") {
        let strikers = getExactAmountOfPlayers(attackers, "STRIKER", 2);
        let leftWingers = getExactAmountOfPlayers(attackers, "LEFT_WINGER", 1);
        let rightWingers = getExactAmountOfPlayers(attackers, "RIGHT_WINGER", 1);
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

registerOnMatch(1,2);


module.exports = {registerOnMatch};
