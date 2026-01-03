package club.manager.entrance_cockpit.messaging.consumer;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class FrontDataConsumer {

    @KafkaListener(topics = "front-data", groupId = "entrance-cockpit")
    public void consume(String message) {
        log.debug("Received message: {}", message);
    }
}
