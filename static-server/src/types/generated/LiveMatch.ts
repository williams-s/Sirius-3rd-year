/**
 * Generated from: LiveMatchDTO.java
 * Generated on: 2026-02-13 17:35:58
 */

import type { BallEvent } from './BallEvent';
import type { MatchState } from './MatchState';
import type { PlayerPosition } from './PlayerPosition';
import type { PlayerResponse } from './PlayerResponse';

export interface LiveMatch {
  ballEvent: BallEvent;
  playersPositions: PlayerPosition[];
  matchState: MatchState;
  matchSheet: PlayerResponse[];
}
