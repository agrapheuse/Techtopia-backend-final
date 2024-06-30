package be.kdg.prog6.parkplanning.core;

import be.kdg.prog6.parkplanning.ports.in.AddStaffMemberUseCase;
import be.kdg.prog6.parkplanning.ports.out.StaffMemberAddedPort;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class DefaultAddStaffMemberUseCase implements AddStaffMemberUseCase {
    private final StaffMemberAddedPort staffMemberAddedPort;

    public DefaultAddStaffMemberUseCase(StaffMemberAddedPort staffMemberAddedPort) {
        this.staffMemberAddedPort = staffMemberAddedPort;
    }

    @Override
    public void addStaffMember(UUID poiUuid, UUID staffMemberUuid) {
        staffMemberAddedPort.addStaffMember(poiUuid, staffMemberUuid);
    }
}
