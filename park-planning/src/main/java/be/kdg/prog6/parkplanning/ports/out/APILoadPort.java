package be.kdg.prog6.parkplanning.ports.out;

import be.kdg.prog6.parkplanning.domain.HolidayForecast;
import be.kdg.prog6.parkplanning.domain.PeopleForecast;
import be.kdg.prog6.parkplanning.domain.WeatherForecast;

public interface APILoadPort {
    WeatherForecast getWeatherForecast();
    HolidayForecast getHolidayForecast();
    PeopleForecast getPeopleForecast();
}
