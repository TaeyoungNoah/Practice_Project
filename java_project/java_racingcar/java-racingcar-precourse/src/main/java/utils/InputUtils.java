package utils;

import racingcar.Car;
import java.util.Scanner;

public class InputUtils {
    private DataUtils dataUtils = new DataUtils();

    // 사용자로부터 경주에 참여할 자동차를 입력받고 저장
    public void getParticipants(Scanner scanner) {
        String userInputRaw = scanner.nextLine();
        String userInput=userInputRaw.replaceAll(" ","");
        String[] userInputArr = userInput.split(",");
        if(isUserInputDigitParticipants(userInput,scanner)){
            dataUtils.setNumberOfParticipant(userInputArr.length);
            dataUtils.setParticipantArr(userInputArr);
            return;
        }
        getParticipants(scanner);
    }

    // 자동차 이름에 대한 예외처리
    private boolean isUserInputDigitParticipants(String userInput, Scanner scanner) {
        int maxNameLength = 5;
        String[] userInputArr = userInput.split(",");
        for (String i : userInputArr) {
            if (i.length() > maxNameLength) {
                System.out.println("[ERROR] 이름은 5자 이하만 가능하다.");
                return false;
            }
        }
        return true;
    }

    // 사용자로부터 시도 횟수를 입력받고 저장
    public void getTryTimes(Scanner scanner) throws IllegalArgumentException {
        try {
            String userInput = scanner.next();
            isUserInputDigitTryTimes(userInput);
            int userInputInt = Integer.parseInt(userInput);
            dataUtils.setTryTimes(userInputInt);
            return;
        }catch (IllegalArgumentException e){
            getTryTimes(scanner);
        }

    }
    // 사용자가 입력한 시도 횟수가 숫자인지 확인하는 메서드
    private String isUserInputDigitTryTimes(String userInput) throws IllegalArgumentException{
        try {
            Integer.parseInt(userInput);
        } catch (NumberFormatException e) {
            System.out.println("[ERROR] 시도 횟수는 숫자여야 한다.");
            throw new IllegalArgumentException();
        }
        return userInput;
    }
}

