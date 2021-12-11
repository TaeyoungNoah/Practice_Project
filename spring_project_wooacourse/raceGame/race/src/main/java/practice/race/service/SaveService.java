package practice.race.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import practice.race.domain.Car;
import practice.race.domain.GameRepository;

import java.util.List;
@Slf4j
@Service
public class SaveService {
    GameRepository gameRepository;
    @Autowired
    public SaveService(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }

    //--------------------------------자동차 저장------------------------------------
    // 사용자의 입력을 통해 자동차 객체 저장
    public void joinParticipants(String userInputCarsRaw) {
        log.info("save car");
        String[] userInputArr = checkValid(userInputCarsRaw);
        List<Car> cars = gameRepository.getCars();
        for(String carName : userInputArr){
            cars.add(new Car(carName));
        }
        gameRepository.setCars(cars);
    }

    // 사용자로 부터 입력받은 자동차 정보 문자열 배열로 임시 생성
    private String[] checkValid(String userInputCarsRaw){
        String userInputCars=userInputCarsRaw.replaceAll(" ",""); // 사용자가 입력한 공백 다 날리기
        String[] userInputArr = userInputCars.split(",");
        isUserInputDigitParticipants(userInputArr);
        return userInputArr;
    }

    // 자동차 이름에 대한 예외처리
    private void isUserInputDigitParticipants(String[] userInputArr) {
        int maxNameLength = 5;
        for (String i : userInputArr) {
            if (i.length() > maxNameLength) {
                throw new IllegalStateException("[자동차 등록 오류] 자동차 이름은 5글자 이하이어야 합니다.") ;
            }
        }
    }

    //--------------------------------시도횟수 저장------------------------------------

    public int saveMaxTryTimes(String userInputTryTimes){
        gameRepository.setMaxTryTimes(Integer.parseInt(isUserInputDigit(userInputTryTimes)));
        log.info("save TryTimes");
        return gameRepository.getMaxTryTimes();
    }

    // 문자 입력에 대한 예외처리
    private String isUserInputDigit(String userInput) throws IllegalStateException {
        try {
            Integer.parseInt(userInput);
        } catch (NumberFormatException e) {
            throw new IllegalStateException("[시도횟수 오류] 숫자만 입력하세요.");
        }
        return isValidNumber(userInput);
    }

    // 0 입력에 대한 예외처리
    private String isValidNumber(String userInput) throws IllegalStateException {
        if(Integer.parseInt(userInput)<1) {
            throw new IllegalStateException("[시도횟수 오류] 1 이상의 값을 입력하세요.");
        }
        return userInput;
    }

    //--------------------------------게임 리셋------------------------------------
    // 게임 리셋
    public void resetGame(){
        gameRepository.clearMemory();
    }
}