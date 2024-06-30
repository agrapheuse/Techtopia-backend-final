package be.kdg.prog6.parkplanning.adapters.out.amqp;

import be.kdg.prog6.events.PointOfInterestOpenStatusChangedEvent;
import be.kdg.prog6.parkplanning.ports.out.POIOpenedStatusChangedPort;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class POIChangeOpenStatusPublisher implements POIOpenedStatusChangedPort {
    public static final Logger log = LoggerFactory.getLogger(POIChangeOpenStatusPublisher.class);

    private final ApplicationEventPublisher applicationEventPublisher;

    public POIChangeOpenStatusPublisher(ApplicationEventPublisher applicationEventPublisher) {
        this.applicationEventPublisher = applicationEventPublisher;
    }

    @Override
    public void changeOpenStatus(UUID uuid, boolean open) {
        log.info("publishing event that POI was opened");
        applicationEventPublisher.publishEvent(new PointOfInterestOpenStatusChangedEvent(uuid, open));
    }
}
