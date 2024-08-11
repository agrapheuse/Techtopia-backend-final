package be.kdg.prog6.parkplanning.domain;

import java.time.LocalDate;

public class Forecast {
    private LocalDate date;
    private String weatherType;
    private String temperatureType;
    private boolean nationWide;
    private int predictedVisitors;

    public Forecast(LocalDate date, String weatherType, String temperatureType, boolean nationWide, int predictedVisitors) {
        this.date = date;
        this.weatherType = weatherType;
        this.temperatureType = temperatureType;
        this.nationWide = nationWide;
        this.predictedVisitors = predictedVisitors;
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

    public boolean isNationWide() {
        return nationWide;
    }

    public void setNationWide(boolean nationWide) {
        this.nationWide = nationWide;
    }

    public int getPredictedVisitors() {
        return predictedVisitors;
    }

    public void setPredictedVisitors(int predictedVisitors) {
        this.predictedVisitors = predictedVisitors;
    }

    @Override
    public String toString() {
        return "Forecast{" +
                "date=" + date +
                ", weatherType='" + weatherType + '\'' +
                ", temperatureType='" + temperatureType + '\'' +
                ", nationWide=" + nationWide +
                ", predictedVisitors=" + predictedVisitors +
                '}';
    }
}
