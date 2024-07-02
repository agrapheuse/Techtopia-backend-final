package be.kdg.prog6.parkgate.seeder;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class Seeder implements ApplicationRunner {
    public static final Logger log = LoggerFactory.getLogger(Seeder.class);

    public Seeder() {
        log.debug("Seeder started");
    }

    void createData() {

    }

    @Override
    public void run(ApplicationArguments args) {
        createData();
    }
}
