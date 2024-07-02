package be.kdg.prog6.visitorInformationSystem.ports.in;

import be.kdg.prog6.visitorInformationSystem.domain.PointOfInterest;

import java.util.List;

public interface ShowAllPOIUseCase {
    List<PointOfInterest> showAllPointOfInterests();
}
