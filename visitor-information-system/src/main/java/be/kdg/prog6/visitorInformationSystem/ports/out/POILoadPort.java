package be.kdg.prog6.visitorInformationSystem.ports.out;

import be.kdg.prog6.visitorInformationSystem.domain.PointOfInterest;

import java.util.List;

public interface POILoadPort {
    List<PointOfInterest> loadPointsOfInterest();
    List<PointOfInterest> loadFilteredPointsOfInterest(String name, Boolean open);
}
