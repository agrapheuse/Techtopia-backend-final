package be.kdg.prog6.parkplanning.ports.out;

import java.util.UUID;

public interface POIOpenedStatusChangedPort {
    void changeOpenStatus(UUID uuid, boolean open);
}
