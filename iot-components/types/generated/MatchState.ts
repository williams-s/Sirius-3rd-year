/**
 * Generated from: MatchStateDTO.java
 * Generated on: 2026-02-01 20:53:41
 */

import { MatchStateEnum } from '../../enums/generated/MatchStateEnum';
import type { Score } from './Score';

export interface MatchState {
  matchId: number;
  matchStateEnum: MatchStateEnum;
  matchTime: number;
  score: Score;
}
