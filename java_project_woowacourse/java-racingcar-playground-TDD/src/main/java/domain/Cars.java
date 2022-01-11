package domain;

import java.util.ArrayList;
import java.util.List;

public class Cars {
    private List<Car> carList;

    public Cars(List<Car> carList) {
        this.carList = carList;
    }

    public int getMaxPosition() {
        int maxPosition=0;
        for (Car car : carList) {
            if(car.getPosition()>maxPosition) {
                maxPosition=car.getPosition();
            }
        }
        return maxPosition;
    }

    public List<String> getWinnersStringArr() {
        List<String> winnersName = new ArrayList<>();
        int maxPosition = getMaxPosition();
        for (Car car : carList) {
            if (car.getPosition() == maxPosition){
                winnersName.add(car.getName());
            }
        }
        return winnersName;
    }
}
