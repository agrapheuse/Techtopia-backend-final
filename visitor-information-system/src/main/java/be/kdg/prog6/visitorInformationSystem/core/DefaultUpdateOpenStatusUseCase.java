package be.kdg.prog6.visitorInformationSystem.core;

import be.kdg.prog6.events.PointOfInterestOpenStatusChangedEvent;
import be.kdg.prog6.visitorInformationSystem.domain.Attraction;
import be.kdg.prog6.visitorInformationSystem.domain.FoodStand;
import be.kdg.prog6.visitorInformationSystem.domain.PointOfInterest;
import be.kdg.prog6.visitorInformationSystem.ports.in.UpdateOpenStatusUseCase;
import be.kdg.prog6.visitorInformationSystem.ports.out.AttractionUpdatePort;
import be.kdg.prog6.visitorInformationSystem.ports.out.FoodStandUpdatePort;
import be.kdg.prog6.visitorInformationSystem.ports.out.POILoadPort;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class DefaultUpdateOpenStatusUseCase implements UpdateOpenStatusUseCase {
    public static final Logger log = LoggerFactory.getLogger(DefaultUpdateOpenStatusUseCase.class);
    private final POILoadPort poiLoadPort;
    private final AttractionUpdatePort attractionUpdatePort;
    private final FoodStandUpdatePort foodStandUpdatePort;

    public DefaultUpdateOpenStatusUseCase(POILoadPort poiLoadPort, AttractionUpdatePort attractionUpdatePort, FoodStandUpdatePort foodStandUpdatePort) {
        this.poiLoadPort = poiLoadPort;
        this.attractionUpdatePort = attractionUpdatePort;
        this.foodStandUpdatePort = foodStandUpdatePort;
    }

    @Override
    public void updateOpenStatus(PointOfInterestOpenStatusChangedEvent pointOfInterestOpenStatusChangedEvent) {
        log.debug("update open status for poi {} called in use case", pointOfInterestOpenStatusChangedEvent.POIUuid());
        PointOfInterest pointOfInterest = poiLoadPort.loadPointOfInterest(pointOfInterestOpenStatusChangedEvent.POIUuid());
        pointOfInterest.setOpen(pointOfInterestOpenStatusChangedEvent.open());
        if (pointOfInterest.getClass() == Attraction.class) {
            Attraction attraction = (Attraction) pointOfInterest;
            attractionUpdatePort.updateAttraction(attraction);
        } else if (pointOfInterest.getClass() == FoodStand .class) {
            FoodStand foodStand = (FoodStand) pointOfInterest;
            foodStandUpdatePort.updateFoodStand(foodStand);
        }
    }
}
