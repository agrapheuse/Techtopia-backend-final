package be.kdg.prog6.parkplanning.core;

import be.kdg.prog6.parkplanning.domain.PointOfInterest;
import be.kdg.prog6.parkplanning.ports.in.AddPersonToQueueUseCase;
import be.kdg.prog6.parkplanning.ports.out.POILoadPort;
import be.kdg.prog6.parkplanning.ports.out.POIQueueUpdatedPort;
import be.kdg.prog6.parkplanning.ports.out.POIUpdatePort;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class DefaultAddPersonToQueueUseCase implements AddPersonToQueueUseCase {
    public static final Logger log = LoggerFactory.getLogger(DefaultAddPersonToQueueUseCase.class);

    private final POILoadPort poiLoadPort;
    private final POIUpdatePort poiUpdatePort;
    private final POIQueueUpdatedPort poiQueueUpdatedPort;

    public DefaultAddPersonToQueueUseCase(POILoadPort poiLoadPort, POIUpdatePort poiUpdatePort, POIQueueUpdatedPort poiQueueUpdatedPort) {
        this.poiLoadPort = poiLoadPort;
        this.poiUpdatePort = poiUpdatePort;
        this.poiQueueUpdatedPort = poiQueueUpdatedPort;
    }

    @Override
    public void addPersonToUUID(UUID poiUUID) {
        PointOfInterest poi = poiLoadPort.loadPointOfInterest(poiUUID);
        poi.addPerson();
        poiUpdatePort.updatePOI(poi);
        poiQueueUpdatedPort.updatePOIAmountOfPeople(poiUUID, poi.getAmountOfPeople());
    }
}
