package be.kdg.prog6.visitorInformationSystem.seeder;

import be.kdg.prog6.visitorInformationSystem.adapters.out.JPAEntities.AttractionJpaEntity;
import be.kdg.prog6.visitorInformationSystem.adapters.out.JPAEntities.FoodStandJpaEntity;
import be.kdg.prog6.visitorInformationSystem.adapters.out.repositories.AttractionJpaRepository;
import be.kdg.prog6.visitorInformationSystem.adapters.out.repositories.FoodStandJpaRepository;
import be.kdg.prog6.visitorInformationSystem.domain.Attraction;
import be.kdg.prog6.visitorInformationSystem.domain.FoodStand;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class Seeder implements ApplicationRunner {
    private final AttractionJpaRepository attractionJpaEntityRepository;
    private final FoodStandJpaRepository foodStandJpaRepository;

    public Seeder(AttractionJpaRepository attractionJpaEntityRepository, FoodStandJpaRepository foodStandJpaRepository) {
        this.attractionJpaEntityRepository = attractionJpaEntityRepository;
        this.foodStandJpaRepository = foodStandJpaRepository;
    }

    void createData() {
        AttractionJpaEntity flyingDutchman = new AttractionJpaEntity(new Attraction(
                new Attraction.AttractionUUID(UUID.fromString("f0b71052-b917-48da-8825-e4933a30bc9e")),
                "flying dutchman",
                "De Vliegende Hollander is a combination water coaster and dark ride. The ride is based on the legend of Dutch man of war, the Flying Dutchman.",
                40,
                15,
                "images/flying_dutchman.jpg",
                true,
                12
        )
        );
        AttractionJpaEntity birdRoc = new AttractionJpaEntity(new Attraction(
                new Attraction.AttractionUUID(UUID.fromString("8ec53056-e427-497a-9a24-af55d0a84898")),
                "bird roc",
                "The name of the ride, Vogel Rok, refers to the adventure of Sinbad and the Bird Roc from the 1001 Arabian Nights.  The building has as a frontage a giant colorful Roc, the largest bird in Europe, according to the Guinness Book of Records. ",
                28,
                64,
                "/images/bird_roc.jpg",
                true,
                12
        )
        );
        AttractionJpaEntity fataMorgana = new AttractionJpaEntity(new Attraction(
                new Attraction.AttractionUUID(UUID.fromString("6896e678-5184-4652-95cd-8b4f35f9a3ce")),
                "fata morgana",
                "Fata Morgana is a dark ride. The ride is located in the Arabian themed area of the park, Adventure Realm.",
                65,
                12,
                "/images/fata_morgana.jpg",
                true,
                8
        )
        );

        attractionJpaEntityRepository.save(flyingDutchman);
        attractionJpaEntityRepository.save(birdRoc);
        attractionJpaEntityRepository.save(fataMorgana);

        FoodStandJpaEntity hotDogStand = new FoodStandJpaEntity(new FoodStand(
                new FoodStand.FoodStandUuid(UUID.fromString("149e17ef-4233-4b69-9e70-7d68f88ecb6b")),
                "hot dog stand",
                "The hot dog stand is a place where you can buy hot dogs.",
                10,
                5,
                "/images/hot_dog_stand.jpg",
                true,
                """
                        hot dog: 3$\s
                        fries: 3$\s
                        soda: 1$\s"""
        )
        );

        FoodStandJpaEntity pizzaStand = new FoodStandJpaEntity(new FoodStand(
                new FoodStand.FoodStandUuid(UUID.fromString("5bf98931-b38e-450d-a463-1fb3e5793913")),
                "pizza stand",
                "The pizza stand is a place where you can buy pizza.",
                10,
                5,
                "/images/pizza_stand.jpg",
                true,
                """
                        pizza: 5$\s
                        fries: 3$\s
                        soda: 1$\s"""
        )
        );

        FoodStandJpaEntity iceCreamStand = new FoodStandJpaEntity(new FoodStand(
                new FoodStand.FoodStandUuid(UUID.fromString("8349eb6e-f9b7-4299-8907-31e2ea6340b6")),
                "ice cream stand",
                "The ice cream stand is a place where you can buy ice cream.",
                10,
                5,
                "/images/ice_cream_stand.jpg",
                true,
                """
                        ice cream: 3$\s
                        fries: 3$\s
                        soda: 1$\s"""
        )
        );

        foodStandJpaRepository.save(hotDogStand);
        foodStandJpaRepository.save(pizzaStand);
        foodStandJpaRepository.save(iceCreamStand);
    }

    @Override
    public void run(ApplicationArguments args) {
        createData();
    }
}
