package domain;

public class Car {
    CarName name;
    CarPosition position;

    public Car(String name) {
        this.name = new CarName(name);
        this.position = new CarPosition("",0);
    }

    // 테스트용 생성자
    public Car(String name, String positionString, int positionInt) {
        this.name = new CarName(name);
        this.position = new CarPosition(positionString,positionInt);
    }


    public String moveCar(int randomNum) {
        return position.movePosition(randomNum);
    }

    public int getPosition() {
        return position.getPositionInt();
    }

    public String getName() {
        return name.getName();
    }
}
