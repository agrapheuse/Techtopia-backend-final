package be.kdg.prog6.parkplanning.ports.in;

import java.util.UUID;

public interface ChangePOIOpenStatusUseCase {
    void changeOpenStatus(UUID uuid, boolean open);
}
