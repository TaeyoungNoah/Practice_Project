package baseball;

import utils.DataUtils;

public class Result {
    int ball = 0;
    int strike = 0;
    int[] computerNumber = DataUtils.getComputerNum();
    int[] userNumber = DataUtils.getUserNum();

    void countResult() {
        for (int i = 0; i < 3; i++) {
            if (computerNumber[i] == userNumber[i]) {
                strike++;
            }
        }
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (computerNumber[i] == userNumber[j]) {
                    ball++;
                }
            }
        }
        ball -= strike;
    }

    String getResult() {
        String printMSG = "";
        if (ball == 0 && strike == 0) {
            printMSG += "낫싱";
        }
        if (ball != 0) {
            printMSG += ball + "볼 ";
        }
        if (strike != 0) {
            printMSG += strike + "스트라이크 ";
        }
        return printMSG;
    }

    boolean checkResult(){
        if(strike==3){
            return true;
        }
        return false;
    }
}
