package be.kdg.prog6.visitorInformationSystem.adapters.in.amqp;

import be.kdg.prog6.events.PointOfInterestAmountOfPeopleUpdatedEvent;
import be.kdg.prog6.visitorInformationSystem.adapters.config.RabbitMQTopology;
import be.kdg.prog6.visitorInformationSystem.ports.in.UpdateQueueTimeCommand;
import be.kdg.prog6.visitorInformationSystem.ports.in.UpdateQueueTimeUseCase;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class POIAmountOfPeopleUpdatedReceiver {
    public static final Logger log = LoggerFactory.getLogger(POIAmountOfPeopleUpdatedReceiver.class);

    private final UpdateQueueTimeUseCase updateQueueTimeUseCase;

    public POIAmountOfPeopleUpdatedReceiver(UpdateQueueTimeUseCase updateQueueTimeUseCase) {
        this.updateQueueTimeUseCase = updateQueueTimeUseCase;
    }

    @RabbitListener(queues = RabbitMQTopology.POI_QUEUE_EVENTS_QUEUE, messageConverter = "#{jackson2JsonMessageConverter}")
    public void updateQueueTime(PointOfInterestAmountOfPeopleUpdatedEvent pointOfInterestAmountOfPeopleUpdatedEvent) {
        log.debug("message received: {} {}", pointOfInterestAmountOfPeopleUpdatedEvent.poiUUID(), pointOfInterestAmountOfPeopleUpdatedEvent.amountOfPeople());
        updateQueueTimeUseCase.updateQueueTime(new UpdateQueueTimeCommand(
                pointOfInterestAmountOfPeopleUpdatedEvent.poiUUID(),
                pointOfInterestAmountOfPeopleUpdatedEvent.amountOfPeople()
        ));
    }
}
