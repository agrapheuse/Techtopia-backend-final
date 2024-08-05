package be.kdg.prog6.visitorInformationSystem.adapters.in.web;

import be.kdg.prog6.visitorInformationSystem.domain.Attraction;
import be.kdg.prog6.visitorInformationSystem.ports.in.ShowAllAttractionsUseCase;
import be.kdg.prog6.visitorInformationSystem.ports.in.FilterAttractionUseCase;
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
@RequestMapping("/attractions")
public class AttractionController {
    private final ShowAllAttractionsUseCase showAllAttractionsUseCase;
    private final FilterAttractionUseCase filterAttractionUseCase;

    public static final Logger log = LoggerFactory.getLogger(AttractionController.class);

    public AttractionController(ShowAllAttractionsUseCase showAllAttractionsUseCase, FilterAttractionUseCase filterAttractionUseCase) {
        this.showAllAttractionsUseCase = showAllAttractionsUseCase;
        this.filterAttractionUseCase = filterAttractionUseCase;
    }

    @GetMapping("")
    public ResponseEntity<List<Attraction>> getAttractions(
            @RequestParam Optional<String> name,
            @RequestParam Optional<Boolean> open
    ) {
        log.debug("get all attractions called");
        try {
            List<Attraction> attractions;
            if (name.isPresent() || open.isPresent()) {
                attractions = filterAttractionUseCase.filterAttractions(name.orElse(""), open.orElse(true));
            } else {
                attractions = showAllAttractionsUseCase.showAllAttractions();
            }
            return new ResponseEntity<>(attractions, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
