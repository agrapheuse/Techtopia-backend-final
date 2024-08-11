package be.kdg.prog6.parkplanning.adapters.out.api;

import be.kdg.prog6.parkplanning.domain.HolidayForecast;
import be.kdg.prog6.parkplanning.domain.PeopleForecast;
import be.kdg.prog6.parkplanning.domain.WeatherForecast;
import be.kdg.prog6.parkplanning.ports.out.APILoadPort;
import io.github.resilience4j.retry.annotation.Retry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Component
public class ResilientForecastCaller implements APILoadPort {
    private final ForecastingAPIAdapter forecastingAPIAdapter;
    private final String todayDate;

    public static final Logger log = LoggerFactory.getLogger(ResilientForecastCaller.class);

    public ResilientForecastCaller(ForecastingAPIAdapter forecastingAPIAdapter) {
        this.forecastingAPIAdapter = forecastingAPIAdapter;

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        this.todayDate = LocalDate.now().format(formatter);
    }

    @Override
    @Retry(name = "getWeatherForecast", fallbackMethod = "weatherFallback")
    public WeatherForecast getWeatherForecast(){
        log.info("get weather forecast called in adapter");
        WeatherForecast weatherForecast = forecastingAPIAdapter.loadTodaysWeatherForecast(this.todayDate);
        log.info(weatherForecast.toString());
        return weatherForecast;
    }

    @Override
    @Retry(name = "getHolidayForecast", fallbackMethod = "holidaysFallback")
    public HolidayForecast getHolidayForecast() {
        log.info("get holiday forecast called in adapter");
        HolidayForecast holidayForecast = forecastingAPIAdapter.loadTodaysHolidayForecast(this.todayDate);
        log.info(holidayForecast.toString());
        return holidayForecast;
    }

    @Override
    @Retry(name = "getPeopleForecast", fallbackMethod = "peopleFallback")
    public PeopleForecast getPeopleForecast() {
        log.info("get people forecast called in adapter");
        PeopleForecast peopleForecast = forecastingAPIAdapter.loadTodaysPeopleForecast(this.todayDate);
        log.info(peopleForecast.toString());
        return peopleForecast;
    }

    //TODO: throw exception when fallback is called
    public WeatherForecast weatherFallback(Throwable throwable){
        log.error("Fallback called");
        return new WeatherForecast(null, null, null);
    }

    //TODO: throw exception when fallback is called
    public HolidayForecast holidaysFallback(Throwable throwable){
        log.error("Fallback called");
        return new HolidayForecast(null, null, false);
    }

    //TODO: throw exception when fallback is called
    public PeopleForecast peopleFallback(Throwable throwable){
        log.error("Fallback called");
        return new PeopleForecast(null, 0);
    }
}
