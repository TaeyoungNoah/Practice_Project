package utils;

import racingcar.Car;

public class DataUtils {
    private static int numberOfParticipant;
    private static Car[] participantArr;
    private static int tryTimes;

    // 몇대의 차가 경주에 참여하는지 데이터를 반환
    public int getNumberOfParticipant(){return numberOfParticipant;}
    // 몇대의 차가 경주에 참여하는지 구하는 메서드
    public void setNumberOfParticipant(int numberOfParticipant){
        this.numberOfParticipant=numberOfParticipant;
        participantArr=new Car[numberOfParticipant];
    }

    // 경주를 진행하는 차 배열을 반환
    public Car[] getParticipantArr(){return participantArr;}
    // 경주를 진행하는 차를 Car 객체로 participantArr 에 저장
    public void setParticipantArr(String[] userInput){
        for(int i=0;i<numberOfParticipant;i++){
            participantArr[i]=new Car(userInput[i]);
        }
    }

    // 시도할 횟수를 반환
    public int getTryTimes(){
        return tryTimes;
    }
    // 시도할 횟수를 저장
    public void setTryTimes(int userInput){
        this.tryTimes=userInput;
    }
}
