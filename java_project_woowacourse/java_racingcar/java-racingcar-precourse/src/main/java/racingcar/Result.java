package racingcar;

import utils.DataUtils;

public class Result {
    DataUtils dataUtils=new DataUtils();
    static int maxPosition;
    static String raceWinner="";

    // 레이스 시작 후 각 Car 객체를 움직이는 메서드
    public void doRace(){
        for(Car i:dataUtils.getParticipantArr()){
            i.checkAdvance();
        }
        printResult();
    }

    // 레이스 1회마다 그 결과를 출력하는 메서드
    public void printResult(){
        for(Car i:dataUtils.getParticipantArr()){
            System.out.println(i.getName()+" : "+i.printProgress());
        }
        System.out.println("");
    }

    // 승자를 최종 우승자에 저장하는 메서드
    public void getMaxPosition(){
        for(Car i:dataUtils.getParticipantArr()){
            if(i.getPosition()>maxPosition){
                maxPosition=i.getPosition();
            }
        }
    }
    public void getWinner(){
        for(Car i:dataUtils.getParticipantArr()){
            if(i.getPosition()==maxPosition){
                whoIsWinner(i);
            }
        }
    }
    public void whoIsWinner(Car car){
        if(raceWinner.equals("")){
            raceWinner+=car.getName();
            return;
        }
        raceWinner+=(", "+car.getName());
    }
}

