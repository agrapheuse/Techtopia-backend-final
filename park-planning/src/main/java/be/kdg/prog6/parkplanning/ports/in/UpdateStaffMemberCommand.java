package be.kdg.prog6.parkplanning.ports.in;

import java.util.List;
import java.util.UUID;

public record UpdateStaffMemberCommand(UUID poiUuid, List<UUID> staffMemberUuids) {
}
