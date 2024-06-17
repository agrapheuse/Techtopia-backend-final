package be.kdg.prog6.visitorInformationSystem.PointOfInterest.FoodStand;

import be.kdg.prog6.visitorInformationSystem.PointOfInterest.FoodStand.showAll.ShowAllFoodStandsUseCase;
import be.kdg.prog6.visitorInformationSystem.PointOfInterest.FoodStand.showFiltered.FilterFoodStandsUseCase;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/foodStands")
public class FoodStandController {
    private final ShowAllFoodStandsUseCase showAllFoodStandsUseCase;
    private final FilterFoodStandsUseCase filterFoodStandsUseCase;

    public FoodStandController(ShowAllFoodStandsUseCase showAllFoodStandsUseCase, FilterFoodStandsUseCase filterFoodStandsUseCase) {
        this.showAllFoodStandsUseCase = showAllFoodStandsUseCase;
        this.filterFoodStandsUseCase = filterFoodStandsUseCase;
    }

    @GetMapping("")
    public List<FoodStand> getFoodStands(
            @RequestParam Optional<String> name,
            @RequestParam Optional<Boolean> open
    ) {
        if (name.isPresent() || open.isPresent()) {
            return filterFoodStandsUseCase.filterFoodStands(name, open);
        } else {
            return showAllFoodStandsUseCase.showAllFoodStands();
        }
    }
}