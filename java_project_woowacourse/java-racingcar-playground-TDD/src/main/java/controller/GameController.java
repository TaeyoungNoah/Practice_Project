package controller;

import domain.Car;
import domain.Cars;
import domain.Garage;
import view.InputView;

import java.util.ArrayList;
import java.util.List;

public class GameController {
    Garage garage;
    public void getUserInput() {
        this.garage = new Garage(getCars(), getTryTimes());
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

}
