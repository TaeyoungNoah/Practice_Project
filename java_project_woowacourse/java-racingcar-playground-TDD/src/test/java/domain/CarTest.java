package domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class CarTest {
    @Test
    void 차량이름_예외처리() {
        // given
        String carName = "loooooong";
        // when & then
        Assertions.assertThatThrownBy(() -> {
            Car test = new Car(carName);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 차량_전진() {
        // given
        Car car = new Car("test");

        // when
        car.moveCar(4);
        String result = car.moveCar(3);

        // then
        Assertions.assertThat(result).isEqualTo("-");
    }
}
