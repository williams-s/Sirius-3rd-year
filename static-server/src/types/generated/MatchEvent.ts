/**
 * Generated from: MatchEventDTO.java
 * Generated on: 2026-01-30 12:16:55
 */

import { EventTypeEnum } from '../../enums/generated/EventTypeEnum';

export interface MatchEvent {
  matchId: number;
  playerId: number;
  teamId: number;
  eventType: EventTypeEnum;
  ballTouched: boolean;
}
