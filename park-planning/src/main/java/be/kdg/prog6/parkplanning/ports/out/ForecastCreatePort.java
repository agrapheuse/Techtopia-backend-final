package be.kdg.prog6.parkplanning.ports.out;

import be.kdg.prog6.parkplanning.domain.Forecast;

public interface ForecastCreatePort {
    void createForecast(Forecast forecast);
}
