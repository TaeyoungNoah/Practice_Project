package domain;

public class Car {
    private String carName;
    private String processString = "";
    private int processInt = 0;

    // ------------------ 생성자 ------------------
    public Car(String carName) {
        this.carName = carName;
    }

    // ------------------ 전진할지 말지 ------------------
    public void advance(int randomNum) {
        final int STANDARD = 4;
        if (randomNum >= STANDARD) {
            this.processInt++;
            this.processString += "-";
        }
    }

    // ------------------ Getter ------------------
    public String getCarName() {
        return carName;
    }

    public String getProcessString() {
        return processString;
    }

    public int getProcessInt() {
        return processInt;
    }
}
