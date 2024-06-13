package be.kdg.prog6.visitorInformationSystem.core;

import be.kdg.prog6.visitorInformationSystem.domain.Attraction;
import be.kdg.prog6.visitorInformationSystem.ports.in.FilterAttractionUseCase;
import be.kdg.prog6.visitorInformationSystem.ports.out.AttractionLoadPort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DefaultFilterAttractionUseCase implements FilterAttractionUseCase {
    private final AttractionLoadPort attractionLoadPort;

    public DefaultFilterAttractionUseCase(AttractionLoadPort attractionLoadPort) {
        this.attractionLoadPort = attractionLoadPort;
    }

    @Override
    public List<Attraction> filterAttractions(Optional<String> name, Optional<Boolean> open) {
        return attractionLoadPort.loadFilteredAttractions(name, open);
    }
}
