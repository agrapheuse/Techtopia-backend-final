package be.kdg.prog6.ticket.seeder;

import be.kdg.prog6.enums.Status;
import be.kdg.prog6.ticket.adapters.out.db.JPAEntities.TicketJpaEntity;
import be.kdg.prog6.ticket.adapters.out.db.repositories.TicketJpaRepository;
import be.kdg.prog6.ticket.domain.Gender;
import be.kdg.prog6.ticket.domain.TicketAgeType;
import be.kdg.prog6.ticket.domain.TicketOption;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.UUID;

@Component
public class Seeder implements ApplicationRunner {
    private final TicketJpaRepository ticketJpaRepository;
    public static final Logger log = LoggerFactory.getLogger(Seeder.class);

    public Seeder(TicketJpaRepository ticketJpaRepository) {
        this.ticketJpaRepository = ticketJpaRepository;
    }

    void createData() {
        log.debug("creating data to be sent to the db");
        TicketJpaEntity ticket1 = new TicketJpaEntity(
                UUID.fromString("f6500e86-f240-423b-8980-fb98d0f8426d"),
                LocalDate.now(),
                "John Doe",
                24,
                Gender.M,
                TicketOption.NORMAL,
                TicketAgeType.ADULT,
                "jane.doe@gmail.com",
                Status.NEW
        );

        ticketJpaRepository.save(ticket1);
    }

    @Override
    public void run(ApplicationArguments args) {
        createData();
    }
}
