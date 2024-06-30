package be.kdg.prog6.ticket.ports.out;

import be.kdg.prog6.ticket.domain.Person;

import java.util.Optional;
import java.util.UUID;

public interface PersonLoadPort {
    Optional<Person> loadPerson(UUID uuid);
}
