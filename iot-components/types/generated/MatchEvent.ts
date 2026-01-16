/**
 * Generated from: MatchEventDTO.java
 * Generated on: 2026-01-16 15:43:32
 */

import { EventTypeEnum } from '../../enums/generated/EventTypeEnum';

export interface MatchEvent {
  matchId: number;
  player_id: number;
  team_id: number;
  event_type: EventTypeEnum;
  ballTouched: boolean;
}
