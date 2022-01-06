package utils;

import domain.Car;
import domain.Garage;

import java.util.List;

public class ResultUtils {

    // ------------------ 게임 결과 (1트) ------------------
    public static void printResultOneTry(List<Car> cars) {
        for (Car car : cars) {
            System.out.println(car.getCarName() + " : " + car.getProcessString());
        }
        System.out.println();
    }

    // ------------------ 게임 결과 (최종) ------------------
    public static void printWinners(List<Car> winners) {
        int winnerNum = winners.size();
        for (int i = 0; i < winnerNum - 1; i++) {
            System.out.print(winners.get(i).getCarName() + ", ");
        }
        System.out.println(winners.get(winnerNum - 1).getCarName() + " 가 최종 우승했습니다.");
    }
}
