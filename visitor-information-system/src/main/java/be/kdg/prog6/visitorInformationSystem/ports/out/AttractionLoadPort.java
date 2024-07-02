package be.kdg.prog6.visitorInformationSystem.ports.out;

import be.kdg.prog6.visitorInformationSystem.domain.Attraction;

import java.util.List;

public interface AttractionLoadPort {
    List<Attraction> loadAllAttractions();
    List<Attraction> loadFilteredAttractions(String name, boolean open);
}
