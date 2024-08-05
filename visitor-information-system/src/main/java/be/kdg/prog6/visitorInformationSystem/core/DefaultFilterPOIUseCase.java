package be.kdg.prog6.visitorInformationSystem.core;

import be.kdg.prog6.visitorInformationSystem.domain.PointOfInterest;
import be.kdg.prog6.visitorInformationSystem.ports.in.FilterPOIUseCase;
import be.kdg.prog6.visitorInformationSystem.ports.out.POILoadPort;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DefaultFilterPOIUseCase implements FilterPOIUseCase {
    private final POILoadPort poiLoadPort;
    public static final Logger log = LoggerFactory.getLogger(DefaultFilterFoodStandsUseCase.class);

    public DefaultFilterPOIUseCase(POILoadPort poiLoadPort) {
        this.poiLoadPort = poiLoadPort;
    }

    @Override
    public List<PointOfInterest> filterPointsOfInterest(String name, Boolean open) {
        log.debug("load filtered pois {}, {} called in use case", name, open);
        return poiLoadPort.loadFilteredPointsOfInterest(name, open);
    }
}
