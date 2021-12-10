package subway.controller;

import subway.model.Station;
import subway.model.StationRepository;
import subway.view.ProcessProgram;
import java.awt.desktop.SystemEventListener;
import java.util.List;
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
            getUserAddStation();
            return;
        }
        if(userInput.equals("2")){
            getUserDelStation();
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
    // 1. 역 등록 (등록할 역을 사용자로부터 입력받는 메서드)
    public void getUserAddStation(){
        String userInput;
        System.out.println("## 등록할 역을 입력하시오.");
        userInput = scanner.next();
        if(checkUserInputAddStation(userInput)){
            addStation(userInput);
            return;
        }
        System.out.println("[ERROR] 이미 등록되어있는 역입니다.");
        System.out.println("");
        initialize();
    }
    // 1. 역 등록 (사용자로부터 입력받은 역을 객체로 저장하는 메서드)
    private void addStation(String userInput){
        ProcessProgram processProgram=new ProcessProgram(scanner);
        Station newStation = new Station(userInput);
        StationRepository.addStation(newStation);
        System.out.println("[INFO] 지하철 역이 등록되었습니다.");
        System.out.println("");
        processProgram.initialize();
    }
    // 1. 역 등록 (사용자가 입력한 역의 중복을 체크하는 메서드)
    private boolean checkUserInputAddStation(String userInput){
        List<Station> listStation= StationRepository.stations();
        for(Station i : listStation){
            if(i.getName().equals(userInput)){
                return false;
            }
        }
        return true;
    }

    // 2. 역 삭제 (삭제할 역을 사용자로부터 입력받는 메서드)
    public void getUserDelStation(){
        String userInput;
        System.out.println("## 삭제할 역을 입력하시오.");
        userInput = scanner.next();
        if(!checkUserInputAddStation(userInput)){
            delStation(userInput);
            return;
        }
        System.out.println("[ERROR] 존재하지 않는 역입니다.");
        System.out.println("");
        initialize();
    }
    // 2. 역 삭제 (역을 삭제하는 메서드)
    private void delStation(String userInput){
        ProcessProgram processProgram=new ProcessProgram(scanner);
        StationRepository.deleteStation(userInput);
        System.out.println("[INFO] 지하철 역이 삭제되었습니다.");
        System.out.println("");
        processProgram.initialize();
    }
    //2. 역 삭제 (사용자가 입력한 역이 존재하는지 확인하는 메서드) *** 삭제한 역을 노선에서도 삭제하는 부분 구현 필요 ***
    private boolean checkUserInputDelStation(String userInput){
        List<Station> listStation= StationRepository.stations();
        for(Station i : listStation){
            if(i.getName().equals(userInput)){
                return true;
            }
        }
        return false;
    }


    // 3. 역 조회
    public void lookUpStation(){
        ProcessProgram processProgram=new ProcessProgram(scanner);
        List<Station> listStation= StationRepository.stations();
        for(Station i : listStation){
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
