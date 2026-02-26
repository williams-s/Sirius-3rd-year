package club.manager.entrance_cockpit.messaging.bridge;

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
public class TeamStatsBridge {

    private final WebSocketService webSocketService;
    private final ConcurrentHashMap<Long, List<StatsDTO>> statsTeams = new ConcurrentHashMap<>();
    private final ObjectMapper mapper = new ObjectMapper();
    private final LiveMatchStateService liveMatchStateService;
    @KafkaListener(topics = "stats-team-live", groupId = "entrance-cockpit-stats-team-live")
    public void consumeHeatMapEvents(String message) {
        PayloadDTO payloadDTO = mapper.readValue(message, PayloadDTO.class);
        List<StatsDTO> statsDtos = payloadDTO.getPayloadAsList(StatsDTO.class);
        if (statsDtos != null && !statsDtos.isEmpty()){
            Long matchId = statsDtos.getFirst().getMatchId();
            statsTeams.put(matchId, statsDtos);
        }
    }

    @Scheduled(fixedRate = 3000)
    public void sendStatsDTOs() {
        statsTeams.forEach((matchId, statsDTOS) -> {
            if (liveMatchStateService.isMatchNotRunning(matchId)) {
                return;
            }
            statsDTOS.forEach(elem -> {
                webSocketService.sendObjectToTopic(elem, "live-match/" + elem.getMatchId() + "/stats-team-live/" + elem.getTeamId());
            });
        });
    }

    @Scheduled(cron = "0 0 * * * *")
    public void cleanupFinishedMatches() {
        List<Long> matchesToRemove = new ArrayList<>();
        statsTeams.forEach((matchId, list) -> {
            if (liveMatchStateService.isMatchFinished(matchId)){
                matchesToRemove.add(matchId);
            }
        });
        matchesToRemove.forEach(statsTeams::remove);
    }


    public List<StatsDTO> getCurrentTeamStats(Long matchId){
        return statsTeams.getOrDefault(matchId, null);
    }
}
