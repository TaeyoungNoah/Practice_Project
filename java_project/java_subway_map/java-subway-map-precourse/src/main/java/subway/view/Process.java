package subway.view;

import subway.controller.LineManagement;
import subway.controller.PrintAllLines;
import subway.controller.SectionManagement;
import subway.controller.StationManagement;
import subway.model.Station;

import java.util.Scanner;

public class Process {
    public Scanner scanner;

    Process(Scanner scanner){
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
        selectMenu(getUserInputUI());
    }
    // 사용자의 입력을 유도하는 UI
    public String getUserInputUI() {
        String userInput;
        System.out.println("## 원하는 기능을 선택하세요.");
        userInput = scanner.next();
        return userInput;
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
            return;
        }
        System.out.println("[ERROR] 선택할 수 없는 기능입니다.");
        getUserInputUI();
    }
    // 1. 역 관리 메서드
    public void stationManagementUI(){
        StationManagement.initialize();
        initialize();
    }

    // 2. 노선 관리 메서드
    public void lineManagementUI(){
        LineManagement.initialize();
        initialize();
    }

    // 3. 구간 관리 메서드
    public void sectionManagementUI(){
        SectionManagement.initialize();
        initialize();
    }

    // 4. 지하철 노선도 출력
    public void printAllLinesUI(){

        initialize();
    }
}
