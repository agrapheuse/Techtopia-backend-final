package be.kdg.prog6.visitorInformationSystem.adapters.out.db.adapters;

import be.kdg.prog6.visitorInformationSystem.adapters.out.db.entity.FoodStandJpaEntity;
import be.kdg.prog6.visitorInformationSystem.adapters.out.db.repository.FoodStandJpaRepository;
import be.kdg.prog6.visitorInformationSystem.domain.FoodStand;
import be.kdg.prog6.visitorInformationSystem.ports.out.FoodStandLoadPort;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class FoodStandDBAdapter implements FoodStandLoadPort {
    private final FoodStandJpaRepository foodStandJpaRepository;

    public FoodStandDBAdapter(FoodStandJpaRepository foodStandJpaRepository) {
        this.foodStandJpaRepository = foodStandJpaRepository;
    }

    private List<FoodStand> convert(List<FoodStandJpaEntity> foodStands) {
        if (foodStands.isEmpty()) {
            return new ArrayList<>();
        }
        List<FoodStand> result = new ArrayList<>();
        for (FoodStandJpaEntity foodStand : foodStands) {
            result.add(new FoodStand(new FoodStand.FoodStandUuid(foodStand.getUuid()), foodStand.getName(), foodStand.getDescription(), foodStand.getPositionX(), foodStand.getPositionY(), foodStand.getPicturePath(), foodStand.isOpen(), foodStand.getMenu()));
        }
        return result;
    }

    @Override
    public List<FoodStand> loadAllFoodStands() {
        List<FoodStandJpaEntity> foodStands = foodStandJpaRepository.findAll();
        return convert(foodStands);
    }

    @Override
    public List<FoodStand> loadFilteredFoodStands(Optional<String> name, Optional<Boolean> open) {
        List<FoodStandJpaEntity> foodStands;
        if (name.isPresent() && open.isPresent()) {
            foodStands = foodStandJpaRepository.findByNameContainsIgnoreCaseAndOpenEquals(name.get(), open.get());
        } else if (name.isPresent()) {
            foodStands = foodStandJpaRepository.findByNameContainsIgnoreCase(name.get());
        } else if (open.isPresent()) {
            foodStands = foodStandJpaRepository.findByOpenEquals(open.get());
        } else {
            foodStands = foodStandJpaRepository.findAll();
        }
        return convert(foodStands);
    }
}
