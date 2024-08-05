package be.kdg.prog6.parkplanning.seeder;

import be.kdg.prog6.parkplanning.adapters.out.db.JPAEntities.POIJpaEntity;
import be.kdg.prog6.parkplanning.adapters.out.db.JPARepositories.POIJpaRepository;
import be.kdg.prog6.parkplanning.adapters.out.db.JPAEntities.StaffMemberJpaEntity;
import be.kdg.prog6.parkplanning.adapters.out.db.JPARepositories.StaffMemberJpaRepository;
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
        StaffMemberJpaEntity johnDoe = new StaffMemberJpaEntity(
                UUID.randomUUID(),
                "John Doe",
                UUID.fromString("f0b71052-b917-48da-8825-e4933a30bc9e")
        );

        StaffMemberJpaEntity janeDoe = new StaffMemberJpaEntity(
                UUID.randomUUID(),
                "Jane Doe",
                UUID.fromString("8ec53056-e427-497a-9a24-af55d0a84898")
        );

        StaffMemberJpaEntity jackSmith = new StaffMemberJpaEntity(
                UUID.randomUUID(),
                "Jack Smith",
                UUID.fromString("6896e678-5184-4652-95cd-8b4f35f9a3ce")
        );

        StaffMemberJpaEntity johnSmith = new StaffMemberJpaEntity(
                UUID.randomUUID(),
                "John Smith",
                UUID.fromString("046a3d69-a70f-49aa-aca1-e0b3e1675ce5")
        );

        StaffMemberJpaEntity jamesRobert = new StaffMemberJpaEntity(
                UUID.randomUUID(),
                "James Robert",
                UUID.fromString("dda28f97-d2b2-4923-a391-38f13e39bf2b")
        );

        StaffMemberJpaEntity emilyGrace = new StaffMemberJpaEntity(
                UUID.randomUUID(),
                "Emily Grace",
                UUID.fromString("5bf98931-b38e-450d-a463-1fb3e5793913")
        );

        StaffMemberJpaEntity michaelDavid = new StaffMemberJpaEntity(
                UUID.randomUUID(),
                "Michael David",
                UUID.fromString("149e17ef-4233-4b69-9e70-7d68f88ecb6b")
        );

        StaffMemberJpaEntity sarahBrown = new StaffMemberJpaEntity(
                UUID.randomUUID(),
                "Sarah Brown",
                UUID.fromString("8349eb6e-f9b7-4299-8907-31e2ea6340b6")
        );

        staffMemberJpaRepository.save(johnDoe);
        staffMemberJpaRepository.save(janeDoe);
        staffMemberJpaRepository.save(jackSmith);
        staffMemberJpaRepository.save(johnSmith);
        staffMemberJpaRepository.save(jamesRobert);
        staffMemberJpaRepository.save(emilyGrace);
        staffMemberJpaRepository.save(michaelDavid);
        staffMemberJpaRepository.save(sarahBrown);

        POIJpaEntity flyingDutchman = new POIJpaEntity(
                UUID.fromString("f0b71052-b917-48da-8825-e4933a30bc9e"),
                List.of(johnDoe),
                true
        );

        POIJpaEntity birdRoc = new POIJpaEntity(
                UUID.fromString("8ec53056-e427-497a-9a24-af55d0a84898"),
                List.of(janeDoe),
                true
        );

        POIJpaEntity fataMorgana = new POIJpaEntity(
                UUID.fromString("6896e678-5184-4652-95cd-8b4f35f9a3ce"),
                List.of(jackSmith),
                true
        );

        POIJpaEntity pagode = new POIJpaEntity(
                UUID.fromString("046a3d69-a70f-49aa-aca1-e0b3e1675ce5"),
                List.of(johnSmith),
                true
        );

        POIJpaEntity villaVolta = new POIJpaEntity(
                UUID.fromString("dda28f97-d2b2-4923-a391-38f13e39bf2b"),
                List.of(jamesRobert),
                true
        );

        POIJpaEntity pizzaStand = new POIJpaEntity(
                UUID.fromString("5bf98931-b38e-450d-a463-1fb3e5793913"),
                List.of(emilyGrace),
                true
        );

        POIJpaEntity hotDogStand = new POIJpaEntity(
                UUID.fromString("149e17ef-4233-4b69-9e70-7d68f88ecb6b"),
                List.of(michaelDavid),
                false
        );

        POIJpaEntity iceCreamStand = new POIJpaEntity(
                UUID.fromString("8349eb6e-f9b7-4299-8907-31e2ea6340b6"),
                List.of(sarahBrown),
                true
        );

        poiJpaRepository.save(flyingDutchman);
        poiJpaRepository.save(birdRoc);
        poiJpaRepository.save(fataMorgana);
        poiJpaRepository.save(pagode);
        poiJpaRepository.save(villaVolta);
        poiJpaRepository.save(pizzaStand);
        poiJpaRepository.save(hotDogStand);
        poiJpaRepository.save(iceCreamStand);
    }

    @Override
    public void run(ApplicationArguments args) {
        createData();
    }
}
