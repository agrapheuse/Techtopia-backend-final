package be.kdg.prog6.visitorInformationSystem.ports.out;

import be.kdg.prog6.visitorInformationSystem.domain.PointOfInterest;

import java.util.List;
import java.util.Optional;

public interface POILoadPort {
    List<PointOfInterest> loadPointsOfInterest();
    List<PointOfInterest> loadFilteredPointsOfInterest(Optional<String> name, Optional<Boolean> open);
}
