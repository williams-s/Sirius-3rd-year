/**
 * Generated from: MatchEventDTO.java
 * Generated on: 2026-01-30 11:37:43
 */

import { EventTypeEnum } from '../../enums/generated/EventTypeEnum';

export interface MatchEvent {
  matchId: number;
  playerId: number;
  teamId: number;
  eventType: EventTypeEnum;
  ballTouched: boolean;
}
