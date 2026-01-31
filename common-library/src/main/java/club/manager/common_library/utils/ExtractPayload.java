package club.manager.common_library.utils;

import club.manager.common_library.dto.*;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.List;

public class ExtractPayload {

    private final ObjectMapper objectMapper = new ObjectMapper();

    public BallEventDTO extractBallEvent(String value) {
        return extract(value, BallEventDTO.class);
    }

    public MatchStateDTO extractMatchState(String value) {
        return extract(value, MatchStateDTO.class);
    }

    public List<PlayerPositionDTO> extractPlayersPositions(String value) {
        return extractPayloadList(value, PlayerPositionDTO.class);
    }

    public List<PlayerHealthDTO> extractPlayersHealth(String value) {
        return extractPayloadList(value, PlayerHealthDTO.class);
    }

    public MatchEventDTO extractMatchEvent(String value) {
        return extract(value, MatchEventDTO.class);
    }

    private <T> T extract(String value, Class<T> className) {
        try {
            JsonNode root = objectMapper.readTree(value);
            if (root.has("payload")) {
                JsonNode payload = root.get("payload");
                return objectMapper.treeToValue(payload, className);
            }
            return objectMapper.treeToValue(root, className);
        } catch (Exception e) {
            return null;
        }
    }

    public <T> List<T> extractPayloadList(String value, Class<T> className) {
        try {
            JsonNode root = objectMapper.readTree(value);
            if (root.has("payload")) {
                JsonNode payload = root.get("payload");

                JsonNode arrayNode = null;

                if (payload.has("playersPosition")) {
                    arrayNode = payload.get("playersPosition");
                } else if (payload.has("playersHealth")) {
                    arrayNode = payload.get("playersHealth");
                }
                if (arrayNode != null && arrayNode.isArray()) {
                    objectMapper.enable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
                    List<T> res = objectMapper.readValue(arrayNode.toString(), objectMapper.getTypeFactory().constructCollectionType(List.class, className));
                    return res;
                }
            }
            return List.of();
        } catch (Exception e) {
            System.out.println("Failed to extract payload list from message: " + e.getMessage());
            return null;
        }
    }

}
