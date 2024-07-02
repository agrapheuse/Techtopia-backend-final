package be.kdg.prog6.visitorInformationSystem.adapters.in.amqp;

import be.kdg.prog6.events.PointOfInterestOpenStatusChangedEvent;
import be.kdg.prog6.visitorInformationSystem.adapters.config.RabbitMQTopology;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class OpenStatusChangedAmqpReceiver {
    public static final Logger log = LoggerFactory.getLogger(OpenStatusChangedAmqpReceiver.class);

    @RabbitListener(queues = RabbitMQTopology.ATTRACTION_EVENTS_QUEUE, messageConverter = "#{jackson2JsonMessageConverter}")
    public void changeOpenStatus(PointOfInterestOpenStatusChangedEvent pointOfInterestOpenStatusChangedEvent) {
        log.error("message received");
    }
}
