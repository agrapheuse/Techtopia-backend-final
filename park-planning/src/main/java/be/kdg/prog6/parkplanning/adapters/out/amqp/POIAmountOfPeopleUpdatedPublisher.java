package be.kdg.prog6.parkplanning.adapters.out.amqp;

import be.kdg.prog6.events.PointOfInterestAmountOfPeopleUpdatedEvent;
import be.kdg.prog6.parkplanning.adapters.config.rabbitMQ.RabbitMQTopology;
import be.kdg.prog6.parkplanning.ports.out.POIQueueUpdatedPort;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class POIAmountOfPeopleUpdatedPublisher implements POIQueueUpdatedPort {
    public static final Logger log = LoggerFactory.getLogger(POIAmountOfPeopleUpdatedPublisher.class);

    private final RabbitTemplate rabbitTemplate;

    public POIAmountOfPeopleUpdatedPublisher(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    @Override
    public void updatePOIAmountOfPeople(UUID poiUUID, int amountOfPeople) {
        log.info("rabbitMQ message will be sent to VIS saying: POI with UUID {} will have its amount of people in queue updated to {}", poiUUID, amountOfPeople);
        rabbitTemplate.convertAndSend(RabbitMQTopology.POI_QUEUE_EVENTS_TOPIC, "POI.queue.event.update-queue-length", new PointOfInterestAmountOfPeopleUpdatedEvent(poiUUID, amountOfPeople));
    }
}
