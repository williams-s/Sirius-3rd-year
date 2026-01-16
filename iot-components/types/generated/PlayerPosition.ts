/**
 * Generated from: PlayerPositionDTO.java
 * Generated on: 2026-01-16 15:43:32
 */

import type { Coordinates2D } from './Coordinates2D';
import { PositionEnum } from '../../enums/generated/PositionEnum';

export interface PlayerPosition {
  matchId: number;
  player_id: number;
  team_id: number;
  player_coordinates: Coordinates2D;
  distance_covered: number;
  has_ball: boolean;
  position: PositionEnum;
}
