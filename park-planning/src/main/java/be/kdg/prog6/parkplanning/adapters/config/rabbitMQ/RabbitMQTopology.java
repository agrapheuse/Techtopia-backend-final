package be.kdg.prog6.parkplanning.adapters.config.rabbitMQ;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQTopology {
    public static final String ATTRACTION_EVENTS_TOPIC = "attraction-events";
    public static final String ATTRACTION_EVENTS_QUEUE = "attraction-park-planning-queue";

    public static final String VISITED_POI_EVENTS_TOPIC = "visited-poi-events";
    public static final String VISITED_POI_EVENTS_QUEUE = "visited-poi-queue";

    public static final String POI_QUEUE_EVENTS_TOPIC = "poi-length-events";
    public static final String POI_QUEUE_EVENTS_QUEUE = "poi-length-queue";

    @Bean
    TopicExchange attractionEventsExchange() {
        return new TopicExchange(ATTRACTION_EVENTS_TOPIC);
    }

    @Bean
    Queue attractionEventsQueue() {
        return new Queue(ATTRACTION_EVENTS_QUEUE);
    }


    @Bean
    Binding attractionEventsBinding(TopicExchange attractionEventsExchange, Queue attractionEventsQueue) {
        return BindingBuilder.bind(attractionEventsQueue).to(attractionEventsExchange).with("attraction.event.#");
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
        return BindingBuilder.bind(visitedPOIEventsQueue).to(visitedPOIEventsExchange).with("POI.event.#");
    }

    @Bean
    TopicExchange POIQueueEventsExchange() {
        return new TopicExchange(POI_QUEUE_EVENTS_TOPIC);
    }

    @Bean
    Queue POIQueueEventsQueue() {
        return new Queue(POI_QUEUE_EVENTS_QUEUE);
    }

    @Bean
    Binding POIQueueEventsEventsBinding(TopicExchange POIQueueEventsExchange, Queue POIQueueEventsQueue) {
        return BindingBuilder.bind(POIQueueEventsQueue).to(POIQueueEventsExchange).with("POI.queue.event.#");
    }
}
