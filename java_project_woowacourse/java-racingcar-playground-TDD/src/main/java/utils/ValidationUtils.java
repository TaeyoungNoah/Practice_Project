package utils;

public class ValidationUtils {
    public static boolean checkValidCarName(String[] userInputArr) {
        final int MAX_NAME_LENGTH = 5;
        for (String carName : userInputArr) {
            if (carName.length() > MAX_NAME_LENGTH) {
                System.out.println("[ERROR] 자동차 이름은 5글자를 넘을 수 없습니다.");
                return false;
            }
        }
        return true;
    }


    public static int checkValidTryTimes(String userInput) {
        try {
            int tryTimes = Integer.parseInt(userInput);
            return tryTimes;
        } catch (NumberFormatException e) {
            throw new IllegalStateException("[ERROR] 시도횟수를 숫자로 입력해주세요.");
        }
    }
}
