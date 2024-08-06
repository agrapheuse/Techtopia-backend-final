package be.kdg.prog6.parkgate.adapters.out.amqp;

import be.kdg.prog6.events.TicketStatusChangedEvent;
import be.kdg.prog6.parkgate.adapters.config.RabbitMQTopology;
import be.kdg.prog6.parkgate.domain.Ticket;
import be.kdg.prog6.parkgate.ports.out.TicketUpdatedPort;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

@Component
public class TicketStatusUpdatedPublisher implements TicketUpdatedPort {
    public static final Logger log = LoggerFactory.getLogger(TicketStatusUpdatedPublisher.class);

    private final RabbitTemplate rabbitTemplate;

    public TicketStatusUpdatedPublisher(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    @Override
    public void updateTicket(Ticket ticket) {
        log.debug("rabbitMQ message will be sent to ticket saying: Ticket with UUID {} has changed its status to {}", ticket.getUuid().uuid(), ticket.getStatus());
        rabbitTemplate.convertAndSend(RabbitMQTopology.TICKET_STATUS_EVENTS_TOPIC, "ticket.event.status.updated", new TicketStatusChangedEvent(ticket.getUuid().uuid(), ticket.getStatus()));
    }
}
