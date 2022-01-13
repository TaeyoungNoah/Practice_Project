package view;

import java.util.List;

public class OutputView {

    // 1회당 1대의 위차값 출력할 String
    public static String makeOneTryPositionString(String carName, String carPosition) {
        return carName + " : " + carPosition;
    }

    public static String makeWinnersString(List<String> winners) {
        String result = "";
        int maxIndex = winners.size()-1;
        for (int i = 0; i < maxIndex; i++) {
            result+=(winners.get(i)+", ");
        }
        return result + winners.get(maxIndex) + "가 최종 우승했습니다.";
    }

    //
}
