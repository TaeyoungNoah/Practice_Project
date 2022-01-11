package domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CarsTest {

    Cars cars;

    @BeforeEach
    void initialize() {
        List<Car> carList = new ArrayList<>();
        Car car1 = new Car("mon", "--", 2);
        Car car2 = new Car("tue", "-", 1);
        Car car3 = new Car("wed", "--", 2);
        carList.add(car1);
        carList.add(car2);
        carList.add(car3);
        cars = new Cars(carList);
    }

    @Test
    void 우승자_가려내기_가장멀리간거리() {
        int maxPosition = cars.getMaxPosition();
        Assertions.assertThat(maxPosition).isEqualTo(2);
    }

    @Test
    void 우승자_가려내기_차목록뽑기() {
        List<String> winners = cars.getWinnersStringArr();
        List<String> answer = new ArrayList<>(Arrays.asList("mon","wed"));
        Assertions.assertThat(winners).isEqualTo(answer);
    }

}