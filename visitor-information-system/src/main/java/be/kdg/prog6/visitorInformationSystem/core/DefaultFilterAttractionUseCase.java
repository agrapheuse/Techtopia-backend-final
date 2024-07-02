package be.kdg.prog6.visitorInformationSystem.core;

import be.kdg.prog6.visitorInformationSystem.ports.in.FilterAttractionUseCase;
import be.kdg.prog6.visitorInformationSystem.domain.Attraction;
import be.kdg.prog6.visitorInformationSystem.ports.out.AttractionLoadPort;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DefaultFilterAttractionUseCase implements FilterAttractionUseCase {
    private final AttractionLoadPort attractionLoadPort;
    public static final Logger log = LoggerFactory.getLogger(DefaultFilterAttractionUseCase.class);

    public DefaultFilterAttractionUseCase(AttractionLoadPort attractionLoadPort) {
        this.attractionLoadPort = attractionLoadPort;
    }

    @Override
    public List<Attraction> filterAttractions(String name, boolean open) {
        return attractionLoadPort.loadFilteredAttractions(name, open);
    }
}
