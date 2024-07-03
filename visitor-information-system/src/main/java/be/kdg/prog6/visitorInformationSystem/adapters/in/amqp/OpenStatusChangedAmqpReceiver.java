package be.kdg.prog6.visitorInformationSystem.adapters.in.amqp;

import be.kdg.prog6.events.PointOfInterestOpenStatusChangedEvent;
import be.kdg.prog6.visitorInformationSystem.adapters.config.RabbitMQTopology;
import be.kdg.prog6.visitorInformationSystem.ports.in.UpdateOpenStatusUseCase;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class OpenStatusChangedAmqpReceiver {
    public static final Logger log = LoggerFactory.getLogger(OpenStatusChangedAmqpReceiver.class);

    private final UpdateOpenStatusUseCase updateOpenStatusUseCase;

    public OpenStatusChangedAmqpReceiver(UpdateOpenStatusUseCase updateOpenStatusUseCase) {
        this.updateOpenStatusUseCase = updateOpenStatusUseCase;
    }

    @RabbitListener(queues = RabbitMQTopology.ATTRACTION_EVENTS_QUEUE, messageConverter = "#{jackson2JsonMessageConverter}")
    public void changeOpenStatus(PointOfInterestOpenStatusChangedEvent pointOfInterestOpenStatusChangedEvent) {
        log.debug("message received: {} {}", pointOfInterestOpenStatusChangedEvent.POIUuid(), pointOfInterestOpenStatusChangedEvent.open());
        updateOpenStatusUseCase.updateOpenStatus(pointOfInterestOpenStatusChangedEvent);
    }
}
