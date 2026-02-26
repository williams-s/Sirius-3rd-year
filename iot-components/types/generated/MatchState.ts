/**
 * Generated from: MatchStateDTO.java
 * Generated on: 2026-02-25 16:25:25
 */

import { MatchStateEnum } from '../../enums/generated/MatchStateEnum';
import type { Score } from './Score';

export interface MatchState {
  matchId: number;
  matchStateEnum: MatchStateEnum;
  matchTime: number;
  score: Score;
}
