const {simulateGivenMatches} = require("./functions/simulateGivenMatches");

const args = process.argv.slice(3);
const matchIdTab = JSON.parse(args[0]);

simulateGivenMatches(matchIdTab).then(_ => process.exit(0));