package club.manager.common_library.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Builder
public record TeamScoreDTO(@JsonProperty("team_id") Long teamId, String name, Integer score) {}
