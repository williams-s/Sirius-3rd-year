const {executeQuery} = require("../sqlQueries");
const {simulateGivenMatches} = require("./functions/simulateGivenMatches");

async function simulateAllMatchesOfTheDay() {
    try {
        const sql = `
            SELECT id_match FROM match where match.date_time < CURRENT_TIMESTAMP and match.date_time > (CURRENT_TIMESTAMP - interval '1 day')`;
        const res = await executeQuery(sql);
        if (res.rows.length === 0) {
            console.log("Aucun match n'a ete joué aujourd'hui");
            process.exit(0);
        }
        await simulateGivenMatches((res.rows).map(match => match.id_match));
    }catch (error) {
        console.error("Bug :", error.message);
    }
}

simulateAllMatchesOfTheDay();