package subway.view;

import subway.controller.LineManagement;
import subway.controller.PrintAllLines;
import subway.controller.SectionManagement;
import subway.controller.StationManagement;
import subway.model.Line;
import subway.model.LineRepository;
import subway.model.Station;
import subway.model.StationRepository;
import java.util.Scanner;

public class ProcessProgram {
    public Scanner scanner;

    public ProcessProgram(Scanner scanner){
        this.scanner=scanner;
    }
    // 초기화면
    public void initialize(){
        System.out.println("## 메인화면");
        System.out.println("1. 역 관리");
        System.out.println("2. 노선 관리");
        System.out.println("3. 구간 관리");
        System.out.println("4. 지하철 노선도 출력");
        System.out.println("Q. 종료");
        System.out.println("");
        getUserInputUI();
    }
    // 기본 노선 & 역 저장
    public void initializeStation(){
        String[] initializeStationArr = {"교대역","강남역","역삼역","남부터미널역","양재역","양재시민의숲역","매봉역"};
        for(String i : initializeStationArr){
            Station station=new Station(i);
            StationRepository.addStation(station);
        }
    }
    // 기본 노선 저장
    public void initializeLine(){
        String[] initializeLineArr = {"2호선","3호선","신분당선"};
        for(String i : initializeLineArr) {
            Line line = new Line(i);
            LineRepository.addLine(line);
        }
    }

    // 사용자의 입력을 유도하는 UI
    public void getUserInputUI() {
        String userInput;
        System.out.println("## 원하는 기능을 선택하세요.");
        userInput = scanner.next();
        selectMenu(userInput);
    }

    public void selectMenu(String userInput){
        if(userInput.equals("1")){
            stationManagementUI();
            return;
        }
        if(userInput.equals("2")){
            lineManagementUI();
            return;
        }
        if(userInput.equals("3")){
            sectionManagementUI();
            return;
        }
        if(userInput.equals("4")){
            printAllLinesUI();
            return;
        }
        if(userInput.equals("Q")){
            System.out.println("[INFO] 프로그램을 종료합니다.");
            System.exit(0);
        }
        System.out.println("[ERROR] 선택할 수 없는 기능입니다.");
        System.out.println("");
        getUserInputUI();
    }
    // 1. 역 관리 메서드
    public void stationManagementUI(){
        new StationManagement(scanner).initialize();
        initialize();
    }

    // 2. 노선 관리 메서드
    public void lineManagementUI(){
        new LineManagement(scanner).initialize();
        initialize();
    }

    // 3. 구간 관리 메서드
    public void sectionManagementUI(){
        new SectionManagement(scanner).initialize();
        initialize();
    }

    // 4. 지하철 노선도 출력
    public void printAllLinesUI(){
        new PrintAllLines(scanner).printAll();
        initialize();
    }
}
