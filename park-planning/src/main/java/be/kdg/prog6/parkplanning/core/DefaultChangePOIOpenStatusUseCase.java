package be.kdg.prog6.parkplanning.core;

import be.kdg.prog6.parkplanning.ports.in.ChangeOpenStatusCommand;
import be.kdg.prog6.parkplanning.ports.in.ChangePOIOpenStatusUseCase;
import be.kdg.prog6.parkplanning.ports.out.POIOpenedStatusChangedPort;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DefaultChangePOIOpenStatusUseCase implements ChangePOIOpenStatusUseCase {
    private final List<POIOpenedStatusChangedPort> poiOpenedStatusChangedPorts;
    public static final Logger log = LoggerFactory.getLogger(DefaultChangePOIOpenStatusUseCase.class);

    public DefaultChangePOIOpenStatusUseCase(List<POIOpenedStatusChangedPort> poiOpenedStatusChangedPorts) {
        this.poiOpenedStatusChangedPorts = poiOpenedStatusChangedPorts;
    }

    @Override
    public void changeOpenStatus(ChangeOpenStatusCommand changeOpenStatusCommand) {
        log.debug("changing open status of poi {} in use case ", changeOpenStatusCommand.uuid());
        poiOpenedStatusChangedPorts.forEach(port -> port.openStatusChanged(changeOpenStatusCommand.uuid(), changeOpenStatusCommand.open()));
    }
}
