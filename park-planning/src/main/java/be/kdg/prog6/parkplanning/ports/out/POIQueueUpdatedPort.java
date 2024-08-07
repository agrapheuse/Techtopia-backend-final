package be.kdg.prog6.parkplanning.ports.out;

import java.util.UUID;

public interface POIQueueUpdatedPort {
    void updatePOIAmountOfPeople(UUID poiUUID, int amountOfPeople);
}
