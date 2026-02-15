/**
 * Generated from: TeamResponseDTO.java
 * Generated on: 2026-02-10 12:38:04
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
