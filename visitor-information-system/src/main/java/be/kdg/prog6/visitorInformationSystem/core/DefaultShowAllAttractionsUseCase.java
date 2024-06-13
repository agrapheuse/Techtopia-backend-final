package be.kdg.prog6.visitorInformationSystem.core;

import be.kdg.prog6.visitorInformationSystem.domain.Attraction;
import be.kdg.prog6.visitorInformationSystem.ports.in.ShowAllAttractionsUseCase;
import be.kdg.prog6.visitorInformationSystem.ports.out.AttractionLoadPort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DefaultShowAllAttractionsUseCase implements ShowAllAttractionsUseCase {
    private final AttractionLoadPort AttractionLoadPort;

    public DefaultShowAllAttractionsUseCase(AttractionLoadPort attractionLoadPort) {
        AttractionLoadPort = attractionLoadPort;
    }

    @Override
    public List<Attraction> showAllAttractions() {
        return AttractionLoadPort.loadAllAttractions();
    }
}
