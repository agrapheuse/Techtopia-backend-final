package be.kdg.prog6.parkplanning.adapters.out.db.JPAEntities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.time.LocalDate;

@Table(name="forecast")
@Entity
public class ForecastJpaEntity {
    @Id
    private LocalDate date;
    private String weatherType;
    private String temperatureType;
    private boolean nationWide;
    private int predictedVisitors;

    public ForecastJpaEntity(LocalDate date, String weatherType, String temperatureType, boolean nationWide, int predictedVisitors) {
        this.date = date;
        this.weatherType = weatherType;
        this.temperatureType = temperatureType;
        this.nationWide = nationWide;
        this.predictedVisitors = predictedVisitors;
    }

    public ForecastJpaEntity() {

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
}
