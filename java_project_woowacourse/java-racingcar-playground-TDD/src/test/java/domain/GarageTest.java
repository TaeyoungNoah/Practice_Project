package domain;


import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class GarageTest {

    Garage garage = new Garage();

    @Test
    void 차량추가() {
        // given
        Car car1 = new Car("test1");
        Car car2 = new Car("test2");
        // when
        garage.addCar(car1);
        garage.addCar(car2);
        List<Car> cars = garage.getCars();
        //then
        Assertions.assertThat(car1).isEqualTo(cars.get(0));
        Assertions.assertThat(car2).isEqualTo(cars.get(1));
    }
}
