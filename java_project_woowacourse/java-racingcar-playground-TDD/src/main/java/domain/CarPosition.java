package domain;

public class CarPosition {
    private String positionString;
    private int positionInt;

    public CarPosition(String positionString, int positionInt) {
        this.positionString = positionString;
        this.positionInt = positionInt;
    }

    public int getPositionInt() {
        return positionInt;
    }

    public String movePosition(int randomNum) {
        final int MOVE_FLAG=4;
        if (randomNum>=MOVE_FLAG) {
            this.positionString+="-";
            this.positionInt++;
        }
        return this.positionString;
    }
}
