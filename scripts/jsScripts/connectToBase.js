const { Pool } = require('pg');
const fs = require('fs');

const configPath =  process.argv[2] || 'jsScripts/config/config.json';
let databaseData = {};

//Pour se connecter a la database
if (fs.existsSync(configPath)) {
    const jsonData = fs.readFileSync(configPath, 'utf-8');
    const data = JSON.parse(jsonData);
    databaseData = data.database;
} else {
    console.error("NO");
    process.exit(1);
}

const host = process.env.DB_HOST || 'localhost';
const pool = new Pool({
    host,
    database: databaseData.dbname,
    user: databaseData.user,
    password: databaseData.password
});


module.exports = {pool}



