import service.ResultService;
import utils.CreateUtils;

import java.util.List;
import java.util.Scanner;

public class Game {

    private List<Integer> computerNum;
    private Scanner scanner = new Scanner(System.in);

    public void initialize() {
        this.computerNum = CreateUtils.createComputerNum();
        getUserInput(scanner);
    }

    public void getUserInput(Scanner scanner) {
        System.out.print("숫자를 입력하세요");
        String userInput = scanner.next();
        try {
            compareNum(this.computerNum, CreateUtils.createUserNum(userInput), scanner);
        } catch (IllegalStateException e) {
            System.out.println(e.getMessage());
            getUserInput(scanner);
        }
    }

    public void compareNum(List<Integer> computerNum, List<Integer> userNum, Scanner scanner) {
        ResultService resultService = new ResultService();
        String result = resultService.getResult(computerNum, userNum);
        if (result.equals("3스트라이크")) {
            System.out.println(result);
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임종료");
            checkUserRetry(scanner);
            return;
        }
        System.out.println(result);
        getUserInput(scanner);
    }

    public void checkUserRetry(Scanner scanner) {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String userInputRetry = scanner.next();
        if (userInputRetry.equals("1")) {
            initialize();
            return;
        }
        if (userInputRetry.equals("2")) {
            return;
        }
        System.out.println("[ERROR] 1 또는 2 를 입력하세요.");
        checkUserRetry(scanner);
    }
}
