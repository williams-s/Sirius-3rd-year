/**
 * Generated from: MatchResponseDto.java
 * Generated on: 2026-02-08 19:05:28
 */

import { MatchStatusEnum } from '../../enums/generated/MatchStatusEnum';
import type { Short } from './Short';

export interface MatchResponseDto {
  idMatch: number;
  homeTeam: string;
  awayTeam: string;
  homeScore: Short;
  awayScore: Short;
  date: string;
  status: MatchStatusEnum;
  competition: string;
}
