const cheerio = require('cheerio');
const {insertQuery} = require("../sqlQueries.js");
const main = async () => {
    let clubAndTeam = [];
    const clubsLigue2 = [
        "FC_Lorient",
        "USL_Dunkerque",
        "Paris_FC",
        "FC_Metz",
        "FC_Annecy",
        "Stade lavallois Mayenne Football Club",
        "EA_Guingamp",
        "Pau_FC",
        "Amiens_SC",
        "SC_Bastia",
        "Grenoble Foot 38",
        "ESTAC",
        "Red_Star",
        "Rodez_AF",
        "Clermont_Foot_63",
        "SM_Caen",
        "AC_Ajaccio",
        "FC_Martigues"
    ];
    const clubsLigue1 = [
        "Paris_Saint-Germain",
        "Olympique_de_Marseille",
        "AS_Monaco",
        "LOSC_Lille",
        "Olympique_Lyonnais",
        "OGC_Nice",
        "RC_Lens",
        "Toulouse_FC",
        "AJ_Auxerre",
        "Racing_Club_de_Strasbourg_Alsace",
        "Stade_de_Reims",
        "Stade_brestois_29",
        "Stade_rennais_Football_Club",
        "Angers_SCO",
        "AS_Saint-Etienne",
        "FC_Nantes",
        "Le_Havre_Athletic_Club_(football)",
        "Montpellier_HSC"
    ];
    const clubsNational = [
        "AS Nancy-Lorraine",
        "US_Boulogne",
        "US_Orleans",
        "Football_Club_Sochaux-Montbéliard",
        "Dijon_FCO",
        "US_Concarneau",
        "Aubagne_FC",
        "Football_Bourg-en-Bresse_Péronnas_01",
        "Football_Club_de_Rouen_1899",
        "Le_Mans_FC",
        "Union_sportive_Quevilly_Rouen_Métropole",
        "Valenciennes_Football_Club",
        "Nîmes_Olympique",
        "Football_Club_Versailles_78",
        "Paris_13_Atletico",
        "Football_Club_Villefranche_Beaujolais",
        "La_Berrichonne_de_Châteauroux"
    ];

    async function getClubAndPresident(clubs, leagueName) {
        for (const club of clubs) {
            let res = await getPresidentFromWikipedia(club);
            if (!res) {
                console.warn(`Skipping ${club} — données introuvables`);
                continue;
            }
            res.team.league = leagueName;
            clubAndTeam.push(res);
        }
    }

    async function getPresidentFromWikipedia(clubName) {
        const url = `https://fr.wikipedia.org/wiki/${encodeURIComponent(clubName)}`;

        try {
            const response = await fetch(url);
            const html = await response.text();

            const $ = cheerio.load(html);

            const firstInfobox = $('.infobox').first();

            const presidentName = firstInfobox.find('th:contains("Président")').next().text().trim();
            let stadium = firstInfobox.find('th:contains("Stade")').next().text().trim();
            const coach = firstInfobox.find('th:contains("Entraîneur")').next().text().trim();
            let teamName = $('.entete.icon.football > div').first().text();
            if (!teamName) {
                teamName = $('.entete.icon.footballblack > div').first().text();
            }
            //console.log(teamName);
            //console.log(coach);
            if (presidentName) {
                //console.log(`Le président de ${clubName} est : ${presidentName}`);
                return {
                    club : {
                        name : goodSyntaxe(clubName),
                        president : goodSyntaxe(presidentName)
                    },
                    team : {
                        stadium : onlyStade(stadium),
                        coach : goodSyntaxe(coach),
                        name : goodSyntaxe(teamName)}
                    }
            } else {
                console.log(`Aucun président trouvé pour ${clubName}`);
                return "";
            }
        } catch (error) {
            console.error('Erreur lors de la récupération des données :', error);
        }
        return "";
    }

    function goodSyntaxe(str) {
        let res = str.replace(/\(.*?\)/g, '');
        res = res.replace(/_/g, ' ');
        return res.trim();
    }

    function onlyStade(stade) {
        let res = goodSyntaxe(stade);
        const isTwoSpaces = res.includes("  ");
        let stadiumName;
        if (isTwoSpaces) {
            stadiumName = res.split("  ")[0];
        } else {
            stadiumName = res;
        }
        return stadiumName;
    }

    await getClubAndPresident(clubsLigue1,"LIGUE_1");
    await getClubAndPresident(clubsLigue2,"LIGUE_2");
    await getClubAndPresident(clubsNational,"NATIONAL");
    for (const team of clubAndTeam) {
        const res = await insertQuery("club", team.club, true);
        team.team.id_club = res.id_club;
        console.log(team);
        const id_team = await insertQuery("team", team.team, true);
    }
    //insertQuery("club", {ligue : "ligue1",name: "Olympique_Marseille"}, );
    //const x = await insertQuery("match",{id_team_home: 6, id_team_away: 7,competition: "ligue 1",match_day: "1ere journee"},true);
    //console.log(x);

    console.log(clubAndTeam);
}

main();