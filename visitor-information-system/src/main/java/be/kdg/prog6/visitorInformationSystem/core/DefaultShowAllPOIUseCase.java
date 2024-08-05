package be.kdg.prog6.visitorInformationSystem.core;

import be.kdg.prog6.visitorInformationSystem.domain.PointOfInterest;
import be.kdg.prog6.visitorInformationSystem.ports.in.ShowAllPOIUseCase;
import be.kdg.prog6.visitorInformationSystem.ports.out.POILoadPort;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DefaultShowAllPOIUseCase implements ShowAllPOIUseCase {
    private final POILoadPort poiLoadPort;
    public static final Logger log = LoggerFactory.getLogger(DefaultShowAllPOIUseCase.class);

    public DefaultShowAllPOIUseCase(POILoadPort poiLoadPort) {
        this.poiLoadPort = poiLoadPort;
    }

    @Override
    public List<PointOfInterest> showAllPointOfInterests() {
        log.debug("show all pois called in use case");
        return poiLoadPort.loadPointsOfInterest();
    }
}
