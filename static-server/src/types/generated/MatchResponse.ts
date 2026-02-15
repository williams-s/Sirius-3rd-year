/**
 * Generated from: MatchResponseDTO.java
 * Generated on: 2026-02-15 15:39:00
 */

import { MatchStatusEnum } from '../../enums/generated/MatchStatusEnum';
import type { TeamResponse } from './TeamResponse';

export interface MatchResponse {
  idMatch: number;
  homeTeam: TeamResponse;
  awayTeam: TeamResponse;
  homeScore: number;
  awayScore: number;
  date: string;
  status: MatchStatusEnum;
  competition: string;
  season: string;
  matchDay: string;
}
