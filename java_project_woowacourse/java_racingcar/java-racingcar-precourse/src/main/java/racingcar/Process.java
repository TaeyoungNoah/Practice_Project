package racingcar;

import utils.DataUtils;
import utils.InputUtils;

import java.util.Scanner;

public class Process {
    Scanner scanner;
    DataUtils dataUtils=new DataUtils();
    InputUtils inputUtils=new InputUtils();
    Result result=new Result();

    Process(Scanner scanner){
        this.scanner=scanner;
    }
    // 프로그램을 시작하는 메서드
    public void initialize(){
        getCar();
    }

    // 사용자로부터 경주에 참여할 자동차 이름을 입력하도록 유도하는 메서드
    public void getCar(){
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        inputUtils.getParticipants(scanner);
        getTryTimes();
    }

    // 사용자로부터 시도 횟수를 입력하도록 유도하는 메서드
    void getTryTimes(){
        System.out.println("시도할 회수는 몇회인가요?");
        inputUtils.getTryTimes(scanner);
        race();
    }

    // 레이스를 시작하는 메서드
    void race(){
        System.out.println("실행 결과");
        for(int i=0;i<dataUtils.getTryTimes();i++)
            result.doRace();
        result.getMaxPosition();
        result.getWinner();
        printWinner();
    }

    // 최종 우승자를 출력하는 메서드
    void printWinner(){
        System.out.println("최종 우승자 : "+result.raceWinner);
    }
}
