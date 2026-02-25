package club.manager.team_performance.streams;

import club.manager.common_library.dto.*;
import club.manager.common_library.keys.TeamKey;
import club.manager.common_library.parentDTO.PayloadDTO;
import club.manager.common_library.utils.ExtractPayload;
import club.manager.team_performance.service.TeamService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.common.serialization.Deserializer;
import org.apache.kafka.common.serialization.Serde;
import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.common.serialization.Serializer;
import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.kstream.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import tools.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Configuration
@AllArgsConstructor
@Slf4j
public class MatchStreams {

    private final ObjectMapper objectMapper;
    private final ExtractPayload extractPayload = new ExtractPayload();
    private final TeamService teamService;
    @Bean
    public KStream<String, MatchEventDTO> matchStream(StreamsBuilder builder) {


        KStream<String, MatchEventDTO> matchEvents =
                builder.stream("match-events", Consumed.with(Serdes.String(), Serdes.String()))
                        .mapValues(extractPayload::extractMatchEvent)
                        .filter((k, v) -> v != null);

        KStream<String, List<PlayerPositionDTO>> playerPosition =
                builder.stream("players-position", Consumed.with(Serdes.String(), Serdes.String()))
                        .mapValues(extractPayload::extractPlayersPositions)
                        .filter((k, v) -> v != null);

        KStream<String, List<PlayerHealthDTO>> playerHealth =
                builder.stream("players-health", Consumed.with(Serdes.String(), Serdes.String()))
                        .mapValues(extractPayload::extractPlayersHealth)
                        .filter((k, v) -> v != null);

        KStream<String, MatchEventDTO> matchByPlayer =
                matchEvents
                        .peek((k,v) -> teamService.addStats(v))
                        .selectKey((k, v) -> v.getMatchId() + "|" + v.getTeamId());


        KStream<String, PayloadDTO> statsByTeam =
                playerPosition
                        .selectKey((k, v) -> {
                            return v.isEmpty() ? "unknown" : String.valueOf(v.getFirst().getMatchId());
                        })
                        .mapValues((k, v) -> getStatsTeam(v));

        KStream<String, PayloadDTO> healthByTeam =
                playerHealth
                        .selectKey((k, v) ->  {
                            return v.isEmpty() ? "unknown" : String.valueOf(v.getFirst().getMatchId());
                        })
                        .mapValues((k, v ) -> getTeamHealthStats(v));


        statsByTeam.to("stats-team-live", Produced.with(Serdes.String(), payloadSerde()));
        healthByTeam.to("health-team-live", Produced.with(Serdes.String(), payloadSerde()));

        return matchByPlayer;
    }

    private Serde<PayloadDTO> payloadSerde() {

        Serializer<PayloadDTO> serializer = (key, data) -> {
            try {
                return objectMapper.writeValueAsBytes(data);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        };

        Deserializer<PayloadDTO> deserializer = (key, data) -> {
            try {
                return objectMapper.readValue(data, PayloadDTO.class);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        };

        return Serdes.serdeFrom(serializer, deserializer);
    }



    private PayloadDTO getStatsTeam(List<PlayerPositionDTO> positions) {
        teamService.addDistanceCoveredAndTouches(positions);
        var statsByTeam = positions.stream().collect(Collectors.groupingBy(p -> new TeamKey(p.getMatchId(), p.getTeamId())));
        List<StatsDTO> stats = new ArrayList<>();
        statsByTeam.forEach((k,v) -> {
            stats.add(teamService.getTeamStats(k));
        });
        //List<StatsDTO> stats =  positions.stream().map(p -> teamService.getTeamStats(new TeamKey(p.getMatchId(), p.getTeamId()))).toList();
        //log.debug("Taille de la liste : {}",stats.size());
        //log.debug("Liste : {}",stats.toString());
        return new PayloadDTO(stats);
    }

    private PayloadDTO getTeamHealthStats(List<PlayerHealthDTO> healths){
        var healthByTeam = healths.stream().collect(Collectors.groupingBy(p -> new TeamKey(p.getMatchId(), p.getTeamId())));
        List<TeamHealthStatsDTO> statsHealths = new ArrayList<>();
        healthByTeam.forEach((k,v) -> {
            teamService.updateTeamHealth(v);
            statsHealths.add(teamService.getTeamHealthStats(k));
        });
        return new PayloadDTO(statsHealths);
    }

}
