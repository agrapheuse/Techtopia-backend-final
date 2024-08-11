package be.kdg.prog6.parkplanning.core;

import be.kdg.prog6.parkplanning.domain.Forecast;
import be.kdg.prog6.parkplanning.domain.HolidayForecast;
import be.kdg.prog6.parkplanning.domain.PeopleForecast;
import be.kdg.prog6.parkplanning.domain.WeatherForecast;
import be.kdg.prog6.parkplanning.ports.in.CallForecastingAPIUseCase;
import be.kdg.prog6.parkplanning.ports.out.APILoadPort;
import be.kdg.prog6.parkplanning.ports.out.ForecastCreatePort;
import be.kdg.prog6.parkplanning.ports.out.ForecastLoadPort;
import be.kdg.prog6.parkplanning.ports.out.ForecastUpdatePort;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class DefaultCallForecastingAPIUseCase implements CallForecastingAPIUseCase {
    public static final Logger log = LoggerFactory.getLogger(DefaultCallForecastingAPIUseCase.class);

    private final ForecastLoadPort forecastLoadPort;
    private final ForecastUpdatePort forecastUpdatePort;
    private final ForecastCreatePort forecastCreatePort;
    private final APILoadPort APILoadPort;

    public DefaultCallForecastingAPIUseCase(ForecastLoadPort forecastLoadPort, ForecastUpdatePort forecastUpdatePort, ForecastCreatePort forecastCreatePort, APILoadPort APILoadPort) {
        this.forecastLoadPort = forecastLoadPort;
        this.forecastUpdatePort = forecastUpdatePort;
        this.forecastCreatePort = forecastCreatePort;
        this.APILoadPort = APILoadPort;
    }

    @Override
    @Scheduled(fixedRate = 10000)
    public void callAPI() {
        log.info("call api use case called");

        Forecast forecast = forecastLoadPort.getForecast(LocalDate.now());

        WeatherForecast weatherForecast = APILoadPort.getWeatherForecast();
        HolidayForecast holidayForecast = APILoadPort.getHolidayForecast();
        PeopleForecast peopleForecast = APILoadPort.getPeopleForecast();

        if (forecast != null) {
            updateForecast(forecast, weatherForecast, holidayForecast, peopleForecast);
            forecastUpdatePort.updateForecast(forecast);
        } else {

            forecast = new Forecast(
                    LocalDate.now(),
                    weatherForecast.getWeatherType(),
                    weatherForecast.getTemperatureType(),
                    holidayForecast.isNationWide(),
                    peopleForecast.getPredictedVisitors()
            );
            forecastCreatePort.createForecast(forecast);
        }
    }

    private void updateForecast(Forecast forecast, WeatherForecast weatherForecast,
                                HolidayForecast holidayForecast, PeopleForecast peopleForecast) {
        forecast.setTemperatureType(
                forecast.getTemperatureType() != null ? forecast.getTemperatureType() : weatherForecast.getTemperatureType()
        );

        forecast.setWeatherType(
                forecast.getWeatherType() != null ? forecast.getWeatherType() : weatherForecast.getWeatherType()
        );

        forecast.setPredictedVisitors(
                forecast.getPredictedVisitors() != 0 ? forecast.getPredictedVisitors() : peopleForecast.getPredictedVisitors()
        );

        forecast.setNationWide(holidayForecast.isNationWide());
    }
}
