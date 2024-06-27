package be.kdg.prog6.parkplanning.PointOfInterest.updateOpenStatus.ports;

import java.util.UUID;

public interface ChangePOIOpenStatusUseCase {
    void changeOpenStatus(UUID uuid, boolean open);
}
