/**
 * Generated from: PlayerPositionDTO.java
 * Generated on: 2026-01-14 18:21:34
 */

import type { Coordinates2D } from './Coordinates2D';
import { PositionEnum } from '../../enums/generated/PositionEnum';

export interface PlayerPosition {
  team: string;
  player_coordinates: Coordinates2D;
  distance_covered: number;
  has_ball: boolean;
  position: PositionEnum;
}
