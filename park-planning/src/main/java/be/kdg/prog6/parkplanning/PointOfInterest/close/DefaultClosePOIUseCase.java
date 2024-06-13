package be.kdg.prog6.parkplanning.PointOfInterest.close;

import be.kdg.prog6.parkplanning.PointOfInterest.close.ports.ClosePOIUseCase;
import be.kdg.prog6.parkplanning.PointOfInterest.close.ports.POIClosedPort;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class DefaultClosePOIUseCase implements ClosePOIUseCase {
    private final POIClosedPort poiClosedPort;

    public DefaultClosePOIUseCase(POIClosedPort poiClosedPort) {
        this.poiClosedPort = poiClosedPort;
    }

    @Override
    public void closePOI(UUID uuid) {
        poiClosedPort.closePOI(uuid);
    }
}
