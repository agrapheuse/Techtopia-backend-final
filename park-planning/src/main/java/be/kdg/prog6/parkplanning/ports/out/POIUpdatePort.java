package be.kdg.prog6.parkplanning.ports.out;

import be.kdg.prog6.parkplanning.domain.PointOfInterest;

public interface POIUpdatePort {
    void updatePOI(PointOfInterest pointOfInterest);
}
