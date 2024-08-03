package be.kdg.prog6.parkgate.ports.in;

import java.util.UUID;

public interface ExitParkUseCase {
    void exitPark(UUID ticketUUID);
}
