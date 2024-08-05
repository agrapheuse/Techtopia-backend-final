package be.kdg.prog6.visitorInformationSystem.adapters.out.DBAdapters;

import be.kdg.prog6.visitorInformationSystem.domain.FoodStand;
import be.kdg.prog6.visitorInformationSystem.domain.PointOfInterest;
import be.kdg.prog6.visitorInformationSystem.ports.out.FoodStandLoadPort;
import be.kdg.prog6.visitorInformationSystem.adapters.out.JPAEntities.FoodStandJpaEntity;
import be.kdg.prog6.visitorInformationSystem.adapters.out.repositories.FoodStandJpaRepository;
import be.kdg.prog6.visitorInformationSystem.ports.out.FoodStandUpdatePort;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class FoodStandDBAdapter implements FoodStandLoadPort, FoodStandUpdatePort {
    private final FoodStandJpaRepository foodStandJpaRepository;
    public static final Logger log = LoggerFactory.getLogger(FoodStandDBAdapter.class);

    public FoodStandDBAdapter(FoodStandJpaRepository foodStandJpaRepository) {
        this.foodStandJpaRepository = foodStandJpaRepository;
    }

    public static List<FoodStand> convert(List<FoodStandJpaEntity> foodStands) {
        if (foodStands.isEmpty()) {
            return new ArrayList<>();
        }
        List<FoodStand> result = new ArrayList<>();
        for (FoodStandJpaEntity foodStand : foodStands) {
            result.add(new FoodStand(new PointOfInterest.PointOfInterestUUID(foodStand.getUuid()), foodStand.getName(), foodStand.getDescription(), foodStand.getPosX(), foodStand.getPosY(), foodStand.getPicturePath(), foodStand.isOpen(), foodStand.getMenu()));
        }
        return result;
    }

    @Override
    public List<FoodStand> loadAllFoodStands() {
        log.debug("load all foodStands called in db adapter");
        List<FoodStandJpaEntity> foodStands = foodStandJpaRepository.findAll();
        return convert(foodStands);
    }

    @Override
    public List<FoodStand> loadFilteredFoodStands(String name, boolean open) {
        log.debug("load all foodStands with name {} and open status {} called in db adapter", name, open);
        List<FoodStandJpaEntity> foodStands = foodStandJpaRepository.findByNameContainsIgnoreCaseAndOpenEquals(name, open);
        return convert(foodStands);
    }

    @Override
    public void updateFoodStand(FoodStand foodStand) {
        log.debug("update foodStand {} called in db adapter", foodStand.getUuid().uuid());
        FoodStandJpaEntity foodStandJpa = new FoodStandJpaEntity(
                foodStand.getUuid().uuid(),
                foodStand.getName(),
                foodStand.getDescription(),
                foodStand.getPosX(),
                foodStand.getPosY(),
                foodStand.getPicturePath(),
                foodStand.isOpen(),
                foodStand.getMenu()
        );
        foodStandJpaRepository.save(foodStandJpa);
    }
}
