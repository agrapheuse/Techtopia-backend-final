package be.kdg.prog6.visitorInformationSystem.core;

import be.kdg.prog6.visitorInformationSystem.ports.in.ShowAllFoodStandsUseCase;
import be.kdg.prog6.visitorInformationSystem.domain.FoodStand;
import be.kdg.prog6.visitorInformationSystem.ports.out.FoodStandLoadPort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DefaultShowAllFoodStandsUseCase implements ShowAllFoodStandsUseCase {
    private final FoodStandLoadPort foodStandLoadPort;

    public DefaultShowAllFoodStandsUseCase(FoodStandLoadPort foodStandLoadPort) {
        this.foodStandLoadPort = foodStandLoadPort;
    }

    @Override
    public List<FoodStand> showAllFoodStands() {
        return foodStandLoadPort.loadAllFoodStands();
    }
}
