/**
 * Generated from: MatchStateDTO.java
 * Generated on: 2026-01-16 15:43:32
 */

import { MatchEventEnum } from '../../enums/generated/MatchEventEnum';
import type { Score } from './Score';

export interface MatchState {
  matchId: number;
  teamId: number;
  matchEvent: MatchEventEnum;
  matchTime: number;
  team: string;
  score: Score;
}
