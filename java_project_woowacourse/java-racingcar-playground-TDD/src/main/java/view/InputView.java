package view;

import java.util.Scanner;

public class InputView {
    private static Scanner scanner = new Scanner(System.in);

    // 차량 이름 입력받기

    public static String[] getUserInputCarName() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        String userInputRaw = scanner.next();
        return makeCarNameArr(userInputRaw);
    }

    public static String[] makeCarNameArr(String userInputRaw) {
        return userInputRaw.split(",");
    }

    // 시도 횟수 입력받기

    public static int getUserInputTryTimes() {
        System.out.println("시도할 회수는 몇회인가요?");
        String userInputRaw = scanner.next();
        return checkValidTryTimes(userInputRaw);
    }

    public static int checkValidTryTimes(String userInputRaw) {
        try {
            return Integer.parseInt(userInputRaw);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 시도 횟수를 숫자로 입력하세요.");
        }
    }
}
