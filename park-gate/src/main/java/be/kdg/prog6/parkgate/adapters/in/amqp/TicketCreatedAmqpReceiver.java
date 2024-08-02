package be.kdg.prog6.parkgate.adapters.in.amqp;

import be.kdg.prog6.events.TicketCreatedEvent;
import be.kdg.prog6.parkgate.adapters.config.RabbitMQTopology;
import be.kdg.prog6.parkgate.ports.in.CreateTicketUseCase;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class TicketCreatedAmqpReceiver {
    public static final Logger log = LoggerFactory.getLogger(TicketCreatedAmqpReceiver.class);

    private final CreateTicketUseCase createTicketUseCase;

    public TicketCreatedAmqpReceiver(CreateTicketUseCase createTicketUseCase) {
        this.createTicketUseCase = createTicketUseCase;
    }

    @RabbitListener(queues = RabbitMQTopology.TICKET_EVENTS_QUEUE, messageConverter = "#{jackson2JsonMessageConverter}")
    public void changeOpenStatus(TicketCreatedEvent ticketCreatedEvent) {
        log.info("message received: {} created", ticketCreatedEvent.uuid());
        createTicketUseCase.createTicket(ticketCreatedEvent);
    }
}
