package domain;

import java.util.List;

public class Garage {
    private List<Car> cars;
    private int tryTimes;

    public Garage(List<Car> cars, int tryTimes) {
        this.cars = cars;
        this.tryTimes = tryTimes;
    }
}
