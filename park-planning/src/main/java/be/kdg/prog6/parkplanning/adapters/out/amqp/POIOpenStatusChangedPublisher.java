package be.kdg.prog6.parkplanning.adapters.out.amqp;

import be.kdg.prog6.events.PointOfInterestOpenStatusChangedEvent;
import be.kdg.prog6.parkplanning.adapters.config.RabbitMQTopology;
import be.kdg.prog6.parkplanning.ports.out.POIOpenedStatusChangedPort;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class POIOpenStatusChangedPublisher implements POIOpenedStatusChangedPort {
    public static final Logger log = LoggerFactory.getLogger(POIOpenStatusChangedPublisher.class);

    private final RabbitTemplate rabbitTemplate;

    public POIOpenStatusChangedPublisher(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    @Override
    public void openStatusChanged(UUID uuid, boolean open) {
        log.debug("rabbitMQ message will be sent to VIS saying: POI with UUID {} will have its open status changed to {}", uuid, open);
        rabbitTemplate.convertAndSend(RabbitMQTopology.ATTRACTION_EVENTS_TOPIC, "attraction.event.change-open-status", new PointOfInterestOpenStatusChangedEvent(uuid, open));
    }
}
