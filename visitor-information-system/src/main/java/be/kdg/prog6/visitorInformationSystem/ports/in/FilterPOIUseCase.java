package be.kdg.prog6.visitorInformationSystem.ports.in;

import be.kdg.prog6.visitorInformationSystem.domain.PointOfInterest;

import java.util.List;
import java.util.Optional;

public interface FilterPOIUseCase {
    List<PointOfInterest> filterPointsOfInterest(Optional<String> name, Optional<Boolean> open);
}
