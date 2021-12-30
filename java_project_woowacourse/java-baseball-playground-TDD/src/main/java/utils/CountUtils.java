package utils;

import java.util.List;

public class CountUtils {
    public static int countStrike(List<Integer> computerNum, List<Integer> userNum) {
        int strike = 0;
        for (int i = 0; i < computerNum.size(); i++) {
            if (computerNum.get(i) == userNum.get(i)) {
                strike++;
            }
        }
        return strike;
    }

    public static int countBall(List<Integer> computerNum, List<Integer> userNum) {
        int ball=0;
        for (int c = 0; c < computerNum.size(); c++) {
            ball = getBall(computerNum, userNum, ball, c);

        }
        return ball;
    }

    private static int getBall(List<Integer> computerNum, List<Integer> userNum, int ball, int c) {
        for (int u = 0; u < userNum.size(); u++) {
             if(c !=u && computerNum.get(c) == userNum.get(u)){
                 ball++;
             }
        }
        return ball;
    }
}
