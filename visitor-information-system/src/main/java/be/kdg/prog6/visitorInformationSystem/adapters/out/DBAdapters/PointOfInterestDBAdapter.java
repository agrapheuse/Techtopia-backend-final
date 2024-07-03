package be.kdg.prog6.visitorInformationSystem.adapters.out.DBAdapters;

import be.kdg.prog6.visitorInformationSystem.adapters.out.JPAEntities.AttractionJpaEntity;
import be.kdg.prog6.visitorInformationSystem.adapters.out.JPAEntities.FoodStandJpaEntity;
import be.kdg.prog6.visitorInformationSystem.adapters.out.repositories.AttractionJpaRepository;
import be.kdg.prog6.visitorInformationSystem.adapters.out.repositories.FoodStandJpaRepository;
import be.kdg.prog6.visitorInformationSystem.domain.Attraction;
import be.kdg.prog6.visitorInformationSystem.domain.FoodStand;
import be.kdg.prog6.visitorInformationSystem.domain.PointOfInterest;
import be.kdg.prog6.visitorInformationSystem.ports.out.POILoadPort;
import be.kdg.prog6.visitorInformationSystem.ports.out.POIUpdatePort;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public class PointOfInterestDBAdapter implements POILoadPort, POIUpdatePort {
    private final AttractionJpaRepository attractionJpaRepository;
    private final FoodStandJpaRepository foodStandJpaRepository;
    public static final Logger log = LoggerFactory.getLogger(PointOfInterestDBAdapter.class);

    public PointOfInterestDBAdapter(AttractionJpaRepository attractionJpaRepository, FoodStandJpaRepository foodStandJpaRepository) {
        this.attractionJpaRepository = attractionJpaRepository;
        this.foodStandJpaRepository = foodStandJpaRepository;
    }

    private List<PointOfInterest> convert(List<AttractionJpaEntity> attractionsJpa, List<FoodStandJpaEntity> foodStandsJpa) {
        List<Attraction> attractions = AttractionDBAdapter.convert(attractionsJpa);
        List<FoodStand> foodStands = FoodStandDBAdapter.convert(foodStandsJpa);

        List<PointOfInterest> pointOfInterests = new ArrayList<>(attractions);
        pointOfInterests.addAll(foodStands);
        return pointOfInterests;
    }

    @Override
    public List<PointOfInterest> loadPointsOfInterest() {
        List<AttractionJpaEntity> attractionsJpa = attractionJpaRepository.findAll();
        List<FoodStandJpaEntity> foodStandsJpa = foodStandJpaRepository.findAll();
        return convert(attractionsJpa, foodStandsJpa);
    }

    @Override
    public List<PointOfInterest> loadFilteredPointsOfInterest(String name, Boolean open) {
        List<AttractionJpaEntity> attractionsJpa = attractionJpaRepository.findByNameContainsIgnoreCaseAndOpenEquals(name, open);
        List<FoodStandJpaEntity> foodStandsJpa = foodStandJpaRepository.findByNameContainsIgnoreCaseAndOpenEquals(name, open);
        return convert(attractionsJpa, foodStandsJpa);
    }

    @Override
    public PointOfInterest loadPointOfInterest(UUID uuid) {
        Optional<AttractionJpaEntity> attractionJpa = attractionJpaRepository.findById(uuid);
        Optional<FoodStandJpaEntity> foodStandJpa = foodStandJpaRepository.findById(uuid);

        if (attractionJpa.isEmpty() && foodStandJpa.isEmpty()) {
            //TODO: add exception: PointOfInterestNotFoundException
            return null;
        } else if (attractionJpa.isPresent()) {
            return new Attraction(
                    new PointOfInterest.PointOfInterestUUID(attractionJpa.get().getUuid()),
                    attractionJpa.get().getName(),
                    attractionJpa.get().getDescription(),
                    attractionJpa.get().getPosX(),
                    attractionJpa.get().getPosY(),
                    attractionJpa.get().getPicturePath(),
                    attractionJpa.get().isOpen(),
                    attractionJpa.get().getMinAge()
            );
        } else {
            return new FoodStand(
                    new PointOfInterest.PointOfInterestUUID(foodStandJpa.get().getUuid()),
                    foodStandJpa.get().getName(),
                    foodStandJpa.get().getDescription(),
                    foodStandJpa.get().getPosX(),
                    foodStandJpa.get().getPosY(),
                    foodStandJpa.get().getPicturePath(),
                    foodStandJpa.get().isOpen(),
                    foodStandJpa.get().getMenu()
            );
        }
    }

    @Override
    public void updatePOI(PointOfInterest pointOfInterest) {
        //TODO: do the checking of class in the use case and then call Attraction/FoodStand DB Adapter instead
        if (pointOfInterest.getClass() == Attraction.class) {
            Attraction attraction = (Attraction) pointOfInterest;
            AttractionJpaEntity attractionJpa = new AttractionJpaEntity(
                    attraction.getUuid().uuid(),
                    attraction.getName(),
                    attraction.getDescription(),
                    attraction.getPosX(),
                    attraction.getPosY(),
                    attraction.getPicturePath(),
                    attraction.isOpen(),
                    attraction.getMinAge()
            );
            attractionJpaRepository.save(attractionJpa);
        } else if (pointOfInterest.getClass() == FoodStand.class) {
            FoodStand foodStand = (FoodStand) pointOfInterest;
            FoodStandJpaEntity foodStandJpa = new FoodStandJpaEntity(
                    foodStand.getUuid().uuid(),
                    foodStand.getName(),
                    foodStand.getDescription(),
                    foodStand.getPosX(),
                    foodStand.getPosY(),
                    foodStand.getPicturePath(),
                    foodStand.isOpen(),
                    foodStand.getMenu()
                    );
            foodStandJpaRepository.save(foodStandJpa);
        }
    }
}
