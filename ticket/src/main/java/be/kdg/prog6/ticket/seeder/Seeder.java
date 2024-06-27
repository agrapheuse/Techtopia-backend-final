package be.kdg.prog6.ticket.seeder;

import be.kdg.prog6.ticket.adapters.out.JPAEntities.PersonJpaEntity;
import be.kdg.prog6.ticket.adapters.out.JPAEntities.TicketJpaEntity;
import be.kdg.prog6.ticket.adapters.out.repositories.PersonJpaRepository;
import be.kdg.prog6.ticket.adapters.out.repositories.TicketJpaRepository;
import be.kdg.prog6.ticket.domain.Person;
import be.kdg.prog6.ticket.domain.TicketAgeType;
import be.kdg.prog6.ticket.domain.TicketOption;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.UUID;

@Component
public class Seeder implements ApplicationRunner {
    private final PersonJpaRepository personJpaRepository;
    private final TicketJpaRepository ticketJpaRepository;

    public Seeder(PersonJpaRepository personJpaRepository, TicketJpaRepository ticketJpaRepository) {
        this.personJpaRepository = personJpaRepository;
        this.ticketJpaRepository = ticketJpaRepository;
    }

    void createData() {
        PersonJpaEntity janeDoe = new PersonJpaEntity(
                UUID.fromString("5c7074af-0c1e-47a3-aae9-f076588caf27"),
                "Jane Doe",
                Person.Sex.MME,
                22
        );

        PersonJpaEntity johnDoe = new PersonJpaEntity(
                UUID.fromString("039f0c23-dca3-4cd9-8b08-8e894cc25d86"),
                "John Doe",
                Person.Sex.M,
                24
        );

        personJpaRepository.save(janeDoe);
        personJpaRepository.save(johnDoe);

        TicketJpaEntity ticket1 = new TicketJpaEntity(
                UUID.randomUUID(),
                LocalDate.now(),
                janeDoe,
                TicketOption.NORMAL,
                TicketAgeType.ADULT,
                "jane.doe@gmail.com"
        );

        TicketJpaEntity ticket2 = new TicketJpaEntity(
                UUID.randomUUID(),
                LocalDate.now(),
                johnDoe,
                TicketOption.NORMAL,
                TicketAgeType.ADULT,
                "jane.doe@gmail.com"
        );

        ticketJpaRepository.save(ticket1);
        ticketJpaRepository.save(ticket2);
    }

    @Override
    public void run(ApplicationArguments args) {
        createData();
    }
}
