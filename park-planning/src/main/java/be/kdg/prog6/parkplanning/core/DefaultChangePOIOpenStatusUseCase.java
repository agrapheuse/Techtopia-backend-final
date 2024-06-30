package be.kdg.prog6.parkplanning.core;

import be.kdg.prog6.parkplanning.ports.in.ChangePOIOpenStatusUseCase;
import be.kdg.prog6.parkplanning.ports.out.POIOpenedStatusChangedPort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class DefaultChangePOIOpenStatusUseCase implements ChangePOIOpenStatusUseCase {
    private final List<POIOpenedStatusChangedPort> poiOpenedStatusChangedPorts;

    public DefaultChangePOIOpenStatusUseCase(List<POIOpenedStatusChangedPort> poiOpenedStatusChangedPorts) {
        this.poiOpenedStatusChangedPorts = poiOpenedStatusChangedPorts;
    }

    @Override
    public void changeOpenStatus(UUID uuid, boolean open) {
        poiOpenedStatusChangedPorts.forEach(port -> port.changeOpenStatus(uuid, open));
    }
}
