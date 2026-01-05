package club.manager.entrance_cockpit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class EntranceCockpitApplication {

    public static void main(String[] args) {
        SpringApplication.run(EntranceCockpitApplication.class, args);
    }

}
