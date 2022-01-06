package domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

public class CarTest {
    @ParameterizedTest
    @ValueSource(ints = {0,1,2,3})
    void 전진하지않음(int num) {
        // given
        Car car = new Car("test");
        // when
        car.advance(num);
        // then
        Assertions.assertThat(car.getProcessInt()).isEqualTo(0);
        Assertions.assertThat(car.getProcessString()).isEqualTo("");
    }

    @ParameterizedTest
    @ValueSource(ints = {4,5,6,7,8,9})
    void 전진함(int num) {
        // given
        Car car = new Car("test");
        // when
        car.advance(num);
        // then
        Assertions.assertThat(car.getProcessInt()).isEqualTo(1);
        Assertions.assertThat(car.getProcessString()).isEqualTo("-");
    }


}
