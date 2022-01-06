package test;


import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestMission {

    Calculator calculator = new Calculator();

    @Test
    void 빈문자열() {
        // given
        String test1 = "";
        String test2 = null;
        // when
        int result1 = calculator.splitAndSum(test1);
        int result2 = calculator.splitAndSum(test2);
        // then
        Assertions.assertThat(result1).isEqualTo(0);
        Assertions.assertThat(result2).isEqualTo(0);
    }

    @Test
    void 숫자하나() {
        // given
        String test = "1";
        // when
        int result = calculator.splitAndSum(test);
        // then
        Assertions.assertThat(result).isEqualTo(1);
    }

    @Test
    void 숫자두개() {
        // given
        String test = "1,2";
        // when
        int result = calculator.splitAndSum(test);
        // then
        Assertions.assertThat(result).isEqualTo(3);
    }

    @Test
    void 숫자여러개() {
        // given
        String test = "1,2:3";
        // when
        int result = calculator.splitAndSum(test);
        // then
        Assertions.assertThat(result).isEqualTo(6);
    }

    @Test
    void 커스텀구분자() {
        // given
        String test = ": “//;\n1;2;3";
        // when
        int result = calculator.splitAndSum(test);
        // then
        Assertions.assertThat(result).isEqualTo(6);
    }

    @Test
    void 예외처리() {
        // given
        String test = ": “-1,2,3";
        // when & then
        Assertions.assertThatThrownBy(()-> {
            calculator.splitAndSum(test);
        }).isInstanceOf(RuntimeException.class)
                .hasMessage("[ERROR]");
    }
}