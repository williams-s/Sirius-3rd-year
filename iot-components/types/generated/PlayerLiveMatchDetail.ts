/**
 * Generated from: PlayerLiveMatchDetailDTO.java
 * Generated on: 2026-01-30 11:37:43
 */

import type { MatchEvent } from './MatchEvent';
import type { PlayerHealth } from './PlayerHealth';
import type { PlayerPosition } from './PlayerPosition';
import type { Stats } from './Stats';

export interface PlayerLiveMatchDetail {
  matchId: number;
  playerId: number;
  teamId: number;
  player_position_data: PlayerPosition;
  player_health_data: PlayerHealth;
  match_event_data: MatchEvent;
  statsDTO: Stats;
}
