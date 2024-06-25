package be.kdg.prog6.visitorInformationSystem.ports.out;

import be.kdg.prog6.visitorInformationSystem.domain.FoodStand;

import java.util.List;
import java.util.Optional;

public interface FoodStandLoadPort {
    List<FoodStand> loadAllFoodStands();
    List<FoodStand> loadFilteredFoodStands(Optional<String> name, Optional<Boolean> open);
}
