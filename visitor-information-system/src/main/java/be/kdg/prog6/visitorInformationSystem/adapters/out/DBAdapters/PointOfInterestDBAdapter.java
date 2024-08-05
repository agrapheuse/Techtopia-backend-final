package be.kdg.prog6.visitorInformationSystem.adapters.out.DBAdapters;

import be.kdg.prog6.visitorInformationSystem.adapters.out.JPAEntities.AttractionJpaEntity;
import be.kdg.prog6.visitorInformationSystem.adapters.out.JPAEntities.FoodStandJpaEntity;
import be.kdg.prog6.visitorInformationSystem.adapters.out.repositories.AttractionJpaRepository;
import be.kdg.prog6.visitorInformationSystem.adapters.out.repositories.FoodStandJpaRepository;
import be.kdg.prog6.visitorInformationSystem.domain.Attraction;
import be.kdg.prog6.visitorInformationSystem.domain.FoodStand;
import be.kdg.prog6.visitorInformationSystem.domain.PointOfInterest;
import be.kdg.prog6.visitorInformationSystem.exceptions.PointOfInterestNotFoundException;
import be.kdg.prog6.visitorInformationSystem.ports.out.POILoadPort;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public class PointOfInterestDBAdapter implements POILoadPort {
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
        log.debug("load all pois called in db adapter");
        List<AttractionJpaEntity> attractionsJpa = attractionJpaRepository.findAll();
        List<FoodStandJpaEntity> foodStandsJpa = foodStandJpaRepository.findAll();
        return convert(attractionsJpa, foodStandsJpa);
    }

    @Override
    public List<PointOfInterest> loadFilteredPointsOfInterest(String name, Boolean open) {
        log.debug("load all pois with name {} and open status {} called in db adapter", name, open);
        List<AttractionJpaEntity> attractionsJpa = attractionJpaRepository.findByNameContainsIgnoreCaseAndOpenEquals(name, open);
        List<FoodStandJpaEntity> foodStandsJpa = foodStandJpaRepository.findByNameContainsIgnoreCaseAndOpenEquals(name, open);
        if (attractionsJpa.isEmpty() && foodStandsJpa.isEmpty()) {
            throw new PointOfInterestNotFoundException();
        } else {
            return convert(attractionsJpa, foodStandsJpa);
        }
    }

    @Override
    public PointOfInterest loadPointOfInterest(UUID uuid) {
        log.debug("load poi {} called in db adapter", uuid);
        Optional<AttractionJpaEntity> attractionJpa = attractionJpaRepository.findById(uuid);
        Optional<FoodStandJpaEntity> foodStandJpa = foodStandJpaRepository.findById(uuid);

        if (attractionJpa.isEmpty() && foodStandJpa.isEmpty()) {
            throw new PointOfInterestNotFoundException();
        } else if (attractionJpa.isPresent()) {
            return new Attraction(
                    new PointOfInterest.PointOfInterestUUID(attractionJpa.get().getUuid()),
                    attractionJpa.get().getName(),
                    attractionJpa.get().getDescription(),
                    attractionJpa.get().getPosX(),
                    attractionJpa.get().getPosY(),
                    attractionJpa.get().getPicturePath(),
                    attractionJpa.get().isOpen(),
                    attractionJpa.get().getMinHeight()
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
}
