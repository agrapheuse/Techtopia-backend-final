package be.kdg.prog6.visitorInformationSystem.ports.out;

import be.kdg.prog6.visitorInformationSystem.domain.PointOfInterest;

import java.util.UUID;

public interface POIProjectionPort {
    void updatePOI(UUID POIUuid, boolean open);
}
