package be.kdg.prog6.parkplanning.ports.out;

import be.kdg.prog6.parkplanning.domain.Forecast;

import java.time.LocalDate;

public interface ForecastLoadPort {
    Forecast getForecast(LocalDate date);
}
