package be.kdg.prog6.visitorInformationSystem.adapters.in.web;

import be.kdg.prog6.visitorInformationSystem.domain.PointOfInterest;
import be.kdg.prog6.visitorInformationSystem.ports.in.ShowAllPOIUseCase;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/pointOfInterest")
public class PointOfInterestController {
    private final ShowAllPOIUseCase showAllPOIUseCase;

    public PointOfInterestController(ShowAllPOIUseCase showAllPOIUseCase) {
        this.showAllPOIUseCase = showAllPOIUseCase;
    }

    @GetMapping("")
    public List<PointOfInterest> getAttractions(
            @RequestParam Optional<String> name,
            @RequestParam Optional<Boolean> open
    ) {
        if (name.isPresent() || open.isPresent()) {
            return null;
        } else {
            return showAllPOIUseCase.showAllPointOfInterests();
        }
    }
}
