package be.kdg.prog6.parkgate.seeder;

import be.kdg.prog6.parkgate.adapters.out.db.JPAEntities.TicketJpaEntity;
import be.kdg.prog6.parkgate.adapters.out.db.repositories.TicketJpaRepository;
import be.kdg.prog6.parkgate.domain.Status;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class Seeder implements ApplicationRunner {
    public static final Logger log = LoggerFactory.getLogger(Seeder.class);
    private final TicketJpaRepository ticketJpaRepository;

    public Seeder(TicketJpaRepository ticketJpaRepository) {
        this.ticketJpaRepository = ticketJpaRepository;
        log.debug("Seeder started");
    }

    void createData() {
        TicketJpaEntity ticket = new TicketJpaEntity(
                UUID.fromString("f6500e86-f240-423b-8980-fb98d0f8426d"),
                Status.NEW
        );

        ticketJpaRepository.save(ticket);
    }

    @Override
    public void run(ApplicationArguments args) {
        createData();
    }
}
