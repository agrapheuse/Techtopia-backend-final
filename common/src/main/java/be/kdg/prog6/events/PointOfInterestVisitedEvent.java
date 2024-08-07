package be.kdg.prog6.events;

import java.util.UUID;

public record PointOfInterestVisitedEvent(UUID poiUUId) implements Event {
}
