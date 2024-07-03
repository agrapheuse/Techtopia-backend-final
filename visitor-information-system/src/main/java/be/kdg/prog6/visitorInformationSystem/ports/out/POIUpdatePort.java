package be.kdg.prog6.visitorInformationSystem.ports.out;

import be.kdg.prog6.visitorInformationSystem.domain.PointOfInterest;

public interface POIUpdatePort {
    void updatePOI(PointOfInterest pointOfInterest);
}
