package be.kdg.prog6.visitorInformationSystem.ports.out;

import be.kdg.prog6.visitorInformationSystem.domain.Attraction;

public interface AttractionUpdatePort {
    void updateAttraction(Attraction attraction);
}
