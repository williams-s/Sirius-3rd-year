package club.manager.entrance_cockpit.messaging.websocket;

import club.manager.common_library.dto.MatchResponseDto;
import club.manager.entrance_cockpit.messaging.bridge.BallEventBridge;
import club.manager.entrance_cockpit.messaging.bridge.MatchStateBridge;
import club.manager.entrance_cockpit.messaging.bridge.PlayersPositionsBridge;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.messaging.SessionSubscribeEvent;

import java.time.LocalDateTime;
import java.util.List;

@Component
@RequiredArgsConstructor
@Slf4j
public class WebSocketEventListener {

    private final WebSocketService webSocketService;
    //private final MatchService matchService;
    private final PlayersPositionsBridge playersPositionsBridge;
    private final MatchStateBridge matchStateBridge;
    private final BallEventBridge ballEventBridge;
    private final SimpMessagingTemplate messagingTemplate;

    @EventListener
    public void handleSubscribe(SessionSubscribeEvent event) {
        StompHeaderAccessor accessor = StompHeaderAccessor.wrap(event.getMessage());
        String sessionId = accessor.getSessionId();
        String destination = accessor.getDestination();
        log.debug("Sub to topic : {}", destination);
    }

    private List<MatchResponseDto> randomMatches() {
        List<MatchResponseDto> matches = List.of(

                MatchResponseDto.builder()
                        .idMatch(1L)
                        .homeTeam("Paris SG")
                        .awayTeam("Olympique Marseille")
                        .homeScore((short) 2)
                        .awayScore((short) 1)
                        .date(LocalDateTime.now().minusMinutes(15))
                        .status(club.manager.common_library.enums.MatchStatusEnum.LIVE)
                        .competition("Ligue 1")
                        .build(),

                MatchResponseDto.builder()
                        .idMatch(2L)
                        .homeTeam("Real Madrid")
                        .awayTeam("FC Barcelona")
                        .homeScore((short) 3)
                        .awayScore((short) 2)
                        .date(LocalDateTime.now().minusHours(2))
                        .status(club.manager.common_library.enums.MatchStatusEnum.FINISHED)
                        .competition("La Liga")
                        .build(),

                MatchResponseDto.builder()
                        .idMatch(3L)
                        .homeTeam("Manchester City")
                        .awayTeam("Liverpool")
                        .homeScore((short) 1)
                        .awayScore((short) 1)
                        .date(LocalDateTime.now().minusMinutes(5))
                        .status(club.manager.common_library.enums.MatchStatusEnum.LIVE)
                        .competition("Premier League")
                        .build(),

                MatchResponseDto.builder()
                        .idMatch(4L)
                        .homeTeam("Bayern Munich")
                        .awayTeam("Borussia Dortmund")
                        .homeScore((short) 4)
                        .awayScore((short) 0)
                        .date(LocalDateTime.now().minusDays(1))
                        .status(club.manager.common_library.enums.MatchStatusEnum.FINISHED)
                        .competition("Champions League")
                        .build(),

                MatchResponseDto.builder()
                        .idMatch(5L)
                        .homeTeam("Juventus")
                        .awayTeam("AC Milan")
                        .homeScore((short) 0)
                        .awayScore((short) 0)
                        .date(LocalDateTime.now().plusHours(1))
                        .status(club.manager.common_library.enums.MatchStatusEnum.FINISHED)
                        .competition("Europa League")
                        .build()
        );

        return matches;
    }
}
