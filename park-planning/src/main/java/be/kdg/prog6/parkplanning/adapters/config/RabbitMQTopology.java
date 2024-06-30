package be.kdg.prog6.parkplanning.adapters.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQTopology {
    public static final String ATTRACTION_EVENTS_FAN_OUT = "attraction-events";
    public static final String ATTRACTION_EVENTS_QUEUE = "attraction-park-planning-queue";

    @Bean
    FanoutExchange attractionEventsExchange() {
        return new FanoutExchange(ATTRACTION_EVENTS_FAN_OUT);
    }

    @Bean
    Queue attractionEventsQueue() {
        return new Queue(ATTRACTION_EVENTS_QUEUE);
    }


    @Bean
    Binding eventsBinding(FanoutExchange attractionEventsExchange, Queue attractionEventsQueue) {
        return BindingBuilder.bind(attractionEventsQueue).to(attractionEventsExchange);
    }

}
