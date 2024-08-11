package be.kdg.prog6.parkplanning.adapters.out.db.DBAdapters;

import be.kdg.prog6.parkplanning.adapters.out.db.JPAEntities.ForecastJpaEntity;
import be.kdg.prog6.parkplanning.adapters.out.db.JPARepositories.ForecastJpaRepository;
import be.kdg.prog6.parkplanning.domain.Forecast;
import be.kdg.prog6.parkplanning.ports.out.ForecastCreatePort;
import be.kdg.prog6.parkplanning.ports.out.ForecastLoadPort;
import be.kdg.prog6.parkplanning.ports.out.ForecastUpdatePort;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Optional;

@Repository
public class ForecastDBAdapter implements ForecastLoadPort, ForecastCreatePort, ForecastUpdatePort {
    private final ForecastJpaRepository forecastJpaRepository;

    public ForecastDBAdapter(ForecastJpaRepository forecastJpaRepository) {
        this.forecastJpaRepository = forecastJpaRepository;
    }

    @Override
    public Forecast getForecast(LocalDate date) {
        Optional<ForecastJpaEntity> forecastJpaEntity = forecastJpaRepository.findByDateEquals(date);
        return forecastJpaEntity.map(jpaEntity -> new Forecast(
                jpaEntity.getDate(),
                jpaEntity.getWeatherType(),
                jpaEntity.getTemperatureType(),
                jpaEntity.isNationWide(),
                jpaEntity.getPredictedVisitors()
        )).orElse(null);
    }

    @Override
    public void createForecast(Forecast forecast) {
        ForecastJpaEntity forecastJpaEntity = new ForecastJpaEntity(
                forecast.getDate(),
                forecast.getWeatherType(),
                forecast.getTemperatureType(),
                forecast.isNationWide(),
                forecast.getPredictedVisitors()
        );
        forecastJpaRepository.save(forecastJpaEntity);
    }

    @Override
    public void updateForecast(Forecast forecast) {
        ForecastJpaEntity forecastJpaEntity = new ForecastJpaEntity(
                forecast.getDate(),
                forecast.getWeatherType(),
                forecast.getTemperatureType(),
                forecast.isNationWide(),
                forecast.getPredictedVisitors()
        );
        forecastJpaRepository.save(forecastJpaEntity);
    }
}
