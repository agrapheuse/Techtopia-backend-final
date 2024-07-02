package be.kdg.prog6.parkplanning.ports.out;

import java.util.UUID;

public interface POIOpenedStatusChangedPort {
    void openStatusChanged(UUID uuid, boolean open);
}
