package be.kdg.prog6.ticket.adapters.out.amqp;

import be.kdg.prog6.events.TicketCreatedEvent;
import be.kdg.prog6.ticket.domain.Ticket;
import be.kdg.prog6.ticket.ports.out.TicketCreatedPort;
import be.kdg.prog6.ticket.adapters.config.RabbitMQTopology;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

@Component
public class TicketCreatedAmqpPublisher implements TicketCreatedPort {
    public static final Logger log = LoggerFactory.getLogger(TicketCreatedAmqpPublisher.class);

    private final RabbitTemplate rabbitTemplate;

    public TicketCreatedAmqpPublisher(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    @Override
    public void createTicket(Ticket ticket) {
        log.info("rabbitMQ message will be sent to Park-gate saying: Ticket with UUID {} was created", ticket.getUuid().uuid());
        rabbitTemplate.convertAndSend(RabbitMQTopology.TICKET_EVENTS_TOPIC, "ticket.event.created", new TicketCreatedEvent(ticket.getUuid().uuid()));
    }
}
