package subway.controller;

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
            addLine();
            return;
        }
        if(userInput.equals("2")){
            delLine();
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
    // 1. 역 등록
    public void addLine(){
        System.out.println("1");
    }
    // 2. 역 삭제
    public void delLine(){
        System.out.println("2");
    }
    // 3. 역 조회
    public void lookUpLine(){
        System.out.println("3");
    }
    // B. 돌아가기
    public void goBack(){
        System.out.println("B");
    }
}
