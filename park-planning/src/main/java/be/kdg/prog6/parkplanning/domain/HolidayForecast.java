package be.kdg.prog6.parkplanning.domain;

import java.time.LocalDate;

public class HolidayForecast {
    private LocalDate startDate;
    private LocalDate endDate;
    private boolean nationWide;

    public HolidayForecast(LocalDate startDate, LocalDate endDate, boolean nationWide) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.nationWide = nationWide;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public boolean isNationWide() {
        return nationWide;
    }

    public void setNationWide(boolean nationWide) {
        this.nationWide = nationWide;
    }

    @Override
    public String toString() {
        return "HolidayForecast{" +
                "startDate=" + startDate +
                ", endDate=" + endDate +
                ", nationWide=" + nationWide +
                '}';
    }
}
