package be.kdg.prog6.parkplanning.PointOfInterest.updateOpenStatus.ports;

import java.util.UUID;

public interface POIOpenedStatusChangedPort {
    void changeOpenStatus(UUID uuid, boolean open);
}
