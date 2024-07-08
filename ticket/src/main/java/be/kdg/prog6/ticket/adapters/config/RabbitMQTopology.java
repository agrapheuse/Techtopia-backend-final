package be.kdg.prog6.ticket.adapters.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQTopology {
    public static final String TICKET_EVENTS_TOPIC = "ticket-events";
    public static final String TICKET_EVENTS_QUEUE = "ticket-create-queue";

    @Bean
    TopicExchange ticketEventsExchange() {
        return new TopicExchange(TICKET_EVENTS_TOPIC);
    }

    @Bean
    Queue ticketEventsQueue() {
        return new Queue(TICKET_EVENTS_QUEUE);
    }

    @Bean
    Binding ticketEventsBinding(TopicExchange ticketEventsExchange, Queue ticketEventsQueue) {
        return BindingBuilder.bind(ticketEventsQueue).to(ticketEventsExchange).with("ticket.event.#");
    }
}
