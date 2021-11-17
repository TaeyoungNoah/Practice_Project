package subway.controller;

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
            addSection();
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
    // 1. 역 등록
    public void addSection(){
        System.out.println("1");
    }
    // 2. 역 삭제
    public void delSection(){
        System.out.println("2");
    }
    // B. 돌아가기
    public void goBack(){
        System.out.println("B");
    }
}
