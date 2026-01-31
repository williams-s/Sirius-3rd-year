/**
 * Generated from: LiveMatchDTO.java
 * Generated on: 2026-01-16 10:09:20
 */

import type { BallEvent } from './BallEvent';
import type { MatchState } from './MatchState';
import type { PlayerLiveMatchDetail } from './PlayerLiveMatchDetail';

export interface LiveMatch {
  ballEvent: BallEvent;
  allPlayers: PlayerLiveMatchDetail[];
  matchState: MatchState;
}
