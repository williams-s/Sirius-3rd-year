package club.manager.entrance_cockpit.messaging.websocket;

import club.manager.entrance_cockpit.application.dto.MatchResponseDto;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;
import tools.jackson.databind.node.ObjectNode;

import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class WebSocketService {

    private final SimpMessagingTemplate messagingTemplate;


    public void sendMatchHistoryToSession(String sessionId, List<MatchResponseDto> matchs) {
        //log.debug("Sending match history to session: {}", sessionId);
        //log.debug("Match history: {}", matchs.stream().map(MatchResponseDto::toString).toList());
        log.debug("Sending to sessionId={} matches={}", sessionId, matchs.size());
        messagingTemplate.convertAndSendToUser(
                sessionId,
                "/queue/matchHistory",
                matchs
        );
    }

    public void sendObjectToTopic(ObjectNode jsonObject, String topic) {
        messagingTemplate.convertAndSend("/topic/" + topic, jsonObject);
    }

    public void sendMatchHistoryToTopic(List<MatchResponseDto> jsonObject, String topic) {
        messagingTemplate.convertAndSend("/topic/" + topic, jsonObject);
    }
}
