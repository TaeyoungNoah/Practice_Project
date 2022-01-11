package domain;

import java.util.List;

public class Garage {
    private Cars cars;
    private int tryTimes;

    public Garage(Cars cars, int tryTimes) {
        this.cars = cars;
        this.tryTimes = tryTimes;
    }

    public List<String> getWinners() {
        return cars.getWinnersStringArr();
    }
}
