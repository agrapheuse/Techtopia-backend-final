package be.kdg.prog6.visitorInformationSystem.PointOfInterest.Attraction.showFiltered;

import be.kdg.prog6.visitorInformationSystem.PointOfInterest.Attraction.Attraction;

import java.util.List;
import java.util.Optional;

public interface FilterAttractionUseCase {
    List<Attraction> filterAttractions(Optional<String> name, Optional<Boolean> open);
}
