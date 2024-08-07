package be.kdg.prog6.parkgate.adapters.out.amqp;

import be.kdg.prog6.events.PointOfInterestVisitedEvent;
import be.kdg.prog6.parkgate.adapters.config.RabbitMQTopology;
import be.kdg.prog6.parkgate.domain.TicketActivity;
import be.kdg.prog6.parkgate.ports.out.TicketActivityCreatedPort;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

@Component
public class PersonVisitedPOIPublisher implements TicketActivityCreatedPort {
    public static final Logger log = LoggerFactory.getLogger(PersonVisitedPOIPublisher.class);

    private final RabbitTemplate rabbitTemplate;

    public PersonVisitedPOIPublisher(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    @Override
    public void createTicketActivity(TicketActivity ticketActivity) {
        log.info("rabbitMQ message will be sent to park gate saying: A person has visited POI with uuid {}", ticketActivity.poiUUID());
        if (ticketActivity.poiUUID() != null) {
            log.info(String.valueOf(ticketActivity.poiUUID()));
            try {
                rabbitTemplate.convertAndSend(
                        RabbitMQTopology.VISITED_POI_EVENTS_TOPIC,
                        "POI.event.visited",
                        new PointOfInterestVisitedEvent(ticketActivity.poiUUID())
                );
            } catch (Exception e) {
                log.error(e.getMessage());
            }
        }
    }
}
