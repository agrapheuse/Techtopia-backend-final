package be.kdg.prog6.visitorInformationSystem.PointOfInterest.Attraction;

import java.util.List;
import java.util.Optional;

public interface AttractionLoadPort {
    List<Attraction> loadAllAttractions();
    List<Attraction> loadFilteredAttractions(Optional<String> name, Optional<Boolean> open);
}
