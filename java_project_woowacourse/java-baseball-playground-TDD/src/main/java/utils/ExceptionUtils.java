package utils;

import java.util.ArrayList;
import java.util.List;

public class ExceptionUtils {

    public List<Integer> checkValidInput(String userInputRaw) {
        return isUserInputOnlyInt(userInputRaw);
    }

    private List<Integer> isUserInputOnlyInt(String userInputRaw) {
        try {
            Integer.parseInt(userInputRaw);
        } catch (NumberFormatException e) {
            throw new IllegalStateException("[ERROR] 숫자만 입력하세요.");
        }
        return isUserInputCorrectSize(userInputRaw);
    }

    private List<Integer> isUserInputCorrectSize(String userInputRaw) {
        if (userInputRaw.length() != 3) {
            throw new IllegalStateException("[ERROR] 세자리로 입력하세요.");
        }
        return isUserInputNoOverlap(userInputRaw);
    }

    private List<Integer> isUserInputNoOverlap(String userInputRaw) {
        if (userInputRaw.charAt(0) == userInputRaw.charAt(1)
                || userInputRaw.charAt(0) == userInputRaw.charAt(2)
                || userInputRaw.charAt(1) == userInputRaw.charAt(2)) {
            throw new IllegalStateException("[ERROR] 중복되지 않은 숫자를 입력하세요.");
        }
        return isUserInputNotHasZero(userInputRaw);
    }

    private List<Integer> isUserInputNotHasZero(String userInputRaw) {
        List<Integer> userNum = new ArrayList<>();
        for (int i = 0; i < userInputRaw.length(); i++) {
            int number = Integer.parseInt(String.valueOf(userInputRaw.charAt(i)));
            userNum.add(number);
        }
        if(userNum.contains(0)){
            throw new IllegalStateException("[ERROR] 0을 입력하지 마세요");
        }
        return userNum;
    }
}
