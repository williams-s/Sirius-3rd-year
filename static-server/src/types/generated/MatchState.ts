/**
 * Generated from: MatchStateDTO.java
 * Generated on: 2026-01-14 18:21:34
 */

import { MatchEventEnum } from '../../enums/generated/MatchEventEnum';
import type { Score } from './Score';

export interface MatchState {
  match_event: MatchEventEnum;
  match_time: number;
  team: string;
  score: Score;
}
