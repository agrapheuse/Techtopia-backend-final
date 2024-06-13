package be.kdg.prog6.visitorInformationSystem.PointOfInterest.FoodStand.showFiltered;

import be.kdg.prog6.visitorInformationSystem.PointOfInterest.FoodStand.FoodStand;
import be.kdg.prog6.visitorInformationSystem.PointOfInterest.FoodStand.FoodStandLoadPort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DefaultFilterFoodStandsUseCase implements FilterFoodStandsUseCase {
    private final FoodStandLoadPort foodStandLoadPort;

    public DefaultFilterFoodStandsUseCase(FoodStandLoadPort foodStandLoadPort) {
        this.foodStandLoadPort = foodStandLoadPort;
    }

    @Override
    public List<FoodStand> filterFoodStands(Optional<String> name, Optional<Boolean> open) {
        return foodStandLoadPort.loadFilteredFoodStands(name, open);
    }
}
