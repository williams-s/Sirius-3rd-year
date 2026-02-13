package club.manager.entrance_cockpit.messaging.websocket;

import club.manager.common_library.dto.MatchResponseDTO;
import club.manager.common_library.dto.PlayerPositionDTO;
import club.manager.common_library.parentDTO.GenericDTO;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class WebSocketService {

    private final SimpMessagingTemplate messagingTemplate;


    public void sendMatchHistoryToSession(String sessionId, List<MatchResponseDTO> matchs) {
        //log.debug("Sending match history to session: {}", sessionId);
        //log.debug("Match history: {}", matchs.stream().map(MatchResponseDTO::toString).toList());
        log.debug("Sending to sessionId={} matches={}", sessionId, matchs.size());
        messagingTemplate.convertAndSendToUser(
                sessionId,
                "/queue/matchHistory",
                matchs
        );
    }

    public void sendObjectToTopic(Object object, String topic) {
        messagingTemplate.convertAndSend("/topic/" + topic, object);
    }

    public void sendDTOtoTopic(GenericDTO genericDTO, String topic) {
        messagingTemplate.convertAndSend("/topic/" + topic, genericDTO);
    }


    public void sendMatchHistoryToTopic(List<MatchResponseDTO> jsonObject, String topic) {
        messagingTemplate.convertAndSend("/topic/" + topic, jsonObject);
    }

    public void sendPlayersPositionsToTopic(List<PlayerPositionDTO> playerPositionDTOList, String topic) {
        messagingTemplate.convertAndSend("/topic/" + topic, playerPositionDTOList);
    }

}
