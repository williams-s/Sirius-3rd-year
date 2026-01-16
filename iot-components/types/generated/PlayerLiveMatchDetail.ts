/**
 * Generated from: PlayerLiveMatchDetailDTO.java
 * Generated on: 2026-01-16 15:43:32
 */

import type { MatchEvent } from './MatchEvent';
import type { PlayerHealth } from './PlayerHealth';
import type { PlayerPosition } from './PlayerPosition';
import type { Stats } from './Stats';

export interface PlayerLiveMatchDetail {
  matchId: number;
  player_id: number;
  team_id: number;
  player_position_data: PlayerPosition;
  player_health_data: PlayerHealth;
  match_event_data: MatchEvent;
  statsDTO: Stats;
}
