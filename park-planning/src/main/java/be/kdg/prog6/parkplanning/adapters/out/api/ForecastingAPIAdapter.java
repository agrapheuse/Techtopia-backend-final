package be.kdg.prog6.parkplanning.adapters.out.api;

import be.kdg.prog6.parkplanning.domain.HolidayForecast;
import be.kdg.prog6.parkplanning.domain.PeopleForecast;
import be.kdg.prog6.parkplanning.domain.WeatherForecast;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "forecastingService", url = "http://localhost:9090")
public interface ForecastingAPIAdapter {
    @GetMapping("/weather/date/{date}")
    WeatherForecast loadTodaysWeatherForecast(@PathVariable String date);

    @GetMapping("/holidays/date/{date}")
    HolidayForecast loadTodaysHolidayForecast(@PathVariable String date);

    @GetMapping("/forecast/date/{date}")
    PeopleForecast loadTodaysPeopleForecast(@PathVariable String date);
}
