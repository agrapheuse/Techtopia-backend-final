package be.kdg.prog6.visitorInformationSystem.adapters.in.web;

import be.kdg.prog6.visitorInformationSystem.domain.PointOfInterest;
import be.kdg.prog6.visitorInformationSystem.exceptions.PointOfInterestNotFoundException;
import be.kdg.prog6.visitorInformationSystem.ports.in.FilterPOIUseCase;
import be.kdg.prog6.visitorInformationSystem.ports.in.ShowAllPOIUseCase;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    private final FilterPOIUseCase filterPOIUseCase;
    public static final Logger log = LoggerFactory.getLogger(PointOfInterestController.class);

    public PointOfInterestController(ShowAllPOIUseCase showAllPOIUseCase, FilterPOIUseCase filterPOIUseCase) {
        this.showAllPOIUseCase = showAllPOIUseCase;
        this.filterPOIUseCase = filterPOIUseCase;
    }

    @GetMapping("")
    public ResponseEntity<List<PointOfInterest>> getPointsOfInterest(
            @RequestParam Optional<String> name,
            @RequestParam Optional<Boolean> open
    ) {
        try {
            List<PointOfInterest> pointOfInterests;
            if (name.isPresent() || open.isPresent()) {
                pointOfInterests = filterPOIUseCase.filterPointsOfInterest(name.orElse(""), open.orElse(true));
            } else {
                pointOfInterests = showAllPOIUseCase.showAllPointOfInterests();
            }
            return new ResponseEntity<>(pointOfInterests, HttpStatus.OK);
        } catch (PointOfInterestNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
