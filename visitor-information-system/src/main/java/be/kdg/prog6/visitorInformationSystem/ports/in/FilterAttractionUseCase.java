package be.kdg.prog6.visitorInformationSystem.ports.in;

import be.kdg.prog6.visitorInformationSystem.domain.Attraction;

import java.util.List;
import java.util.Optional;

public interface FilterAttractionUseCase {
    List<Attraction> filterAttractions(Optional<String> name, Optional<Boolean> open);
}
