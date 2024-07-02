package be.kdg.prog6.visitorInformationSystem.ports.out;

import be.kdg.prog6.visitorInformationSystem.domain.FoodStand;

import java.util.List;

public interface FoodStandLoadPort {
    List<FoodStand> loadAllFoodStands();
    List<FoodStand> loadFilteredFoodStands(String name, boolean open);
}
