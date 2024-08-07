package be.kdg.prog6.parkplanning.ports.in;

import java.util.UUID;

public interface AddPersonToQueueUseCase {
    void addPersonToUUID(UUID poiUUID);
}
