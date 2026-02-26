/**
 * Generated from: TeamHealthStatsDTO.java
 * Generated on: 2026-02-25 02:41:51
 */

import type { PlayerHealthStats } from './PlayerHealthStats';

export interface TeamHealthStats {
  matchId: number;
  teamId: number;
  avgHeartRate: number;
  avgTemperature: number;
  avgStamina: number;
  playerHealthStatsDTOList: PlayerHealthStats[];
}
