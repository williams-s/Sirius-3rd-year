/**
 * Generated from: PlayerPositionDTO.java
 * Generated on: 2026-01-30 11:37:43
 */

import type { Coordinates2D } from './Coordinates2D';
import { PositionEnum } from '../../enums/generated/PositionEnum';

export interface PlayerPosition {
  matchId: number;
  playerId: number;
  teamId: number;
  playerCoordinates: Coordinates2D;
  distanceCovered: number;
  hasBall: boolean;
  position: PositionEnum;
}
