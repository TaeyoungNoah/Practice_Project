package racingcar;

import utils.DataUtils;

public class Result {
    DataUtils dataUtils=new DataUtils();
    static boolean finishRace=false;
    static String raceWinner="";

    // 레이스 시작 후 각 Car 객체를 움직이는 메서드
    public void doRace(){
        for(Car i:dataUtils.getParticipantArr()){
            i.checkAdvance();
            checkRaceFinish(i);
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

    // 승자가 나왔는지 확인 후, 나왔다면 승자를 최종 우승자에 저장하는 메서드
    public void checkRaceFinish(Car car){
        if(car.getFinish()){
            finishRace=true;
            if(raceWinner.equals("")) {
                raceWinner += car.getName();
                return;
            }
            raceWinner+=(", "+car.getName());
            return;
        }
        return;
    }
}
