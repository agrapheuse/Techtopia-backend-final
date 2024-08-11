package be.kdg.prog6.parkplanning.domain;

import java.time.LocalDate;

public class WeatherForecast {
    private LocalDate date;
    private String weatherType;
    private String temperatureType;

    public WeatherForecast(LocalDate date, String weatherType, String temperatureType) {
        this.date = date;
        this.weatherType = weatherType;
        this.temperatureType = temperatureType;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getWeatherType() {
        return weatherType;
    }

    public void setWeatherType(String weatherType) {
        this.weatherType = weatherType;
    }

    public String getTemperatureType() {
        return temperatureType;
    }

    public void setTemperatureType(String temperatureType) {
        this.temperatureType = temperatureType;
    }

    @Override
    public String toString() {
        return "WeatherForecast{" +
                "date=" + date +
                ", weatherType='" + weatherType + '\'' +
                ", temperatureType='" + temperatureType + '\'' +
                '}';
    }
}
