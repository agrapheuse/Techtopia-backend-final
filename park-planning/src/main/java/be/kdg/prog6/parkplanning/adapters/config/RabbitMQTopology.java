package be.kdg.prog6.parkplanning.adapters.config;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQTopology {
    public static final String ATTRACTION_EVENTS_DIRECT = "attraction-events";
    public static final String ATTRACTION_EVENTS_QUEUE = "attraction-park-planning-queue";

    @Bean
    DirectExchange attractionEventsExchange() {
        return new DirectExchange(ATTRACTION_EVENTS_DIRECT);
    }

    @Bean
    Queue attractionEventsQueue() {
        return new Queue(ATTRACTION_EVENTS_QUEUE);
    }


    @Bean
    Binding eventsBinding(DirectExchange attractionEventsExchange, Queue attractionEventsQueue) {
        return BindingBuilder.bind(attractionEventsQueue).to(attractionEventsExchange).withQueueName();
    }
}
