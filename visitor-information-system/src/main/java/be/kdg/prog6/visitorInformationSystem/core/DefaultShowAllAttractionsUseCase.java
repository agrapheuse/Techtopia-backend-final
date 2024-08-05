package be.kdg.prog6.visitorInformationSystem.core;

import be.kdg.prog6.visitorInformationSystem.ports.in.ShowAllAttractionsUseCase;
import be.kdg.prog6.visitorInformationSystem.domain.Attraction;
import be.kdg.prog6.visitorInformationSystem.ports.out.AttractionLoadPort;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DefaultShowAllAttractionsUseCase implements ShowAllAttractionsUseCase {
    private final be.kdg.prog6.visitorInformationSystem.ports.out.AttractionLoadPort AttractionLoadPort;
    public static final Logger log = LoggerFactory.getLogger(DefaultShowAllAttractionsUseCase.class);

    public DefaultShowAllAttractionsUseCase(AttractionLoadPort attractionLoadPort) {
        AttractionLoadPort = attractionLoadPort;
    }

    @Override
    public List<Attraction> showAllAttractions() {
        log.debug("show all attractions called in use case");
        return AttractionLoadPort.loadAllAttractions();
    }
}
