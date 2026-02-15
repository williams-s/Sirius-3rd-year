/**
 * Generated from: TeamResponseDTO.java
 * Generated on: 2026-02-14 00:44:46
 */

import type { ClubResponse } from './ClubResponse';

export interface TeamResponse {
  teamId: number;
  name: string;
  coach: string;
  stadium: string;
  league: string;
  club: ClubResponse;
}
