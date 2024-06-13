package be.kdg.prog6.visitorInformationSystem.PointOfInterest.FoodStand.showFiltered;

import be.kdg.prog6.visitorInformationSystem.PointOfInterest.FoodStand.FoodStand;

import java.util.List;
import java.util.Optional;

public interface FilterFoodStandsUseCase {
    List<FoodStand> filterFoodStands(Optional<String> name, Optional<Boolean> open);
}
