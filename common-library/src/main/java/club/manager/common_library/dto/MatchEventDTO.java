package club.manager.common_library.dto;

import club.manager.common_library.enums.EventTypeEnum;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MatchEventDTO {

    private String team;

    @JsonProperty("event_type")
    private EventTypeEnum eventType;

}
