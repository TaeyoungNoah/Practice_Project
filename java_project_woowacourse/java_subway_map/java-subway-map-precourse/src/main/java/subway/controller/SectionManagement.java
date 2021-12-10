package subway.controller;

import subway.model.Line;
import subway.model.LineRepository;
import subway.model.Station;
import subway.model.StationRepository;
import subway.view.ProcessProgram;

import java.util.List;
import java.util.Scanner;

public class SectionManagement {
    public Scanner scanner;
    public SectionManagement(Scanner scanner) {
        this.scanner=scanner;
    }
    public void initialize() {
        System.out.println("## 역 관리 화면");
        System.out.println("1. 구간 등록");
        System.out.println("2. 구간 삭제");
        System.out.println("B. 돌아가기");
        System.out.println("");
        getUserInputSection();
    }
    // 사용자의 입력을 유도하는 UI
    private void getUserInputSection() {
        String userInput;
        System.out.println("## 원하는 기능을 선택하세요.");
        userInput = scanner.next();
        selectMenuSection(userInput);
    }

    public void selectMenuSection(String userInput){
        if(userInput.equals("1")){
            getUserAddSectionLine();
            return;
        }
        if(userInput.equals("2")){
            delSection();
            return;
        }
        if(userInput.equals("B")){
            goBack();
            return;
        }
        System.out.println("[ERROR] 선택할 수 없는 기능입니다.");
        System.out.println("");
        getUserInputSection();
    }

    // 1. 구간 등록 (등록할 구간의 정보를 사용자로부터 입력받는 메서드)
    public void getUserAddSectionLine(){
        String userInputLine;
        System.out.println("## 등록할 노선을 입력하시오.");
        userInputLine = scanner.next();
        if(checkUserInputValidLine(userInputLine)){
            getUserAddSectionStation(userInputLine);
            return;
        }
        System.out.println("[ERROR] 존재하지 않는 노선입니다.");
        System.out.println("");
        initialize();
    }
    public void getUserAddSectionStation(String userInputLine) {
        String userInputStation;
        Line forStationLine = LineRepository.getLine(userInputLine);
        System.out.println("## 등록할 역을 입력하시오.");
        userInputStation = scanner.next();
        if (checkUserInputValidStation(userInputLine,forStationLine)) {

            return;
        }
        System.out.println("[ERROR] 이미 등록되어있는 역입니다.");
        System.out.println("");
        initialize();
    }
    // 1. 구간 등록 (사용자가 입력한 노선이 있는 노선인지 체크하는 메서드)
    private boolean checkUserInputValidLine(String userInputLine) {
        List<Line> listLine = LineRepository.lines();
        for (Line i : listLine) {
            if (i.getName().equals(userInputLine)) {
                return true;
            }
        }
        return false;
    }
    // 1. 역 등록 (사용자가 입력한 역의 중복을 체크하는 메서드)
    private boolean checkUserInputValidStation(String userInput,Line userInputLine){
        List<Station> stationListInLine= Line.stations();
        for(Station i : stationListInLine){
            if(i.getName().equals(userInput)){
                return false;
            }
        }
        return true;
    }
    // 2. 구간 삭제
    public void delSection(){
        System.out.println("2");
    }
    // B. 돌아가기
    public void goBack(){
        System.out.println("B");
    }
}
