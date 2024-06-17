package be.kdg.prog6.parkgate.seeder;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public class Seeder implements ApplicationRunner {
    public Seeder() {
    }

    void createData() {

    }

    @Override
    public void run(ApplicationArguments args) {
        createData();
    }
}
