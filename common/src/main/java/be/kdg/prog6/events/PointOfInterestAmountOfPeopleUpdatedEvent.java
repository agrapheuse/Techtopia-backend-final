package be.kdg.prog6.events;

import java.util.UUID;

public record PointOfInterestAmountOfPeopleUpdatedEvent(UUID poiUUID, int amountOfPeople) {
}
