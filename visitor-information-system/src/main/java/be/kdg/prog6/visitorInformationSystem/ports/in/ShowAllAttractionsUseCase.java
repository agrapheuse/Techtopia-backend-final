package be.kdg.prog6.visitorInformationSystem.ports.in;

import be.kdg.prog6.visitorInformationSystem.domain.Attraction;

import java.util.List;

public interface ShowAllAttractionsUseCase {
    List<Attraction> showAllAttractions();
}
