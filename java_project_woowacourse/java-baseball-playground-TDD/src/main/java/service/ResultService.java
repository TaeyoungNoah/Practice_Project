package service;

import utils.CountUtils;

import java.util.List;

public class ResultService {
    public String getResult(List<Integer> computerNum, List<Integer> userNum) {
        int strike = CountUtils.countStrike(computerNum, userNum);
        int ball = CountUtils.countBall(computerNum, userNum);
        return makeResultString(strike, ball);
    }

    private String makeResultString(int strike, int ball) {
        if (strike == 0 && ball == 0) {
            return "낫싱";
        }
        if (strike == 0) {
            return ball + "볼";
        }
        if (ball == 0) {
            return strike + "스트라이크";
        }
        return ball + "볼 " + strike + "스트라이크";
    }
}
