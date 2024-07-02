package be.kdg.prog6.visitorInformationSystem.core;

import be.kdg.prog6.visitorInformationSystem.domain.PointOfInterest;
import be.kdg.prog6.visitorInformationSystem.ports.in.FilterPOIUseCase;
import be.kdg.prog6.visitorInformationSystem.ports.out.POILoadPort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DefaultFilterPOIUseCase implements FilterPOIUseCase {
    private final POILoadPort poiLoadPort;

    public DefaultFilterPOIUseCase(POILoadPort poiLoadPort) {
        this.poiLoadPort = poiLoadPort;
    }

    @Override
    public List<PointOfInterest> filterPointsOfInterest(String name, Boolean open) {
        return poiLoadPort.loadFilteredPointsOfInterest(name, open);
    }
}