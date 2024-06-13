package be.kdg.prog6.visitorInformationSystem.ports.in;

import be.kdg.prog6.visitorInformationSystem.domain.FoodStand;

import java.util.List;

public interface ShowAllFoodStandsUseCase {
    List<FoodStand> showAllFoodStands();
}
