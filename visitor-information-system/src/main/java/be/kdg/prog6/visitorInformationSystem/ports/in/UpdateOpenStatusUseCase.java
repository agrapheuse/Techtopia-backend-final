package be.kdg.prog6.visitorInformationSystem.ports.in;

import be.kdg.prog6.events.PointOfInterestOpenStatusChangedEvent;

import java.util.UUID;

public interface UpdateOpenStatusUseCase {
    void updateOpenStatus(PointOfInterestOpenStatusChangedEvent pointOfInterestOpenStatusChangedEvent);
}
