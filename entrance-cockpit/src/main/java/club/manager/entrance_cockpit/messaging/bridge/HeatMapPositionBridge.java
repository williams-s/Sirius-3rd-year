package club.manager.entrance_cockpit.messaging.bridge;

import club.manager.common_library.parentDTO.PayloadDTO;
import club.manager.entrance_cockpit.messaging.websocket.WebSocketService;
import club.manager.common_library.dto.HeatMapPlayerDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import tools.jackson.databind.ObjectMapper;

import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

@Component
@RequiredArgsConstructor
@Slf4j
public class HeatMapPositionBridge {
    private final WebSocketService webSocketService;
    private final AtomicReference<List<HeatMapPlayerDTO>> currentHeatMapPlayerDTOs = new AtomicReference<>();
    private final ObjectMapper mapper = new ObjectMapper();

    @KafkaListener(topics = "heat-map-player-position", groupId = "entrance-cockpit-heat-map-player-position")
    public void consumeHeatMapEvents(String message) {
        PayloadDTO payloadDTO = mapper.readValue(message, PayloadDTO.class);
        List<HeatMapPlayerDTO> heatMapPlayerDTOs = payloadDTO.getPayloadAsList(HeatMapPlayerDTO.class);
        currentHeatMapPlayerDTOs.set(heatMapPlayerDTOs);
    }

    @Scheduled(fixedRate = 5000)
    public void sendHeatMapPlayerDTOs() {
        if (currentHeatMapPlayerDTOs.get() == null)
            return;
        log.debug("Sending heat map information");
        currentHeatMapPlayerDTOs.get().
                forEach(elem ->
                        webSocketService.sendObjectToTopic(elem, "live-match/" + elem.matchId() + "/heat-map-player-position" + elem.playerId()));
    }
}
