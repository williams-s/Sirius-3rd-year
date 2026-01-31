/**
 * Generated from: LiveMatchDTO.java
 * Generated on: 2026-01-10 16:32:04
 */

import type { BallEvent } from './BallEvent';
import type { MatchState } from './MatchState';
import type { PlayerLiveMatchDetail } from './PlayerLiveMatchDetail';

export interface LiveMatch {
  ballEvent: BallEvent;
  allPlayers: PlayerLiveMatchDetail[];
  matchState: MatchState;
}
