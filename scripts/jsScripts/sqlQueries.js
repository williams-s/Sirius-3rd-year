const {pool} = require("./connectToBase");

//On defini ici toutes nos requetes SQL

let isConnected = false;
let client = null;

const connect = async () => {
    if (!isConnected) {
        client = await pool.connect();
        isConnected = true;
    }
}

const disconnect = async () => {
    if (isConnected) {
        await client.release();
        isConnected = false;
    }
}

const executeQuery = async (query, params = []) => {
    await connect();
    let res = await client.query(query, params);
    /*if (res) {
        console.log("True");
    }*/
    await disconnect();
    return res;
}

const GET_ALL_TEAMS =  async () => {
    return await executeQuery("SELECT * FROM team");
}

const GET_ALL_TEAMS_FROM_LEAGUE =  async (league) => {
    return await executeQuery("SELECT * FROM team WHERE league = $1", [league]);
}

//On recupere tous les id des matches
const GET_ID_ALL_MATCHES = async () => {
    return await executeQuery("SELECT id_match FROM match");
}
//On recupere tous les joueurs d'un match
const GET_ALL_PLAYERS_FROM_MATCH = async (id_match) => {
    return await executeQuery(`
            SELECT team.id_team, team.name AS team, players.name, players.first_name,
                   player_belongs_team.shirt_number AS shirt_number,
                   in_game_stats.position, in_game_stats.status ,in_game_stats.id_player
            FROM in_game_stats
                     JOIN players ON players.id_players = in_game_stats.id_player
                     JOIN player_belongs_team ON players.id_players = player_belongs_team.id_player
                     JOIN team ON team.id_team = in_game_stats.id_team
            WHERE id_match = $1
            GROUP BY team.id_team, players.id_players, team, shirt_number, in_game_stats.position,in_game_stats.status,in_game_stats.id_player
            ORDER BY shirt_number ASC;
            `, [id_match]);
}

const IS_MATCH_ALREADY_PLAYED = async (id_match) => {
    let res = await executeQuery("SELECT id_match FROM in_game_stats WHERE id_match = $1", [id_match]);
    return res.rows.length > 0;
}
//On recupere toutes les ligues
const GET_ALL_LEAGUES = async () => {
    return await executeQuery("SELECT * FROM league");
}

const GET_ALL_PLAYERS_FROM_TEAM_THAT_PLAY_THE_MATCH = async (id_match, side = "home") => {
    let sqlQuery = "";
    if (side === "away") {
        sqlQuery = `
            SELECT match.id_match,match.id_team_away, away_team.id_player,players.position from match
                join player_belongs_team AS away_team
                    ON away_team.id_team = match.id_team_away
                join players 
                    ON away_team.id_player = players.id_players
                where id_match = $1
            group by match.id_match,away_team.id_player,players.position`;
    } else {
        sqlQuery = `
            SELECT match.id_match,match.id_team_home, home_team.id_player,players.position from match
                join player_belongs_team AS home_team
                    ON home_team.id_team = match.id_team_home
                join players 
                    ON home_team.id_player = players.id_players
                where id_match = $1
            group by match.id_match,home_team.id_player,players.position`;
    }
    return await executeQuery(sqlQuery, [id_match]);
}

/**
 * @summary Update une table avec les valeurs et conditions
 * @param {string} table - Le nom de la table
 * @param {Object[]} values - Les valeurs a mettre a jour (ex: [{first_name: "Williams", goals: 2}] )
 * @param {Object[]} conditions - Les conditions du update (ex : [{id_player: 1}, {id_player: 2}])
 */
const updateQuery = async (table,values,conditions) => {
    await connect();
    //On parcourt les valeurs a mettre a jour avec les conditions
    for (let i = 0; i < values.length; i++) {
        let strValues = "";
        for (const [key, value] of Object.entries(values[i])) {
            strValues += `${key} = '${value}', `;
        }
        strValues = strValues.slice(0, -2); //Pour enlever la virgule et l espace a la fin
        let strConditions = "";
        for (const [key, value] of Object.entries(conditions[i])) {
            strConditions += `${key} = '${value}' AND `;
        }
        strConditions = strConditions.slice(0, -5); //Pour enlever le AND et l espace a la fin de la requete
        const updateQuery = `UPDATE ${table} SET ${strValues} WHERE ${strConditions}`;
        //On execute la requete
        await client.query(updateQuery);
    }
    await disconnect();
}

const insertQuery = async (table,values,isReturningId=false) => {
    await connect();
    const keys = Object.keys(values);
    const placeholders = keys.map((_, index) => `$${index + 1}`);
    const params = Object.values(values);
    let query = `INSERT INTO ${table} (${keys.join(', ')}) VALUES (${placeholders.join(', ')})`;
    if (isReturningId) {
        query += ` RETURNING id_${table}`;
    }

    //console.log('Requête SQL générée :', query);
    //On execute la requete
    const res = await client.query(query, params);
    await disconnect();
    return res.rows[0];
}


module.exports = {GET_ID_ALL_MATCHES, GET_ALL_PLAYERS_FROM_MATCH,
    updateQuery, GET_ALL_LEAGUES, insertQuery, executeQuery, GET_ALL_TEAMS,
    GET_ALL_TEAMS_FROM_LEAGUE,
GET_ALL_PLAYERS_FROM_TEAM_THAT_PLAY_THE_MATCH,
IS_MATCH_ALREADY_PLAYED};