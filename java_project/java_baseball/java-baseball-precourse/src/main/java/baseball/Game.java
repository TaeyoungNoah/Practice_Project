package baseball;

import utils.CreateUtils;
import utils.DataUtils;
import utils.CreateUtils;
import javax.xml.crypto.Data;
import java.util.Scanner;

public class Game {
    private Scanner scanner;
    private DataUtils newData;
    private CreateUtils newCreate;

    Game(Scanner scanner){
        this.scanner=scanner;
    }

    public void initialize() {
        this.newData=new DataUtils();
        this.newCreate=new CreateUtils();
        newCreate.creatComputerNum();
        getUserInput();
    }
    public void getUserInput(){
        System.out.printf("숫자를 입력해 주세요 : ");
        try {
            String userInput=scanner.next();
            newCreate.createUserNum(userInput);
            printResult();
            return;
        } catch (IllegalArgumentException e) {
            getUserInput();
        }
    }
    public void printResult(){
        Result result = new Result();
        result.countResult();
        if(result.checkResult()){
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            checkRestart();
        }else{
            System.out.println(result.getResult());
            getUserInput();
        }
    }
    public void checkRestart(){
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String restart = scanner.next();

        if(restart.equals("1")) {
            initialize();
        } else if(restart.equals("2")){
            return;
        }

        try {
            new Regame(restart).checkRestart();
        }catch(IllegalArgumentException e) {
            checkRestart();
        }
    }
}
