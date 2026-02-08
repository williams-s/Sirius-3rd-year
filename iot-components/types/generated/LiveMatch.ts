/**
 * Generated from: LiveMatchDTO.java
 * Generated on: 2026-02-08 19:05:41
 */

import type { BallEvent } from './BallEvent';
import type { MatchState } from './MatchState';
import type { PlayerPosition } from './PlayerPosition';

export interface LiveMatch {
  ballEvent: BallEvent;
  playersPositions: PlayerPosition[];
  matchState: MatchState;
}
