package be.kdg.prog6.parkplanning.seeder;

import be.kdg.prog6.parkplanning.adapters.out.JPAEntities.POIJpaEntity;
import be.kdg.prog6.parkplanning.adapters.out.JPARepositories.POIJpaRepository;
import be.kdg.prog6.parkplanning.domain.StaffMember;
import be.kdg.prog6.parkplanning.adapters.out.JPAEntities.StaffMemberJpaEntity;
import be.kdg.prog6.parkplanning.adapters.out.JPARepositories.StaffMemberJpaRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public class Seeder implements ApplicationRunner {
    private final StaffMemberJpaRepository staffMemberJpaRepository;
    private final POIJpaRepository poiJpaRepository;
    public static final Logger log = LoggerFactory.getLogger(Seeder.class);

    public Seeder(StaffMemberJpaRepository staffMemberJpaRepository, POIJpaRepository poiJpaRepository) {
        this.staffMemberJpaRepository = staffMemberJpaRepository;
        this.poiJpaRepository = poiJpaRepository;
    }

    void createData() {
        StaffMemberJpaEntity johnDoe = new StaffMemberJpaEntity(new StaffMember(
                new StaffMember.StaffMemberUUID(UUID.randomUUID()),
                "John Doe"
        )
        );

        StaffMemberJpaEntity janeDoe = new StaffMemberJpaEntity(new StaffMember(
                new StaffMember.StaffMemberUUID(UUID.randomUUID()),
                "Jane Doe"
        )
        );

        StaffMemberJpaEntity jackSmith = new StaffMemberJpaEntity(new StaffMember(
                new StaffMember.StaffMemberUUID(UUID.randomUUID()),
                "Jack Smith"
        )
        );

        StaffMemberJpaEntity johnSmith = new StaffMemberJpaEntity(new StaffMember(
                new StaffMember.StaffMemberUUID(UUID.randomUUID()),
                "John Smith"
        )
        );

        staffMemberJpaRepository.save(johnDoe);
        staffMemberJpaRepository.save(janeDoe);
        staffMemberJpaRepository.save(jackSmith);
        staffMemberJpaRepository.save(johnSmith);

        POIJpaEntity flyingDutchman = new POIJpaEntity(
                UUID.fromString("f0b71052-b917-48da-8825-e4933a30bc9e"),
                List.of(johnDoe),
                true
        );

        POIJpaEntity hotDogStand = new POIJpaEntity(
                UUID.fromString("149e17ef-4233-4b69-9e70-7d68f88ecb6b"),
                List.of(jackSmith),
                false
        );

        poiJpaRepository.save(flyingDutchman);
        poiJpaRepository.save(hotDogStand);
    }

    @Override
    public void run(ApplicationArguments args) {
        createData();
    }
}
