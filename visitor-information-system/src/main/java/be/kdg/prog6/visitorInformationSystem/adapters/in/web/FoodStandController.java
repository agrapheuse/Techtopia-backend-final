package be.kdg.prog6.visitorInformationSystem.adapters.in.web;

import be.kdg.prog6.visitorInformationSystem.domain.FoodStand;
import be.kdg.prog6.visitorInformationSystem.ports.in.ShowAllFoodStandsUseCase;
import be.kdg.prog6.visitorInformationSystem.ports.in.FilterFoodStandsUseCase;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    public static final Logger log = LoggerFactory.getLogger(FoodStandController.class);

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
            return filterFoodStandsUseCase.filterFoodStands(name.orElse(""), open.orElse(true));
        } else {
            return showAllFoodStandsUseCase.showAllFoodStands();
        }
    }
}
