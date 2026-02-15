package club.manager.entrance_cockpit.messaging.websocket;

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


@Component
@RequiredArgsConstructor
@Slf4j
public class WebSocketEventListener {

    @EventListener
    public void handleSubscribe(SessionSubscribeEvent event) {
        StompHeaderAccessor accessor = StompHeaderAccessor.wrap(event.getMessage());
        String sessionId = accessor.getSessionId();
        String destination = accessor.getDestination();
        log.debug("Sub to topic : {}", destination);
    }
}
