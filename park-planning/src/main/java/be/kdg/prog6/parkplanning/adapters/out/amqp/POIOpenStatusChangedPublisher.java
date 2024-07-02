package be.kdg.prog6.parkplanning.adapters.out.amqp;

import be.kdg.prog6.events.PointOfInterestOpenStatusChangedEvent;
import be.kdg.prog6.events.events.EventCatalog;
import be.kdg.prog6.events.events.EventHeader;
import be.kdg.prog6.events.events.EventMessage;
import be.kdg.prog6.parkplanning.adapters.config.RabbitMQTopology;
import be.kdg.prog6.parkplanning.ports.out.POIOpenedStatusChangedPort;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class POIOpenStatusChangedPublisher implements POIOpenedStatusChangedPort {
    public static final Logger log = LoggerFactory.getLogger(POIOpenStatusChangedPublisher.class);

    private final RabbitTemplate rabbitTemplate;
    private final ObjectMapper objectMapper;

    public POIOpenStatusChangedPublisher(RabbitTemplate rabbitTemplate, ObjectMapper objectMapper, ApplicationEventPublisher applicationEventPublisher) {
        this.rabbitTemplate = rabbitTemplate;
        this.objectMapper = objectMapper;
    }

    @Override
    public void openStatusChanged(UUID uuid, boolean open) {
        log.info("publishing rabbitmq event that POI was opened");
        var eventHeader = EventHeader.builder().eventID(UUID.randomUUID()).eventCatalog(EventCatalog.ATTRACTION_OPEN_STATUS_CHANGED).build();
        var eventBody = new PointOfInterestOpenStatusChangedEvent(uuid, open);
        try {
            rabbitTemplate.convertAndSend(RabbitMQTopology.ATTRACTION_EVENTS_DIRECT, "attraction.openStatusChanged", EventMessage.builder().eventHeader(eventHeader).eventBody(objectMapper.writeValueAsString(eventBody)).build());
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

    }
}
