package be.kdg.prog6.visitorInformationSystem.PointOfInterest.FoodStand.showAll;

import be.kdg.prog6.visitorInformationSystem.PointOfInterest.FoodStand.FoodStand;
import be.kdg.prog6.visitorInformationSystem.PointOfInterest.FoodStand.FoodStandLoadPort;
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
