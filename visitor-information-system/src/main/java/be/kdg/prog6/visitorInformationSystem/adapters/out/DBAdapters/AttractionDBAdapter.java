package be.kdg.prog6.visitorInformationSystem.adapters.out.DBAdapters;

import be.kdg.prog6.visitorInformationSystem.domain.Attraction;
import be.kdg.prog6.visitorInformationSystem.domain.PointOfInterest;
import be.kdg.prog6.visitorInformationSystem.ports.out.AttractionLoadPort;
import be.kdg.prog6.visitorInformationSystem.adapters.out.JPAEntities.AttractionJpaEntity;
import be.kdg.prog6.visitorInformationSystem.adapters.out.repositories.AttractionJpaRepository;
import be.kdg.prog6.visitorInformationSystem.ports.out.AttractionUpdatePort;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class AttractionDBAdapter implements AttractionLoadPort, AttractionUpdatePort {
    private final AttractionJpaRepository attractionRepository;
    public static final Logger log = LoggerFactory.getLogger(AttractionDBAdapter.class);

    public AttractionDBAdapter(AttractionJpaRepository attractionRepository) {
        this.attractionRepository = attractionRepository;
    }

    public static List<Attraction> convert(List<AttractionJpaEntity> attractions) {
        if (attractions.isEmpty()) {
            return new ArrayList<>();
        }
        List<Attraction> result = new ArrayList<>();
        for (AttractionJpaEntity attraction : attractions) {
            result.add(new Attraction(new PointOfInterest.PointOfInterestUUID(attraction.getUuid()), attraction.getName(), attraction.getDescription(), attraction.getPosX(), attraction.getPosY(), attraction.getPicturePath(), attraction.isOpen(), attraction.getMinHeight()));
        }
        return result;
    }


    @Override
    public List<Attraction> loadAllAttractions() {
        log.debug("load all attractions called in db adapter");
        List<AttractionJpaEntity> attractions = attractionRepository.findAll();
        return convert(attractions);
    }

    @Override
    public List<Attraction> loadFilteredAttractions(String name, boolean open) {
        log.debug("load all attractions with name {} and open status {} called in db adapter", name, open);
        List<AttractionJpaEntity> attractions = attractionRepository.findByNameContainsIgnoreCaseAndOpenEquals(name, open);
        return convert(attractions);
    }

    @Override
    public void updateAttraction(Attraction attraction) {
        log.debug("update attraction {} called in db adapter", attraction.getUuid().uuid());
        AttractionJpaEntity attractionJpa = new AttractionJpaEntity(
                attraction.getUuid().uuid(),
                attraction.getName(),
                attraction.getDescription(),
                attraction.getPosX(),
                attraction.getPosY(),
                attraction.getPicturePath(),
                attraction.isOpen(),
                attraction.getMinHeight()
        );
        attractionRepository.save(attractionJpa);
    }
}
