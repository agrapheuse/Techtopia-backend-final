package be.kdg.prog6.ticket.adapters.out.DBAdapters;

import be.kdg.prog6.ticket.adapters.out.JPAEntities.PersonJpaEntity;
import be.kdg.prog6.ticket.adapters.out.repositories.PersonJpaRepository;
import be.kdg.prog6.ticket.domain.Person;
import be.kdg.prog6.ticket.ports.out.PersonLoadPort;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public class PersonDBAdapter implements PersonLoadPort {
    private final PersonJpaRepository personJpaRepository;
    public static final Logger log = LoggerFactory.getLogger(PersonDBAdapter.class);

    public PersonDBAdapter(PersonJpaRepository personJpaRepository) {
        this.personJpaRepository = personJpaRepository;
    }

    @Override
    public Optional<Person> loadPerson(UUID uuid) {
        Optional<PersonJpaEntity> personJpaEntity = personJpaRepository.findById(uuid);
        return personJpaEntity.map(jpaEntity -> new Person(
                new Person.PersonUUID(jpaEntity.getUuid()),
                jpaEntity.getName(),
                jpaEntity.getSex(),
                jpaEntity.getAge()));
    }
}
