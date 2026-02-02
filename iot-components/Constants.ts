import {MqttPublish} from "./classes/MqttPublish";
import {Player} from "./classes/Player";
import {PositionEnum} from "./enums/generated/PositionEnum";

export const OPTIONS_MIDFIELDER = [
    {action: "carry", probability: 4},
    {action: "pass", probability: 3, to_position: "MIDFIELDER"},
    {action: "pass", probability: 1.3, to_position: "FORWARD"},
    {action: "pass", probability: 1.3, to_position: "DEFENDER"},
    {action: "pass", probability: 0.01, to_position: "GOALKEEPER"},
    {action: "dribble", probability: 0.3}
];

export const OPTIONS_FORWARD = [
    {action: "carry", probability: 3},
    {action: "pass", probability: 1, to_position: "MIDFIELDER"},
    {action: "pass", probability: 1, to_position: "FORWARD"},
    {action: "pass", probability: 0.009, to_position: "DEFENDER"},
    {action: "dribble", probability: 1.5}
];

export const OPTIONS_DEFENDER = [
    {action: "carry", probability: 3},
    {action: "pass", probability: 2.5, to_position: "MIDFIELDER"},
    {action: "pass", probability: 0.1, to_position: "FORWARD"},
    {action: "pass", probability: 1.8, to_position: "DEFENDER"},
    {action: "pass", probability: 0.2, to_position: "GOALKEEPER"},
    {action: "dribble", probability: 0.2}
];

export const OPTIONS_GOALKEEPER = [
    {action: "pass", probability: 0.4, to_position: "MIDFIELDER"},
    {action: "pass", probability: 0.05, to_position: "FORWARD"},
    {action: "pass", probability: 1.0, to_position: "DEFENDER"}
];

export const SUCCESS_RATES = {
    "MIDFIELDER": {pass: 0.9, dribble: 0.6, carry: 0.95, shot: 0.1, tackle: 0.4},
    "FORWARD": {pass: 0.85, dribble: 0.4, carry: 0.9, shot: 0.25, tackle: 0.2},
    "DEFENDER": {pass: 0.92, dribble: 0.6, carry: 0.95, shot: 0.1, tackle: 0.7},
    "GOALKEEPER": {pass: 0.95, carry: 0.98, save: 0.85}
};

export const FIELD_WIDTH = 105;
export const FIELD_HEIGHT = 68;
export const GOAL_WIDTH = 7.32;

export interface TeamSimulate {
    players : Player[],
    side : string,
    teamId : number,
    name : string
}

export const getOptionsForPosition = (position: PositionEnum)=> {
    if (position.includes("MIDFIELDER")) return OPTIONS_MIDFIELDER;
    if (position.includes("WING") || position === "STRIKER") return OPTIONS_FORWARD;
    if (position.includes("BACK")) return OPTIONS_DEFENDER;
    if (position === "GOALKEEPER") return OPTIONS_GOALKEEPER;
    return OPTIONS_MIDFIELDER;
}
