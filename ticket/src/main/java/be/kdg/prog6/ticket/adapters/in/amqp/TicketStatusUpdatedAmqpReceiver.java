package be.kdg.prog6.ticket.adapters.in.amqp;

import be.kdg.prog6.events.TicketStatusChangedEvent;
import be.kdg.prog6.ticket.adapters.config.RabbitMQTopology;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class TicketStatusUpdatedAmqpReceiver {
    public static final Logger log = LoggerFactory.getLogger(TicketStatusUpdatedAmqpReceiver.class);

    public TicketStatusUpdatedAmqpReceiver() {
    }

    @RabbitListener(queues = RabbitMQTopology.TICKET_STATUS_EVENTS_QUEUE, messageConverter = "#{jackson2JsonMessageConverter}")
    public void changeTicketStatus(TicketStatusChangedEvent ticketStatusChangedEvent) {
        log.info("message received: {} status changed to {}", ticketStatusChangedEvent.TicketUUID(), ticketStatusChangedEvent.status());
    }
}
