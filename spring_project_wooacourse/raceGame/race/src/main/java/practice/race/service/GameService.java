package practice.race.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import practice.race.domain.Car;
import practice.race.domain.GameRepository;

import java.util.List;

@Service
public class GameService {
    GameRepository gameRepository;
    @Autowired
    public GameService(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }

    public int getTryTime(){
        return gameRepository.getTryTimes();
    }
    //--------------------------------시도 1회 관련------------------------------------
    // 레이스 1번 시도
    public void tryRace(){
        List<Car> cars = gameRepository.getCars();
        for(Car car : cars){
            car.doRace();
        }
        gameRepository.addTryTimes();
    }

    // 레이스를 1번 시행한 결과를 리턴
    public String makeProgressResult(){
        List<Car> cars = gameRepository.getCars();
        String progressResult="";
        for(Car car : cars){
            progressResult+=(car.getName()+": "+car.getProgressString()+"<br/>");
        }
        return progressResult;
    }

    //--------------------------------레이스 종료 관련------------------------------------
    // 레이스가 끝났는지를 확인하는 메서드
    public boolean checkEndGame(){
        if(gameRepository.getTryTimes()==gameRepository.getMaxTryTimes()){
            return true;
        }
        return false;
    }

    // 우승자를 확인하는 메서드
    public String resultWinner(){
        gameRepository.findWinner();
        String winner = gameRepository.getWinner();
        int winnerLength = winner.length();
        return winner.substring(0,winnerLength-3);
    }
}
