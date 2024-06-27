package be.kdg.prog6.events;

import java.util.UUID;

public record PointOfInterestOpenStatusChangedEvent(UUID POIUuid, boolean open) {
}
