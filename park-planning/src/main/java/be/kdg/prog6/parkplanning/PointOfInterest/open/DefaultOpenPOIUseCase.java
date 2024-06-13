package be.kdg.prog6.parkplanning.PointOfInterest.open;

import be.kdg.prog6.parkplanning.PointOfInterest.open.ports.OpenPOIUseCase;
import be.kdg.prog6.parkplanning.PointOfInterest.open.ports.POIOpenedPort;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class DefaultOpenPOIUseCase implements OpenPOIUseCase {
    private final POIOpenedPort poiOpenedPort;

    public DefaultOpenPOIUseCase(POIOpenedPort poiOpenedPort) {
        this.poiOpenedPort = poiOpenedPort;
    }

    @Override
    public void openPOI(UUID uuid) {
        poiOpenedPort.openPOI(uuid);
    }
}
