package be.kdg.prog6.visitorInformationSystem.core;

import be.kdg.prog6.visitorInformationSystem.ports.in.ShowAllFoodStandsUseCase;
import be.kdg.prog6.visitorInformationSystem.domain.FoodStand;
import be.kdg.prog6.visitorInformationSystem.ports.out.FoodStandLoadPort;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DefaultShowAllFoodStandsUseCase implements ShowAllFoodStandsUseCase {
    private final FoodStandLoadPort foodStandLoadPort;
    public static final Logger log = LoggerFactory.getLogger(DefaultShowAllFoodStandsUseCase.class);

    public DefaultShowAllFoodStandsUseCase(FoodStandLoadPort foodStandLoadPort) {
        this.foodStandLoadPort = foodStandLoadPort;
    }

    @Override
    public List<FoodStand> showAllFoodStands() {
        return foodStandLoadPort.loadAllFoodStands();
    }
}
