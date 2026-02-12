const {pool} = require("../connectToBase.js");
const {GET_ALL_TEAMS_FROM_LEAGUE} = require("../sqlQueries.js");
const {executeQuery} = require("../sqlQueries");

async function getAllTeamsFromLeague(league) {
    let res = await GET_ALL_TEAMS_FROM_LEAGUE(league);
    return res.rows;
}


//On cree un match
async function createMatch (id_team_home, id_team_away, competition, match_day, date_time, season) {
    const client = await pool.connect();
    try {
        const insertQuery = `INSERT INTO match (id_team_home, id_team_away, competition, match_day, date_time, season) VALUES ($1, $2, $3, $4, $5, $6)`;
        await client.query(insertQuery, [id_team_home, id_team_away, competition, match_day, date_time, season]);
        return true;
    } catch (error) {
        console.error("Error inserting player:", error.message);
        return false;
    } finally {
        client.release();
    }
}


function matchDayWithInt(dayName) {
    const days = {
        "dimanche": 0,
        "lundi": 1,
        "mardi": 2,
        "mercredi": 3,
        "jeudi": 4,
        "vendredi": 5,
        "samedi": 6
    };
    return days[dayName.toLowerCase()];
}

function getDaysInTheYear(year, dayName) {
    const days = [];
    let date = new Date(year, 0, 1);
    const targetDay = matchDayWithInt(dayName);

    while (date.getDay() !== targetDay) {
        date.setDate(date.getDate() + 1);
    }

    while (date.getFullYear() === year) {
        const month = date.getMonth() + 1;
        const day = date.getDate();
        const formattedDate = `${date.getFullYear()}-${month.toString().padStart(2, '0')}-${day.toString().padStart(2, '0')}`;
        days.push(formattedDate);
        date.setDate(date.getDate() + 7);
    }

    return days;
}

function dayWithHourMatch (year, daysOfMatchs) {
    const day = daysOfMatchs.day;
    const hours = daysOfMatchs.hours;
    const days = getDaysInTheYear(year, day);
    const obj = [];
    days.map(d => {
        obj.push({day : d, hours : hours});
    })
    return obj;
}

function getCalendar (tab) {
    const obj = [];
    for (let i = 0; i < tab.length; i++) {
        for (let j = 0; j < tab[i].length; j++) {
            obj.push(tab[i][j]);
        }
    }
    obj.sort((a,b) => new Date(a.day) - new Date(b.day));
    const toReturn = [];
    obj.map(o => {
        for (const h of o.hours) {
            let res = o.day;
            res = res + " " + h;
            toReturn.push(res);
        }
    })
    return toReturn;
}

async function main(league,yearArg) {
    const year = Number(yearArg);
    const isMatchesAlreadyCreated = await executeQuery("Select * from match where competition = $1 and season = $2", [league,year]);
    if (isMatchesAlreadyCreated.rows.length > 0) process.exit(1);
    const daysOfMatchs = [
        {
            day : "Vendredi",
            hours : ["20:45:00"]
        },
        {
            day : "Samedi",
            hours : ["17:00:00", "19:00:00", "21:00:00"]
        },
        {
            day : "Dimanche",
            hours : ["15:00:00", "17:00:00", "17:00:00", "19:00:00", "20:45:00"]
        }
    ];
    const teams = await getAllTeamsFromLeague(league);
    const lengthTeams = teams.length;

    // Ajouter une équipe fictive si le nombre d'équipes est impair
    const hasBye = lengthTeams % 2 !== 0;
    if (hasBye) {
        teams.push("Bye"); // Une équipe "Bye" pour équilibrer
    }

    const totalTeams = teams.length;
    const totalRounds = totalTeams - 1;
    const matchDays = Array.from({ length: totalRounds * 2 }, () => []); // Aller et retour

    for (let round = 0; round < totalRounds; round++) {
        for (let i = 0; i < totalTeams / 2; i++) {
            const homeIndex = (round + i) % (totalTeams - 1);
            const awayIndex = (totalTeams - 1 - i + round) % (totalTeams - 1);

            const homeTeam = teams[homeIndex];
            const awayTeam = teams[awayIndex === homeIndex ? totalTeams - 1 : awayIndex];

            if (homeTeam !== "Bye" && awayTeam !== "Bye") {
                matchDays[round].push([homeTeam, awayTeam]);
            }

            if (homeTeam !== "Bye" && awayTeam !== "Bye") {
                matchDays[round + totalRounds].push([awayTeam, homeTeam]);
            }
        }
    }

    const fridays = dayWithHourMatch(year, daysOfMatchs[0]);
    const saturdays = dayWithHourMatch(year, daysOfMatchs[1]);
    const sundays = dayWithHourMatch(year, daysOfMatchs[2]);
    //console.log(saturdays);
    const calendar = (getCalendar([fridays, saturdays, sundays]));
    //console.log(calendar);
    let slotTime = 0;
    for (let day = 0; day < matchDays.length; day++) {
        for (const [team1, team2] of matchDays[day]) {
            await createMatch(team1.id_team, team2.id_team, league, `${day + 1}e journée`,calendar[slotTime], year);
            //console.log(`Match ${day + 1} : ${team1.id_team} vs ${team2.id_team} pour la ligue ${league} le ${calendar[slotTime]}`);
            slotTime++;
        }
    }
    return true;
}




const args = process.argv.slice(3);
main(args[0], args[1]).then(r => {
    console.log(r);
    process.exit(0)}
);
//console.log(args);
//main("LIGUE_1", 2025).then(_ => process.exit(0));

//main("LIGUE_1").then(main("LIGUE_2")).then(main("NATIONAL"));
