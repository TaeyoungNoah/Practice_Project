package domain;

import utils.RandomUtils;

import java.util.ArrayList;
import java.util.List;

public class Garage {
    private List<Car> cars = new ArrayList<>();
    private int tryTimes;

    // ------------------ 차량 등록 ------------------

    public void addCar(Car car) {
        cars.add(car);
    }


    // ------------------ 게입 진행 (1트) ------------------
    public void advanceCars() {
        final int START_INCLUSIVE = 0;
        final int END_INCLUSIVE = 9;
        for (Car car : cars) {
            car.advance(RandomUtils.nextInt(START_INCLUSIVE, END_INCLUSIVE));
        }
    }

    // ------------------ 우승자 찾기 ------------------
    public List<Car> findWinner() {
        List<Car> winners = new ArrayList<>();
        int maxProcess = findWinnerProcess();
        for (Car car : cars) {
            if (car.getProcessInt() == maxProcess) {
                winners.add(car);
            }
        }
        return winners;
    }

    private int findWinnerProcess() {
        int maxProcess = 0;
        for (Car car : cars) {
            if (car.getProcessInt() > maxProcess) {
                maxProcess = car.getProcessInt();
            }
        }
        return maxProcess;
    }

    // ------------------ Getter & Setter ------------------

    public List<Car> getCars() {
        return cars;
    }

    public int getTryTimes() {
        return tryTimes;
    }

    public void setTryTimes(int tryTimes) {
        this.tryTimes = tryTimes;
    }
}
