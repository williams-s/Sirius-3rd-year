/**
 * Generated from: PlayerPositionDTO.java
 * Generated on: 2026-01-10 16:50:49
 */

import type { Coordinates2D } from './Coordinates2D';

export interface PlayerPosition {
  team: string;
  player_coordinates: Coordinates2D;
  distance_covered: number;
  has_ball: boolean;
  position: string;
}
