package be.kdg.prog6.parkplanning;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
@EnableFeignClients
public class ParkPlanningApplication {

    public static void main(String[] args) {
        SpringApplication.run(ParkPlanningApplication.class, args);
    }

}
