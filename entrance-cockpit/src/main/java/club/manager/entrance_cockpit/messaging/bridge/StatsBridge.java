package club.manager.entrance_cockpit.messaging.bridge;
import club.manager.common_library.dto.HeatMapPlayerDTO;
import club.manager.common_library.dto.StatsDTO;
import club.manager.common_library.parentDTO.PayloadDTO;
import club.manager.entrance_cockpit.application.service.LiveMatchStateService;
import club.manager.entrance_cockpit.messaging.websocket.WebSocketService;
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
public class StatsBridge {
    private final WebSocketService webSocketService;
    private final ConcurrentHashMap<Long, List<StatsDTO>> statsPlayers = new ConcurrentHashMap<>();
    private final ObjectMapper mapper = new ObjectMapper();
    private final LiveMatchStateService liveMatchStateService;
    @KafkaListener(topics = "stats-player-position", groupId = "entrance-cockpit-stats-player-position")
    public void consumeHeatMapEvents(String message) {
        PayloadDTO payloadDTO = mapper.readValue(message, PayloadDTO.class);
        List<StatsDTO> statsDtos = payloadDTO.getPayloadAsList(StatsDTO.class);
        if (statsDtos != null && !statsDtos.isEmpty()){
            Long matchId = statsDtos.getFirst().getMatchId();
            statsPlayers.put(matchId, statsDtos);
        }
    }

    @Scheduled(fixedRate = 5000)
    public void sendStatsDTOs() {
        statsPlayers.forEach((matchId, statsDTOS) -> {
            if (liveMatchStateService.isMatchNotRunning(matchId)) {
                return;
            }
            statsDTOS.forEach(elem -> {
                webSocketService.sendObjectToTopic(elem, "live-match/" + elem.getMatchId() + "/stats-player-position/" + elem.getPlayerId());
            });
        });
    }

    @Scheduled(cron = "0 0 * * * *")
    public void cleanupFinishedMatches() {
        List<Long> matchesToRemove = new ArrayList<>();
        statsPlayers.forEach((matchId, list) -> {
            if (liveMatchStateService.isMatchFinished(matchId)){
                matchesToRemove.add(matchId);
            }
        });
        matchesToRemove.forEach(statsPlayers::remove);
    }


    public List<StatsDTO> getCurrentStats(Long matchId){
        return statsPlayers.getOrDefault(matchId, null);
    }
}
