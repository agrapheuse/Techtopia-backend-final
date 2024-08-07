package be.kdg.prog6.visitorInformationSystem.ports.in;

import java.util.UUID;

public record UpdateQueueTimeCommand(UUID poiUUId, int queueTime) {
}
