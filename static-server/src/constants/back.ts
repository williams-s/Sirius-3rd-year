export const ENTRANCE_COCKPIT_SERVER = import.meta.env.VITE_ENTRANCE_COCKPIT_SERVER || 'http://localhost:8082';
export const WEBSOCKET_URL = ENTRANCE_COCKPIT_SERVER + '/ws';
export const API_URL = ENTRANCE_COCKPIT_SERVER + "/api"

export const MATCH_API = API_URL + "/match"
export const LIVE_MATCH_API = API_URL + "/live-match"


export const LIVE_MATCH_TOPIC = "/topic/live-match";

export const PLAYER_API = API_URL + "/player";
export const TEAM_API = API_URL + "/team";
export const CLUB_API = API_URL + "/club";

export const TEST_API = API_URL + "/test";

