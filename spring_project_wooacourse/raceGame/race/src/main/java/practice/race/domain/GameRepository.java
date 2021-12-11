package practice.race.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Repository
@Getter @Setter
public class GameRepository {
    private List<Car> cars=new ArrayList<>();
    private int maxTryTimes;
    private int tryTimes=0;
    private String winner="";



    //--------------------------------실제 시도 횟수 증가------------------------------------
    public void addTryTimes(){
        this.tryTimes+=1;
    }

    //--------------------------------우승자 찾기------------------------------------
    // 우승자 찾기
    public void findWinner(){
        int maxProgress = findMaxProgress();
        for(Car car : cars){
            if(car.getProgressNum()==maxProgress){
                this.winner+=(car.getName()+" , ");
            }
        }
    }

    // 우승자가 얼만큼 갔는지 알아보는 메서드
    private int findMaxProgress(){
        int maxProgress=0;
        for(Car car : cars){
            if(car.getProgressNum()>maxProgress){
                maxProgress=car.getProgressNum();
            }
        }
        return maxProgress;
    }

    // 게임 리셋을 위한 레포지토리 초기화
    public void clearMemory(){
        this.cars = new ArrayList<>();
        this.maxTryTimes=0;
        this.tryTimes=0;
        this.winner="";
    }
}
