package club.manager.player_performance.utils;


import club.manager.common_library.constants.FieldConstants;
import club.manager.common_library.dto.PlayerPositionDTO;
import org.springframework.stereotype.Component;

import java.util.concurrent.ConcurrentHashMap;

@Component
public class PositionInMatch {

    private final ConcurrentHashMap<Long, ConcurrentHashMap<Long, int[][]>> positions = new ConcurrentHashMap<>();


    public int[][] updatePosition(PlayerPositionDTO playerPositionDTO) {
        var coords = playerPositionDTO.getPlayerCoordinates();
        int xZone = getZone(coords.x(), FieldConstants.FIELD_WIDTH, false);
        int yZone = getZone(coords.y(), FieldConstants.FIELD_HEIGHT, true);
        int[][] zone = getPositionsZone(playerPositionDTO.getMatchId(), playerPositionDTO.getPlayerId());
        zone[xZone][yZone]++;
        return zone;
    }

    private int[][] getPositionsZone(Long matchId, Long playerId) {
        return positions
                .computeIfAbsent(matchId, k -> new ConcurrentHashMap<>())
                .computeIfAbsent(playerId, k -> createNewZone());
    }

    private int getZone(Double XorY, int constant, boolean isY){
        int zone = 0;
        if (isY)
            zone = 3;
        if (XorY < constant / 4.0){
            return zone;
        }
        zone = updateZone(zone, isY);
        if (XorY < constant / 2.0 )
            return zone;
        zone = updateZone(zone, isY);
        if (XorY < constant * 3.0 / 4.0)
            return zone;
        return updateZone(zone, isY);
    }

    private int updateZone(int zone, boolean isY) {
        return isY ? zone - 1 : zone + 1;
    }

    private int[][] createNewZone() {
        return new int[4][4];
    }
}
