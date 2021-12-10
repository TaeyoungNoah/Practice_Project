package practice.baseball.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import practice.baseball.domain.DataRepository;

@Service
public class UserService {
    private DataRepository dataRepository;
    @Autowired
    public UserService(DataRepository dataRepository) {
        this.dataRepository = dataRepository;
    }

    final int USER_NUMBER_LEN = 3;
    private int[] userNum= new int[USER_NUMBER_LEN];

    // 사용자 입력으로 사용자숫자 만들기
    public void createUserNum(String userInput){
        String[] userInputArr = isUserInputLength(userInput).split("");
        for(int i=0; i<USER_NUMBER_LEN; i++){
            userNum[i]=Integer.parseInt(userInputArr[i]);
        }
        dataRepository.setUserNum(userNum);
    }

    // 3자리 이상,이하 입력에 대한 예외처리
    private String isUserInputLength(String userInput) throws IllegalArgumentException {
        if(userInput.length() != 3) {
            throw new IllegalArgumentException("3자리로 입력하세요.");
        }
        return isUserInputDigit(userInput);
    }

    // 문자 입력에 대한 예외처리
    private String isUserInputDigit(String userInput) throws IllegalArgumentException {
        try {
            Integer.parseInt(userInput);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자만 입력하세요.");
        }
        return isUserInputDiffDigits(userInput);
    }



    // 중복값 입력에 대한 예외처리
    private String isUserInputDiffDigits(String userInput) throws IllegalArgumentException {
        if(userInput.charAt(0) == userInput.charAt(1)
                || userInput.charAt(1) == userInput.charAt(2)
                || userInput.charAt(0) == userInput.charAt(2)) {
            throw new IllegalArgumentException("중복되지 않은 숫자로  입력하세요.");
        }
        return isValidNumber(userInput);
    }

    // 0 입력에 대한 예외처리
    private String isValidNumber(String userInput) throws IllegalArgumentException {
        if(userInput.contains("0")) {
            throw new IllegalArgumentException("0을 입력하지 마세요.");
        }
        return userInput;
    }



}
