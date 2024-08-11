package be.kdg.prog6.parkplanning.domain;

import java.time.LocalDate;

public class PeopleForecast {
    private LocalDate date;
    private int predictedVisitors;

    public PeopleForecast(LocalDate date, int predictedVisitors) {
        this.date = date;
        this.predictedVisitors = predictedVisitors;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public int getPredictedVisitors() {
        return predictedVisitors;
    }

    public void setPredictedVisitors(int predictedVisitors) {
        this.predictedVisitors = predictedVisitors;
    }

    @Override
    public String toString() {
        return "PeopleForecast{" +
                "date=" + date +
                ", predictedVisitors=" + predictedVisitors +
                '}';
    }
}
