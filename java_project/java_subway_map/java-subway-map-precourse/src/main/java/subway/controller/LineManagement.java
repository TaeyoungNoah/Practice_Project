package subway.controller;

import subway.model.Line;
import subway.model.LineRepository;
import subway.model.Station;
import subway.model.StationRepository;
import subway.view.ProcessProgram;

import java.util.List;
import java.util.Scanner;

public class LineManagement {
    public Scanner scanner;
    public LineManagement(Scanner scanner) {
        this.scanner=scanner;
    }
    public void initialize(){
        System.out.println("## 노선 관리 화면");
        System.out.println("1. 노선 등록");
        System.out.println("2. 노선 삭제");
        System.out.println("3. 노선 조회");
        System.out.println("B. 돌아가기");
        System.out.println("");
        getUserInputLine();
    }
    // 사용자의 입력을 유도하는 UI
    private void getUserInputLine() {
        String userInput;
        System.out.println("## 원하는 기능을 선택하세요.");
        userInput = scanner.next();
        selectMenuLine(userInput);
    }

    public void selectMenuLine(String userInput){
        if(userInput.equals("1")){
            getUserAddLine();
            return;
        }
        if(userInput.equals("2")){
            getUserDelLine();
            return;
        }
        if(userInput.equals("3")){
            lookUpLine();
            return;
        }
        if(userInput.equals("B")){
            goBack();
            return;
        }
        System.out.println("[ERROR] 선택할 수 없는 기능입니다.");
        System.out.println("");
        getUserInputLine();
    }

    // 1. 노선 등록 (등록할 노선을 사용자로부터 입력받는 메서드)
    public void getUserAddLine(){
        String userInput;
        System.out.println("## 등록할 노선을 입력하시오.");
        userInput = scanner.next();
        if(checkUserInputAddLine(userInput)){
            addLine(userInput);
            return;
        }
        System.out.println("[ERROR] 이미 등록되어있는 노선입니다.");
        System.out.println("");
        initialize();
    }
    // 1. 노선 등록 (사용자로부터 입력받은 노선을 객체로 저장하는 메서드)
    private void  addLine(String userInput){
        ProcessProgram processProgram=new ProcessProgram(scanner);
        Line newLine = new Line(userInput);
        LineRepository.addLine(newLine);
        System.out.println("[INFO] 지하철 노선이 등록되었습니다.");
        System.out.println("");
        processProgram.initialize();
    }
    // 1. 노선 등록 (사용자가 입력한 노선의 중복을 체크하는 메서드)
    private boolean checkUserInputAddLine(String userInput){
        List<Line> listLine= LineRepository.lines();
        for(Line i : listLine){
            if(i.getName().equals(userInput)){
                return false;
            }
        }
        return true;
    }

    // 2. 노선 삭제 (삭제할 노선을 사용자로부터 입력받는 메서드)
    public void getUserDelLine(){
        String userInput;
        System.out.println("## 삭제할 노선을 입력하시오.");
        userInput = scanner.next();
        if(checkUserInputDelLine(userInput)){
            delLine(userInput);
            return;
        }
        System.out.println("[ERROR] 존재하지 않는 노선입니다.");
        System.out.println("");
        initialize();
    }
    // 2. 노선 삭제 (노선을 삭제하는 메서드)
    private void delLine(String userInput){
        ProcessProgram processProgram=new ProcessProgram(scanner);
        LineRepository.deleteLineByName(userInput);
        System.out.println("[INFO] 지하철 노선이 삭제되었습니다.");
        System.out.println("");
        processProgram.initialize();
    }
    //2. 노선 삭제 (사용자가 입력한 노선이 존재하는지 확인하는 메서드)
    private boolean checkUserInputDelLine(String userInput){
        List<Line> listLine= LineRepository.lines();
        for(Line i : listLine){
            if(i.getName().equals(userInput)){
                return true;
            }
        }
        return false;
    }
    // 3. 노선 조회
    public void lookUpLine(){
        ProcessProgram processProgram=new ProcessProgram(scanner);
        List<Line> listLine= LineRepository.lines();
        for(Line i : listLine){
            System.out.println("[INFO] "+i.getName());
        }
        processProgram.initialize();
    }
    // B. 돌아가기
    public void goBack(){
        ProcessProgram processProgram=new ProcessProgram(scanner);
        processProgram.initialize();
    }
}
