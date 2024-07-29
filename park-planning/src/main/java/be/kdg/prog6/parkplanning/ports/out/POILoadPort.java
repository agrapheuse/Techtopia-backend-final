package be.kdg.prog6.parkplanning.ports.out;

import be.kdg.prog6.parkplanning.domain.PointOfInterest;

import java.util.UUID;

public interface POILoadPort {
    PointOfInterest loadPointOfInterest(UUID uuid);
}
