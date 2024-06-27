package be.kdg.prog6.visitorInformationSystem.ports.in;

import be.kdg.prog6.events.PointOfInterestOpenStatusChangedEvent;

public interface POIOpenStatusProjector {
    void project(PointOfInterestOpenStatusChangedEvent event);
}
