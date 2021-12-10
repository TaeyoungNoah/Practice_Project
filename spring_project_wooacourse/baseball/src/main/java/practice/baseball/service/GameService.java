package practice.baseball.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import practice.baseball.domain.DataRepository;

@Service
public class GameService {
    private  DataRepository dataRepository;
    @Autowired
    public GameService(DataRepository dataRepository) {
        this.dataRepository = dataRepository;
    }

    private final int NUM_LEN=3;


    public void countBallAndStrike(){
        int[] computerNum = dataRepository.getComputerNum();
        int[] userNum = dataRepository.getUserNum();
        int ball=0;
        for(int i=0; i<NUM_LEN; i++){
            for(int j=0; j<NUM_LEN; j++){
                if(computerNum[i]==userNum[j]){
                    ball+=1;
                }
            }
        }
        ball=ball-countStrike();
        dataRepository.setBall(ball);
    }

    public int countStrike(){
        int[] computerNum = dataRepository.getComputerNum();
        int[] userNum = dataRepository.getUserNum();
        int strike=0;
        for(int i=0; i<NUM_LEN; i++) {
            if(computerNum[i]==userNum[i]){
                strike+=1;
            }
        }
        dataRepository.setStrike(strike);
        return strike;
    }

    public void resetGame(){
        dataRepository.resetComputerNum();
    }

    public int getBallCount(){
        return dataRepository.getBall();
    }

    public int getStrikeCount(){
        return dataRepository.getStrike();
    }
}
