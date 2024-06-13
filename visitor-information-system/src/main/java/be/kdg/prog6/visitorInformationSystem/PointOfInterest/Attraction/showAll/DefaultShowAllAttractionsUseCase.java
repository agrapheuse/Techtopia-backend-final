package be.kdg.prog6.visitorInformationSystem.PointOfInterest.Attraction.showAll;

import be.kdg.prog6.visitorInformationSystem.PointOfInterest.Attraction.Attraction;
import be.kdg.prog6.visitorInformationSystem.PointOfInterest.Attraction.AttractionLoadPort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DefaultShowAllAttractionsUseCase implements ShowAllAttractionsUseCase {
    private final be.kdg.prog6.visitorInformationSystem.PointOfInterest.Attraction.AttractionLoadPort AttractionLoadPort;

    public DefaultShowAllAttractionsUseCase(AttractionLoadPort attractionLoadPort) {
        AttractionLoadPort = attractionLoadPort;
    }

    @Override
    public List<Attraction> showAllAttractions() {
        return AttractionLoadPort.loadAllAttractions();
    }
}
