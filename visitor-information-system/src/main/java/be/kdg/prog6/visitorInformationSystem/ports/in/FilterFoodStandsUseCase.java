package be.kdg.prog6.visitorInformationSystem.ports.in;

import be.kdg.prog6.visitorInformationSystem.domain.FoodStand;

import java.util.List;
import java.util.Optional;

public interface FilterFoodStandsUseCase {
    List<FoodStand> filterFoodStands(Optional<String> name, Optional<Boolean> open);
}
