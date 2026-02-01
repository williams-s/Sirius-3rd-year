export const ENTRANCE_COCKPIT_SERVER = import.meta.env.VITE_ENTRANCE_COCKPIT_SERVER || 'http://localhost:8082';
export const WEBSOCKET_URL = ENTRANCE_COCKPIT_SERVER + '/ws';

export const LIVE_MATCH_TOPIC = "/topic/live-match";