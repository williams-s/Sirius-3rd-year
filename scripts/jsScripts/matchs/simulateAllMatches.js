const {executeQuery} = require("../sqlQueries");
const {simulateGivenMatches} = require("./functions/simulateGivenMatches");

async function simulateAllMatches() {
    try {
        const sql = `
            SELECT id_match FROM match`;
        const res = await executeQuery(sql);
        await simulateGivenMatches((res.rows).map(match => match.id_match));
    }catch (error) {
        console.error("Bug :", error.message);
    }
}

simulateAllMatches();