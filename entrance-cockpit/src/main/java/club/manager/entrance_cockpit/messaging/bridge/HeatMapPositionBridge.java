package club.manager.entrance_cockpit.messaging.bridge;

import club.manager.common_library.parentDTO.PayloadDTO;
import club.manager.entrance_cockpit.application.service.LiveMatchStateService;
import club.manager.entrance_cockpit.messaging.websocket.WebSocketService;
import club.manager.common_library.dto.HeatMapPlayerDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import tools.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

@Component
@RequiredArgsConstructor
@Slf4j
public class HeatMapPositionBridge {
    private final WebSocketService webSocketService;
    private final ConcurrentHashMap<Long, List<HeatMapPlayerDTO>> heatMapPlayers = new ConcurrentHashMap<>();
    private final ObjectMapper mapper = new ObjectMapper();
    private final LiveMatchStateService liveMatchStateService;
    @KafkaListener(topics = "heat-map-player-position", groupId = "entrance-cockpit-heat-map-player-position")
    public void consumeHeatMapEvents(String message) {
        PayloadDTO payloadDTO = mapper.readValue(message, PayloadDTO.class);
        List<HeatMapPlayerDTO> heatMapPlayerDTOs = payloadDTO.getPayloadAsList(HeatMapPlayerDTO.class);
        if (heatMapPlayerDTOs != null && !heatMapPlayerDTOs.isEmpty()){
            Long matchId = heatMapPlayerDTOs.getFirst().matchId();
            heatMapPlayers.put(matchId, heatMapPlayerDTOs);
        }
    }

    @Scheduled(fixedRate = 5000)
    public void sendHeatMapPlayerDTOs() {
        heatMapPlayers.forEach((matchId, heatMapPlayerDTOs) -> {
            if (liveMatchStateService.isMatchNotRunning(matchId)) {
                return;
            }
            heatMapPlayerDTOs.forEach(elem -> {
                webSocketService.sendObjectToTopic(elem, "live-match/" + elem.matchId() + "/heat-map-player-position/" + elem.playerId());
            });
        });
    }

    @Scheduled(cron = "0 0 * * * *")
    public void cleanupFinishedMatches() {
        List<Long> matchesToRemove = new ArrayList<>();
        heatMapPlayers.forEach((matchId, playersPositionsList) -> {
            if (liveMatchStateService.isMatchFinished(matchId)){
                matchesToRemove.add(matchId);
            }
        });
        matchesToRemove.forEach(heatMapPlayers::remove);
    }
}
