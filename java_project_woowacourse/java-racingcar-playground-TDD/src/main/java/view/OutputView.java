package view;

public class OutputView {

    // 1회당 1대의 위차값 출력할 String
    public String makeOneTryPositionString(String carName, String carPosition) {
        return carName + " : " + carPosition;
    }

    public String makeWinnersString(String[] winners) {
        String result = "";
        int maxIndex = winners.length-1;
        for (int i = 0; i < maxIndex; i++) {
            result+=(winners[i]+", ");
        }
        return result + winners[maxIndex] + "가 최종 우승했습니다.";
    }

    //
}
