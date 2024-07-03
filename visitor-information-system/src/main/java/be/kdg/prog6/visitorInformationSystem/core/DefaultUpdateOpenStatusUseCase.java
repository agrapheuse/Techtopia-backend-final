package be.kdg.prog6.visitorInformationSystem.core;

import be.kdg.prog6.events.PointOfInterestOpenStatusChangedEvent;
import be.kdg.prog6.visitorInformationSystem.domain.PointOfInterest;
import be.kdg.prog6.visitorInformationSystem.ports.in.UpdateOpenStatusUseCase;
import be.kdg.prog6.visitorInformationSystem.ports.out.POILoadPort;
import be.kdg.prog6.visitorInformationSystem.ports.out.POIUpdatePort;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class DefaultUpdateOpenStatusUseCase implements UpdateOpenStatusUseCase {
    public static final Logger log = LoggerFactory.getLogger(DefaultUpdateOpenStatusUseCase.class);
    private final POILoadPort poiLoadPort;
    private final POIUpdatePort poiUpdatePort;

    public DefaultUpdateOpenStatusUseCase(POILoadPort poiLoadPort, POIUpdatePort poiUpdatePort) {
        this.poiLoadPort = poiLoadPort;
        this.poiUpdatePort = poiUpdatePort;
    }

    @Override
    public void updateOpenStatus(PointOfInterestOpenStatusChangedEvent pointOfInterestOpenStatusChangedEvent) {
        PointOfInterest pointOfInterest = poiLoadPort.loadPointOfInterest(pointOfInterestOpenStatusChangedEvent.POIUuid());
        pointOfInterest.setOpen(pointOfInterestOpenStatusChangedEvent.open());
        poiUpdatePort.updatePOI(pointOfInterest);
    }
}
