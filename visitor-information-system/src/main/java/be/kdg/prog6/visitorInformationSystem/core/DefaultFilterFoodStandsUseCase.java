package be.kdg.prog6.visitorInformationSystem.core;

import be.kdg.prog6.visitorInformationSystem.ports.in.FilterFoodStandsUseCase;
import be.kdg.prog6.visitorInformationSystem.domain.FoodStand;
import be.kdg.prog6.visitorInformationSystem.ports.out.FoodStandLoadPort;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DefaultFilterFoodStandsUseCase implements FilterFoodStandsUseCase {
    private final FoodStandLoadPort foodStandLoadPort;
    public static final Logger log = LoggerFactory.getLogger(DefaultFilterFoodStandsUseCase.class);

    public DefaultFilterFoodStandsUseCase(FoodStandLoadPort foodStandLoadPort) {
        this.foodStandLoadPort = foodStandLoadPort;
    }

    @Override
    public List<FoodStand> filterFoodStands(Optional<String> name, Optional<Boolean> open) {
        return foodStandLoadPort.loadFilteredFoodStands(name, open);
    }
}
