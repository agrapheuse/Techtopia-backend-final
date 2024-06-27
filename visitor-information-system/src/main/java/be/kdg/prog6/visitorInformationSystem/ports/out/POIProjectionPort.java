package be.kdg.prog6.visitorInformationSystem.ports.out;

import java.util.UUID;

public interface POIProjectionPort {
    void updatePOI(UUID POIUuid, boolean open);
}
