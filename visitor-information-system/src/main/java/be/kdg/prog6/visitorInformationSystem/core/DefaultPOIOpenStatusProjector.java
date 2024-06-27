package be.kdg.prog6.visitorInformationSystem.core;

import be.kdg.prog6.events.PointOfInterestOpenStatusChangedEvent;
import be.kdg.prog6.visitorInformationSystem.ports.in.POIOpenStatusProjector;
import be.kdg.prog6.visitorInformationSystem.ports.out.POIProjectionPort;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

public class DefaultPOIOpenStatusProjector implements POIOpenStatusProjector {
    private final POIProjectionPort projectionPort;

    public DefaultPOIOpenStatusProjector(POIProjectionPort projectionPort) {
        this.projectionPort = projectionPort;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void project(PointOfInterestOpenStatusChangedEvent event) {
        projectionPort.updatePOI(event.POIUuid(), event.open());
    }
}
