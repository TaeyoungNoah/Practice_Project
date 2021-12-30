package utils;

import java.util.ArrayList;
import java.util.List;

public class CreateUtils {
    public static List<Integer> createComputerNum() {
        List<Integer> computerNum = new ArrayList<>();
        final int START_INCLUSIVE = 1;
        final int END_INCLUSIVE = 9;
        final int MAX_SIZE = 3;
        while (computerNum.size() < MAX_SIZE) {
            int number = RandomUtils.nextInt(START_INCLUSIVE, END_INCLUSIVE);
            if(!computerNum.contains(number)) {
                computerNum.add(number);
            }
        }
        return computerNum;
    }

    public static List<Integer> createUserNum(String userInput) {
        ExceptionUtils exceptionUtils = new ExceptionUtils();
        return exceptionUtils.checkValidInput(userInput);
    }
}
