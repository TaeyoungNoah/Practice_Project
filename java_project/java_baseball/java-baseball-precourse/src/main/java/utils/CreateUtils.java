package utils;

public class CreateUtils {
    // 컴퓨터 숫자 만들기 & 저장
    public void creatComputerNum() {
        final int START_INCLUSIVE = 1;
        final int END_INCLUSIVE = 9;
        final int COMPUTER_NUMBER_LEN = 3;

        int[] computerNumber = new int[COMPUTER_NUMBER_LEN];
        int count = 0;
        while (count < 3) {
            int number = RandomUtils.nextInt(START_INCLUSIVE, END_INCLUSIVE);
            if (checkOverlap(computerNumber, count, number)) {
                computerNumber[count] = number;
                count++;
            }
        }
        DataUtils.setComputerNum(computerNumber);
    }

    // 컴퓨터 숫자를 만드는 과정 중 숫자의 중복을 허용하지 않기 위해 중복을 검사
    private boolean checkOverlap(int[] numList, int index, int number) {
        for (int i = 0; i < index; i++) {
            if (numList[i] == number) {
                return false;
            }
        }
        return true;
    }

    public void createUserNum(String userInput) throws IllegalArgumentException {
        String[] userInputArr = isUserInputDigit(userInput).split("");
        DataUtils.setUserNum(userInputArr);
    }

    // 문자 입력에 대한 예외처리
    private String isUserInputDigit(String userInput) throws IllegalArgumentException {
        try {
            Integer.parseInt(userInput);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
        return isUserInputLength(userInput);
    }

    // 3자리 이상,이하 입력에 대한 예외처리
    private String isUserInputLength(String userInput) throws IllegalArgumentException {
        if(userInput.length() != 3) {
            throw new IllegalArgumentException();
        }
        return isUserInputDiffDigits(userInput);
    }

    // 중복값 입력에 대한 예외처리
    private String isUserInputDiffDigits(String userInput) throws IllegalArgumentException {
        if(userInput.charAt(0) == userInput.charAt(1)
                || userInput.charAt(1) == userInput.charAt(2)
                || userInput.charAt(0) == userInput.charAt(2)) {
            throw new IllegalArgumentException();
        }
        return isValidNumber(userInput);
    }

    // 0 입력에 대한 예외처리
    private String isValidNumber(String userInput) throws IllegalArgumentException {
        if(userInput.contains("0")) {
            throw new IllegalArgumentException();
        }
        return userInput;
    }
}
