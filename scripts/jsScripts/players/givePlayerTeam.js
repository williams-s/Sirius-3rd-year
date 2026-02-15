const {pool} = require("../connectToBase.js");
const {executeQuery} = require("../sqlQueries");
const {pl} = require("@faker-js/faker");


const getAllTeams = async () => {
    const rows = (await executeQuery("SELECT id_team FROM team")).rows;
    return rows.map(row => ({ id_team: parseInt(row.id_team) }));
}


async function getAllPlayers(position) {
    return (await executeQuery("SELECT id_players FROM players WHERE position = $1", [position])).rows;
}


async function givePlayerTeam(id_player, id_team) {
    const client = await pool.connect();
    const lastShirtNumber = await client.query(`SELECT MAX(shirt_number) FROM player_belongs_team WHERE id_team = $1`, [id_team]);
    let newShirtNumber = 1;
    if (lastShirtNumber.rows[0].max !== null) {
        newShirtNumber = lastShirtNumber.rows[0].max + 1;
    }
    try {
        const insertQuery = `INSERT INTO player_belongs_team (id_player, id_team, shirt_number) VALUES ($1, $2, $3)`;
        await client.query(insertQuery, [id_player, id_team, newShirtNumber]);
        return true;
    } catch (error) {
        console.error("Error inserting player:", error.message);
        return false;
    } finally {
        client.release();
    }
}


async function isPlayerInTeam(id_player) {
    const client = await pool.connect();
    try {
        const query = `SELECT * FROM player_belongs_team WHERE id_player = $1`;
        const result = await client.query(query, [id_player]);
        return result.rows.length > 0;
    } catch (error) {
        console.error('Error checking player in team:', error);
        return false;
    } finally {
        client.release();
    }
}


async function insertPlayersForAllTeams (position, numberOfPlayersAtThisPosition) {
    let allTeams = await getAllTeams();
    let countAllTeams = allTeams.length;
    let players = await getAllPlayers(position);
    let start = 0
    for (let i = 0; i < countAllTeams; i++) {
        let numberInserted = 0;
        for (let j = start; j  < players.length; j++) {
            //console.log(numberInserted, numberOfPlayersAtThisPosition);
            if (numberInserted >= numberOfPlayersAtThisPosition) {
                break;
            }
            const id = players[j].id_players;
            if (!await isPlayerInTeam(id)) {
                await givePlayerTeam(id, allTeams[i].id_team);
                numberInserted++;
                start++;
            }
        }
    }
}

async function main () {
    await insertPlayersForAllTeams("GOALKEEPER", 1);
    await insertPlayersForAllTeams("CENTER_BACK", 2);
    await insertPlayersForAllTeams("RIGHT_BACK", 1);
    await insertPlayersForAllTeams("LEFT_BACK", 1);
    await insertPlayersForAllTeams("RIGHT_MIDFIELDER", 1);
    await insertPlayersForAllTeams("CENTER_MIDFIELDER", 2);
    await insertPlayersForAllTeams("LEFT_MIDFIELDER", 1);
    await insertPlayersForAllTeams("STRIKER", 2);
    await insertPlayersForAllTeams("LEFT_WINGER", 2);
    await insertPlayersForAllTeams("RIGHT_WINGER", 2);
    await insertPlayersForAllTeams("CENTER_ATTACKING_MIDFIELDER", 2);
    await insertPlayersForAllTeams("CENTER_DEFENSIVE_MIDFIELDER", 2);
    await insertPlayersForAllTeams("CENTER_BACK", 2);
    await insertPlayersForAllTeams("CENTER_MIDFIELDER", 2);
}

main().then(_ => process.exit(0));

