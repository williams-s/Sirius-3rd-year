package club.manager.common_library.dto;

import club.manager.common_library.enums.EventType;
import club.manager.common_library.enums.Position;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MatchEventDTO {

    private String team;

    @JsonProperty("event_type")
    private EventType eventType;

}
