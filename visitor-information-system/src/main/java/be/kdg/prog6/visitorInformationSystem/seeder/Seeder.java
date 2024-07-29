package be.kdg.prog6.visitorInformationSystem.seeder;

import be.kdg.prog6.visitorInformationSystem.adapters.out.JPAEntities.AttractionJpaEntity;
import be.kdg.prog6.visitorInformationSystem.adapters.out.JPAEntities.FoodStandJpaEntity;
import be.kdg.prog6.visitorInformationSystem.adapters.out.repositories.AttractionJpaRepository;
import be.kdg.prog6.visitorInformationSystem.adapters.out.repositories.FoodStandJpaRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class Seeder implements ApplicationRunner {
    private final AttractionJpaRepository attractionJpaEntityRepository;
    private final FoodStandJpaRepository foodStandJpaRepository;
    public static final Logger log = LoggerFactory.getLogger(Seeder.class);

    public Seeder(AttractionJpaRepository attractionJpaEntityRepository, FoodStandJpaRepository foodStandJpaRepository) {
        this.attractionJpaEntityRepository = attractionJpaEntityRepository;
        this.foodStandJpaRepository = foodStandJpaRepository;
    }

    void createData() {
        AttractionJpaEntity flyingDutchman = new AttractionJpaEntity(
                UUID.fromString("f0b71052-b917-48da-8825-e4933a30bc9e"),
                "De Vliegende Hollander",
                "De Vliegende Hollander is a combination water coaster and dark ride. The ride is based on the legend of Dutch man of war, the Flying Dutchman.",
                38,
                18,
                "images/flying_dutchman.jpg",
                true,
                12
        );
        AttractionJpaEntity birdRoc = new AttractionJpaEntity(
                UUID.fromString("8ec53056-e427-497a-9a24-af55d0a84898"),
                "Vogel Rok",
                "The name of the ride, Vogel Rok, refers to the adventure of Sinbad and the Bird Roc from the 1001 Arabian Nights.  The building has as a frontage a giant colorful Roc, the largest bird in Europe, according to the Guinness Book of Records. ",
                28,
                64,
                "/images/bird_roc.jpg",
                true,
                12
        );
        AttractionJpaEntity fataMorgana = new AttractionJpaEntity(
                UUID.fromString("6896e678-5184-4652-95cd-8b4f35f9a3ce"),
                "Fata Morgana",
                "Fata Morgana is a dark ride. The ride is located in the Arabian themed area of the park, Adventure Realm.",
                65,
                12,
                "/images/fata_morgana.jpg",
                true,
                8
        );
        AttractionJpaEntity pagode = new AttractionJpaEntity(
                UUID.fromString("046a3d69-a70f-49aa-aca1-e0b3e1675ce5"),
                "Pagode",
                "Catch your breath while the Thai temple rotates at  a height of 45m. You can enjoy phenomenal views over the whole of Efteling and all the surrounding greenery. Do you dare to look over the edge of this covered temple?",
                41,
                46,
                "/images/pagode.jpg",
                true,
                8
        );
        AttractionJpaEntity villaVolta = new AttractionJpaEntity(
                UUID.fromString("dda28f97-d2b2-4923-a391-38f13e39bf2b"),
                "Villa Volta",
                "Enter the spinning house…",
                45,
                78,
                "/images/villa_volta.jpg",
                true,
                8
        );

        attractionJpaEntityRepository.save(flyingDutchman);
        attractionJpaEntityRepository.save(birdRoc);
        attractionJpaEntityRepository.save(fataMorgana);
        attractionJpaEntityRepository.save(pagode);
        attractionJpaEntityRepository.save(villaVolta);

        FoodStandJpaEntity hotDogStand = new FoodStandJpaEntity(
                UUID.fromString("149e17ef-4233-4b69-9e70-7d68f88ecb6b"),
                "Hot Dog Stand",
                "The hot dog stand is a place where you can buy hot dogs.",
                50,
                26,
                "/images/hot_dog_stand.jpg",
                false,
                """
                        hot dog: 3$\s
                        fries: 3$\s
                        soda: 1$\s"""
        );

        FoodStandJpaEntity pizzaStand = new FoodStandJpaEntity(
                UUID.fromString("5bf98931-b38e-450d-a463-1fb3e5793913"),
                "Pizza Stand",
                "The pizza stand is a place where you can buy pizza.",
                35,
                23,
                "/images/pizza_stand.jpg",
                true,
                """
                        pizza: 5$\s
                        fries: 3$\s
                        soda: 1$\s"""
        );

        FoodStandJpaEntity iceCreamStand = new FoodStandJpaEntity(
                UUID.fromString("8349eb6e-f9b7-4299-8907-31e2ea6340b6"),
                "Ice Cream Stand",
                "The ice cream stand is a place where you can buy ice cream.",
                35,
                62,
                "/images/ice_cream_stand.jpg",
                true,
                """
                        ice cream: 3$\s
                        fries: 3$\s
                        soda: 1$\s"""
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
