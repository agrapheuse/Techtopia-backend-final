package be.kdg.prog6.visitorInformationSystem.ports.in;

import be.kdg.prog6.events.PointOfInterestOpenedEvent;

public interface POIOpenStatusProjector {
    void project(PointOfInterestOpenedEvent event);
}
