package club.manager.entrance_cockpit.messaging.bridge;

import club.manager.common_library.dto.PlayerResponseDTO;
import club.manager.common_library.utils.ExtractPayload;
import club.manager.entrance_cockpit.application.service.PlayerService;
import club.manager.entrance_cockpit.messaging.websocket.WebSocketService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

@Component
@RequiredArgsConstructor
@Slf4j
public class MatchSheetBridge {

    private final WebSocketService webSocketService;
    private final ExtractPayload extractPayload = new ExtractPayload();
    private final PlayerService playerService;
    private final ConcurrentHashMap<Long, List<PlayerResponseDTO>> matchSheet = new ConcurrentHashMap<>();
    @KafkaListener(topics = "match-sheet", groupId = "entrance-cockpit-match-sheet")
    public void consumeMatchSheet(String message){
        MatchSheetRecord matchSheetRecord = extractPayload.extract(message, MatchSheetRecord.class);
        if (matchSheetRecord != null){
            List<PlayerResponseDTO> playerResponseDTOS = matchSheetRecord.playersIds.stream().map(playerService::getPlayerById).toList();
            matchSheet.put(matchSheetRecord.matchId, playerResponseDTOS);
            webSocketService.sendObjectToTopic(playerResponseDTOS, "live-match/" + matchSheetRecord.matchId + "/match-sheet");
        }
    }

    public List<PlayerResponseDTO> getMatchSheet(Long matchId){
        return matchSheet.getOrDefault(matchId, null);
    }
    public record MatchSheetRecord(Long matchId, List<Long> playersIds){}
}
