const { insertQuery } = require("../sqlQueries.js");
const fs = require('fs').promises; // Utilisation de la version promise de fs
const { Faker,faker, fakerRU, fakerAR, fakerFR, fakerES, fakerPT_BR, fakerDE, fakerIT, fakerEN_GB, fakerPT_PT, fakerNL,
    fakerFR_CH, fakerNL_BE, fakerHR, fakerJA, fakerKO, fakerPL, fakerNB_NO, fakerSV, fakerDA
} = require('@faker-js/faker');
const { transliterate } = require('transliteration');

// Récupération des arguments d'entrée
const args = process.argv.slice(2);

// Récupération des chemins des fichiers JSON
const playerJson = args[1] || 'jsScripts/players/playersInfos.json';
const NUMBER_INSERT_PLAYERS = args[2] || 50;

// Constantes pour les tailles des gardiens
const goalkeeperMinHeight = 185;
const goalkeeperMaxHeight = 205;

// Données extraites des fichiers JSON
let natData = [];
let posData = [];
let footData = [];
let positionsOptions = [];
let footOptions = [];
let nationalityOptions = [];

const fakerLocales = {
    'fr_FR': fakerFR,
    'ru_RU': fakerRU,
    'ar_SA': fakerAR,
    'en_GB': fakerEN_GB,
    'es_ES': fakerES,
    'pt_BR': fakerPT_BR,
    'de_DE': fakerDE,
    'es_AR': fakerES,
    'it_IT': fakerIT,
    'pt_PT': fakerPT_PT,
    'nl_NL': fakerNL,
    'fr_CH': fakerFR_CH,
    'nl_BE': fakerNL_BE,
    'es_UY': fakerES,
    'hr_HR': fakerHR,
    'ja_JP': fakerJA,
    'ko_KR': fakerKO,
    'pl_PL': fakerPL,
    'nb_NO': fakerNB_NO,
    'sv_SE': fakerSV,
    'da_DK': fakerDA,
}

const loadDatas = async () => {
    try {
        // Lecture des fichiers JSON avec la méthode promise-based
        const data = await fs.readFile(playerJson, 'utf8');
        const playerData = JSON.parse(data);
        natData = playerData.nationality;
        posData = playerData.positions;
        footData = playerData.footOptions;

        // Remplissage des options
        Object.keys(natData).forEach(nat => {
            const proba = natData[nat].proba;
            for (let i = 0; i < proba; i++) {
                nationalityOptions.push(nat);
            }
        });

        Object.keys(posData).forEach(pos => {
            const proba = posData[pos];
            for (let i = 0; i < proba; i++) {
                positionsOptions.push(pos);
            }
        });

        Object.keys(footData).forEach(foot => {
            const proba = footData[foot];
            for (let i = 0; i < proba; i++) {
                footOptions.push(foot);
            }
        });
    } catch (err) {
        console.log('Erreur lors de la lecture du fichier playerJson:', err);
    }
}

const generatePlayer = async () => {
    const nationality = randomElemInArray(nationalityOptions);
    const locale = natData[nationality].locale;
    const myFaker = fakerLocales[locale];
    let position = randomElemInArray(positionsOptions);
    let minHeight = 165;
    let maxHeight = 198;
    if (position === 'GARDIEN') {
        minHeight = goalkeeperMinHeight;
        maxHeight = goalkeeperMaxHeight;
    }
    const player = {
        first_name: transliterate(myFaker.person.firstName('male')),
        name: transliterate(myFaker.person.lastName('male')),
        nationality: nationality,
        position: position,
        foot: randomElemInArray(footOptions),
        height: myFaker.number.int({min: minHeight, max: maxHeight}),
        weight: myFaker.number.int({min: 70, max: 98}),
        birth_date: myFaker.date.between({from: '1985-01-01', to: '2008-12-31'}),
    };
    return player;
}

const randomElemInArray = (array) => {
    return array[Math.floor(Math.random() * array.length)];
}
const main = async () => {
    await loadDatas();
    for (let i = 0; i < NUMBER_INSERT_PLAYERS; i++) {
        const player = await generatePlayer();
        await insertQuery("players", player);
    }
    process.exit(0);
}

main();
