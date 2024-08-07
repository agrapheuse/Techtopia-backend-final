package be.kdg.prog6.parkplanning.adapters.in.amqp;

import be.kdg.prog6.events.PointOfInterestVisitedEvent;
import be.kdg.prog6.parkplanning.adapters.config.RabbitMQTopology;
import be.kdg.prog6.parkplanning.ports.in.AddPersonToQueueUseCase;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class POIVisitedAmqpReceiver {
    public static final Logger log = LoggerFactory.getLogger(POIVisitedAmqpReceiver.class);

    private final AddPersonToQueueUseCase addPersonToQueueUseCase;

    public POIVisitedAmqpReceiver(AddPersonToQueueUseCase addPersonToQueueUseCase) {
        this.addPersonToQueueUseCase = addPersonToQueueUseCase;
    }

    @RabbitListener(queues = RabbitMQTopology.VISITED_POI_EVENTS_QUEUE, messageConverter = "#{jackson2JsonMessageConverter}")
    public void changeOpenStatus(PointOfInterestVisitedEvent pointOfInterestVisitedEvent) {
        log.info("message received: {} visited", pointOfInterestVisitedEvent.poiUUId());
        addPersonToQueueUseCase.addPersonToUUID(pointOfInterestVisitedEvent.poiUUId());
    }
}
