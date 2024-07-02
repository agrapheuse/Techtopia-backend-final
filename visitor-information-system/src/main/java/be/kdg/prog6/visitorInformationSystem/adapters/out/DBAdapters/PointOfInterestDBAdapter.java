package be.kdg.prog6.visitorInformationSystem.adapters.out.DBAdapters;

import be.kdg.prog6.visitorInformationSystem.adapters.out.JPAEntities.AttractionJpaEntity;
import be.kdg.prog6.visitorInformationSystem.adapters.out.JPAEntities.FoodStandJpaEntity;
import be.kdg.prog6.visitorInformationSystem.adapters.out.repositories.AttractionJpaRepository;
import be.kdg.prog6.visitorInformationSystem.adapters.out.repositories.FoodStandJpaRepository;
import be.kdg.prog6.visitorInformationSystem.domain.Attraction;
import be.kdg.prog6.visitorInformationSystem.domain.FoodStand;
import be.kdg.prog6.visitorInformationSystem.domain.PointOfInterest;
import be.kdg.prog6.visitorInformationSystem.ports.out.POILoadPort;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class PointOfInterestDBAdapter implements POILoadPort {
    private final AttractionJpaRepository attractionJpaRepository;
    private final FoodStandJpaRepository foodStandJpaRepository;
    public static final Logger log = LoggerFactory.getLogger(PointOfInterestDBAdapter.class);

    public PointOfInterestDBAdapter(AttractionJpaRepository attractionJpaRepository, FoodStandJpaRepository foodStandJpaRepository) {
        this.attractionJpaRepository = attractionJpaRepository;
        this.foodStandJpaRepository = foodStandJpaRepository;
    }

    @Override
    public List<PointOfInterest> loadPointsOfInterest() {
        List<AttractionJpaEntity> attractionsJpa = attractionJpaRepository.findAll();
        List<FoodStandJpaEntity> foodStandsJpa = foodStandJpaRepository.findAll();

        List<Attraction> attractions = AttractionDBAdapter.convert(attractionsJpa);
        List<FoodStand> foodStands = FoodStandDBAdapter.convert(foodStandsJpa);

        List<PointOfInterest> pointOfInterests = new ArrayList<>(attractions);
        pointOfInterests.addAll(foodStands);
        return pointOfInterests;
    }

    @Override
    public List<PointOfInterest> loadFilteredPointsOfInterest(Optional<String> name, Optional<Boolean> open) {
        List<AttractionJpaEntity> attractionsJpa;
        List<FoodStandJpaEntity> foodStandJpa;
        if (name.isPresent() && open.isPresent()) {
            attractionsJpa = attractionJpaRepository.findByNameContainsIgnoreCaseAndOpenEquals(name.get(), open.get());
            foodStandJpa = foodStandJpaRepository.findByNameContainsIgnoreCaseAndOpenEquals(name.get(), open.get());
        } else if (name.isPresent()) {
            attractionsJpa = attractionJpaRepository.findByNameContainsIgnoreCase(name.get());
            foodStandJpa = foodStandJpaRepository.findByNameContainsIgnoreCase(name.get());
        } else if (open.isPresent()) {
            attractionsJpa = attractionJpaRepository.findByOpenEquals(open.get());
            foodStandJpa = foodStandJpaRepository.findByOpenEquals(open.get());
        } else {
            attractionsJpa = attractionJpaRepository.findAll();
            foodStandJpa = foodStandJpaRepository.findAll();
        }
        List<Attraction> attractions = AttractionDBAdapter.convert(attractionsJpa);
        List<FoodStand> foodStands = FoodStandDBAdapter.convert(foodStandJpa);

        List<PointOfInterest> pointOfInterests = new ArrayList<>(attractions);
        pointOfInterests.addAll(foodStands);
        return pointOfInterests;
    }
}
