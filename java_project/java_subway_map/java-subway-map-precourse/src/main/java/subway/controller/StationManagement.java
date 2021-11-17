package subway.controller;

import java.awt.desktop.SystemEventListener;
import java.util.Scanner;

public class StationManagement {
    public Scanner scanner;
    public StationManagement(Scanner scanner) {
        this.scanner=scanner;
    }

    public void initialize() {
        System.out.println("## 역 관리 화면");
        System.out.println("1. 역 등록");
        System.out.println("2. 역 삭제");
        System.out.println("3. 역 조회");
        System.out.println("B. 돌아가기");
        System.out.println("");
        getUserInputStation();
    }
    // 사용자의 입력을 유도하는 UI
    private void getUserInputStation() {
        String userInput;
        System.out.println("## 원하는 기능을 선택하세요.");
        userInput = scanner.next();
        selectMenuStation(userInput);
    }

    public void selectMenuStation(String userInput){
        if(userInput.equals("1")){
            addStation();
            return;
        }
        if(userInput.equals("2")){
            delStation();
            return;
        }
        if(userInput.equals("3")){
            lookUpStation();
            return;
        }
        if(userInput.equals("B")){
            goBack();
            return;
        }
        System.out.println("[ERROR] 선택할 수 없는 기능입니다.");
        System.out.println("");
        getUserInputStation();
    }
    // 1. 역 등록
    public void addStation(){
        System.out.println("1");
    }
    // 2. 역 삭제
    public void delStation(){
        System.out.println("2");
    }
    // 3. 역 조회
    public void lookUpStation(){
        System.out.println("3");
    }
    // B. 돌아가기
    public void goBack(){
        System.out.println("B");
    }
}
