package club.manager.entrance_cockpit.messaging.bridge;

import club.manager.common_library.dto.PlayerHealthStatsDTO;
import club.manager.common_library.dto.TeamHealthStatsDTO;
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
public class TeamHealthStatsBridge {
    private final WebSocketService webSocketService;
    private final ConcurrentHashMap<Long, List<TeamHealthStatsDTO>> teamHealthStats = new ConcurrentHashMap<>();
    private final ObjectMapper mapper = new ObjectMapper();
    private final LiveMatchStateService liveMatchStateService;
    @KafkaListener(topics = "health-team-live", groupId = "entrance-cockpit-health-team-live")
    public void consumeHeatMapEvents(String message) {
        PayloadDTO payloadDTO = mapper.readValue(message, PayloadDTO.class);
        List<TeamHealthStatsDTO> playerHealthStatsDTOS = payloadDTO.getPayloadAsList(TeamHealthStatsDTO.class);
        if (playerHealthStatsDTOS != null && !playerHealthStatsDTOS.isEmpty()){
            Long matchId = playerHealthStatsDTOS.getFirst().getMatchId();
            teamHealthStats.put(matchId, playerHealthStatsDTOS);
        }
    }

    @Scheduled(fixedRate = 3000)
    public void sendStatsDTOs() {
        teamHealthStats.forEach((matchId, statsDTOS) -> {
            if (liveMatchStateService.isMatchNotRunning(matchId)) {
                return;
            }
            statsDTOS.forEach(elem -> {
                webSocketService.sendObjectToTopic(elem, "live-match/" + elem.getMatchId() + "/health-team-live/" + elem.getTeamId());
            });
        });
    }

    @Scheduled(cron = "0 0 * * * *")
    public void cleanupFinishedMatches() {
        List<Long> matchesToRemove = new ArrayList<>();
        teamHealthStats.forEach((matchId, list) -> {
            if (liveMatchStateService.isMatchFinished(matchId)){
                matchesToRemove.add(matchId);
            }
        });
        matchesToRemove.forEach(teamHealthStats::remove);
    }


    public List<TeamHealthStatsDTO> getCurrentTeamHealthStats(Long matchId){
        return teamHealthStats.getOrDefault(matchId, null);
    }
}
