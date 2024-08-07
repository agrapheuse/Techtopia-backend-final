package be.kdg.prog6.parkgate.adapters.config;

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

    public static final String TICKET_STATUS_EVENTS_TOPIC = "ticket-status-events";
    public static final String TICKET_STATUS_EVENTS_QUEUE = "ticket-status-updated-queue";

    public static final String VISITED_POI_EVENTS_TOPIC = "visited-poi-events";
    public static final String VISITED_POI_EVENTS_QUEUE = "visited-poi-queue";

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

    @Bean
    TopicExchange ticketStatusEventsExchange() {
        return new TopicExchange(TICKET_STATUS_EVENTS_TOPIC);
    }

    @Bean
    Queue ticketStatusEventsQueue() {
        return new Queue(TICKET_STATUS_EVENTS_QUEUE);
    }

    @Bean
    Binding ticketStatusEventsBinding(TopicExchange ticketStatusEventsExchange, Queue ticketStatusEventsQueue) {
        return BindingBuilder.bind(ticketStatusEventsQueue).to(ticketStatusEventsExchange).with("ticket.event.#");
    }

    @Bean
    TopicExchange visitedPOIEventsExchange() {
        return new TopicExchange(VISITED_POI_EVENTS_TOPIC);
    }

    @Bean
    Queue visitedPOIEventsQueue() {
        return new Queue(VISITED_POI_EVENTS_QUEUE);
    }

    @Bean
    Binding visitedPOIEventsBinding(TopicExchange visitedPOIEventsExchange, Queue visitedPOIEventsQueue) {
        return BindingBuilder.bind(visitedPOIEventsQueue).to(visitedPOIEventsExchange).with("visitedPOI.command.#");
    }
}
