package day01;

import java.time.LocalDate;

public class RunLog {
    private double distance;
    private LocalDate date;

    public RunLog(double distance, LocalDate date) {
        this.distance = distance;
        this.date = date;
    }

    public double getDistance() {
        return distance;
    }

    public LocalDate getDate() {
        return date;
    }
}
