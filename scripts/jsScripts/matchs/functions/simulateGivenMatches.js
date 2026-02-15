const {simulateMatch} = require("./simulateMatch.js");
const {sortPlayersByTeam} = require("./sortPlayers.js");
const {GET_ID_ALL_MATCHES, GET_ALL_PLAYERS_FROM_MATCH, updateQuery, IS_MATCH_ALREADY_PLAYED} = require("../../sqlQueries.js");
const {registerOnMatch} = require("../../players/matchSheet");
const {executeQuery} = require("../../sqlQueries");
async function simulateGivenMatches(matchIdTab = []) {
    try {
        //console.log(matchIdTab);
        for (const matchId of matchIdTab) {
            if (await IS_MATCH_ALREADY_PLAYED(matchId)) {
                console.log(`Le match d'id : ${matchId} a deja ete joué`);
                continue;
            }
            await registerOnMatch(matchId);
            let matchInfoRes = await executeQuery("Select * from match where id_match = $1",[matchId]);
            let matchInfo = matchInfoRes.rows[0];
            //console.log(matchInfo);
            let teamHomeId = matchInfo.id_team_home;
            //console.log(teamHomeId);
            //let teamAwayId = matchInfo.id_team_away;
            const playersRes = await GET_ALL_PLAYERS_FROM_MATCH(matchId);
            const players = playersRes.rows;
            //console.log(players);
            //On trie les joueurs par equipe
            let [firstTeam, secondTeam] = sortPlayersByTeam(players);

            //console.log(firstTeam,secondTeam);
            //console.log(firstTeam.players.length, secondTeam.players.length);

            //On simule le match
            const resultOfMatch = await simulateMatch(firstTeam, secondTeam, matchId);

            //console.log(resultOfMatch.firstTeam);

            let teamHomeObj = {};
            let teamAwayObj = {};

            let resultFirstTeam = resultOfMatch.firstTeam;
            let resultSecondTeam = resultOfMatch.secondTeam;
            if (resultFirstTeam.id === teamHomeId) {
                teamHomeObj = resultFirstTeam;
                teamAwayObj = resultSecondTeam;
            }else {
                teamAwayObj = resultFirstTeam;
                teamHomeObj = resultSecondTeam;
            }
            //console.log(teamHomeObj,teamAwayObj);
            await updateQuery("match", [{score_home: teamHomeObj.score, score_away: teamAwayObj.score}], [{id_match: matchId}]);
        }
        process.exit();
    } catch (error) {
        console.error("Pas reussi a se connecter:", error.message);
    }
}


//getAllMatchsBeforeToday();
//simulateGivenMatches(matchIdTab);

module.exports = {simulateGivenMatches}
