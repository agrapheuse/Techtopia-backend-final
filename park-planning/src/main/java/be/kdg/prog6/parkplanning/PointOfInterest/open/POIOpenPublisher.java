package be.kdg.prog6.parkplanning.PointOfInterest.open;

import be.kdg.prog6.events.PointOfInterestOpenedEvent;
import be.kdg.prog6.parkplanning.PointOfInterest.open.ports.POIOpenedPort;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class POIOpenPublisher implements POIOpenedPort {
    public static final Logger log = LoggerFactory.getLogger(POIOpenPublisher.class);

    private final ApplicationEventPublisher applicationEventPublisher;

    public POIOpenPublisher(ApplicationEventPublisher applicationEventPublisher) {
        this.applicationEventPublisher = applicationEventPublisher;
    }

    @Override
    public void openPOI(UUID uuid) {
        log.info("publishing event that POI was opened");
        applicationEventPublisher.publishEvent(new PointOfInterestOpenedEvent(uuid));
    }
}
