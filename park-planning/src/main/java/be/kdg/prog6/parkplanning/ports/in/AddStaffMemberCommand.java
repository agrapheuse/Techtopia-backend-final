package be.kdg.prog6.parkplanning.ports.in;

import java.util.UUID;

public record AddStaffMemberCommand(UUID poiUuid, UUID staffMemberUuid) {
}
