package be.kdg.prog6.visitorInformationSystem.adapters.config;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQTopology {
    public static final String ATTRACTION_EVENTS_TOPIC = "attraction-events";
    public static final String ATTRACTION_EVENTS_QUEUE = "attraction-park-planning-queue";

    @Bean
    TopicExchange attractionEventsExchange() {
        return new TopicExchange(ATTRACTION_EVENTS_TOPIC);
    }

    @Bean
    Queue attractionEventsQueue() {
        return new Queue(ATTRACTION_EVENTS_QUEUE);
    }


    @Bean
    Binding eventsBinding(TopicExchange attractionEventsExchange, Queue attractionEventsQueue) {
        return BindingBuilder.bind(attractionEventsQueue).to(attractionEventsExchange).with("attraction.event.#");
    }
}
