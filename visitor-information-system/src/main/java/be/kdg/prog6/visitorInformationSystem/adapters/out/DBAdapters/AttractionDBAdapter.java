package be.kdg.prog6.visitorInformationSystem.adapters.out.DBAdapters;

import be.kdg.prog6.visitorInformationSystem.domain.Attraction;
import be.kdg.prog6.visitorInformationSystem.ports.out.AttractionLoadPort;
import be.kdg.prog6.visitorInformationSystem.adapters.out.JPAEntities.AttractionJpaEntity;
import be.kdg.prog6.visitorInformationSystem.adapters.out.repositories.AttractionJpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class AttractionDBAdapter implements AttractionLoadPort {
    private final AttractionJpaRepository attractionRepository;

    public AttractionDBAdapter(AttractionJpaRepository attractionRepository) {
        this.attractionRepository = attractionRepository;
    }

    private List<Attraction> convert(List<AttractionJpaEntity> attractions) {
        if (attractions.isEmpty()) {
            return new ArrayList<>();
        }
        List<Attraction> result = new ArrayList<>();
        for (AttractionJpaEntity attraction : attractions) {
            result.add(new Attraction(new Attraction.AttractionUUID(attraction.getUuid()), attraction.getName(), attraction.getDescription(), attraction.getPositionX(), attraction.getPositionY(), attraction.getPicture(), attraction.isOpen(), attraction.getMinAge()));
        }
        return result;
    }


    @Override
    public List<Attraction> loadAllAttractions() {
        List<AttractionJpaEntity> attractions = attractionRepository.findAll();
        return convert(attractions);
    }

    @Override
    public List<Attraction> loadFilteredAttractions(Optional<String> name, Optional<Boolean> open) {
        List<AttractionJpaEntity> attractions;
        if (name.isPresent() && open.isPresent()) {
            attractions = attractionRepository.findByNameContainsIgnoreCaseAndOpenEquals(name.get(), open.get());
        } else if (name.isPresent()) {
            attractions = attractionRepository.findByNameContainsIgnoreCase(name.get());
        } else if (open.isPresent()) {
            attractions = attractionRepository.findByOpenEquals(open.get());
        } else {
            attractions = attractionRepository.findAll();
        }
        return convert(attractions);
    }
}
