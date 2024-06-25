package be.kdg.prog6.parkplanning.PointOfInterest.open;

import be.kdg.prog6.parkplanning.PointOfInterest.open.ports.OpenPOIUseCase;
import be.kdg.prog6.parkplanning.PointOfInterest.open.ports.POIOpenedPort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class DefaultOpenPOIUseCase implements OpenPOIUseCase {
    private final List<POIOpenedPort> poiOpenedPorts;

    public DefaultOpenPOIUseCase(List<POIOpenedPort> poiOpenedPorts) {
        this.poiOpenedPorts = poiOpenedPorts;
    }

    @Override
    public void openPOI(UUID uuid) {
        poiOpenedPorts.forEach(port -> port.openPOI(uuid));
    }
}
