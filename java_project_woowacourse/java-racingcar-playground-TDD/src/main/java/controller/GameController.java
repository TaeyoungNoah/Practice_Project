package controller;

import domain.Car;
import domain.Cars;
import domain.Garage;
import utils.RandomUtils;
import view.InputView;
import view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class GameController {
    private Garage garage;

    // ------------------ garage 만들기 ------------------
    public void getUserInput() {
        this.garage = new Garage(getCars(), getTryTimes());
        playGame();
    }

    private Cars getCars() {
        try {
            List<Car> carList = new ArrayList<>();
            String[] userInputCarName = InputView.getUserInputCarName();
            for (String s : userInputCarName) {
                carList.add(new Car(s));
            }
            return new Cars(carList);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getCars();
        }
    }

    private int getTryTimes() {
         try {
             return InputView.getUserInputTryTimes();
         } catch (IllegalArgumentException e) {
             System.out.println(e.getMessage());
             return getTryTimes();
         }
    }

    // ------------------ 게임 실행하기 ------------------
    private void playGame() {
        for (int i = 0; i < garage.getTryTimes(); i++) {
            playGameEach();
            System.out.println();
        }
        racingAwards();
    }

    private void playGameEach() {
        List<Car> carList = garage.getCars().getCarList();
        final int START_INCLUSIVE = 0;
        final int END_INCLUSIVE = 9;
        for (Car car : carList) {
            int randomNum = RandomUtils.nextInt(START_INCLUSIVE, END_INCLUSIVE);
            System.out.println(OutputView.makeOneTryPositionString(car.getName(),car.moveCar(randomNum)));
        }
    }

    // ------------------ 우승자 출력하기 ------------------
    private void racingAwards() {
        System.out.println(OutputView.makeWinnersString(garage.getWinners()));
    }
}
