package utils;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class ValidationUtilsTest {

    @Test
    void 자동차이름_검증_실패() {
        // given
        String[] userInputArr = {"qwerqwerqwer","qwer"};
        // when
        boolean result = ValidationUtils.checkValidCarName(userInputArr);
        // then
        Assertions.assertThat(result).isFalse();
    }

    @Test
    void 자동차이름_검증_성공() {
        // given
        String[] userInputArr = {"asd","qwer"};
        // when
        boolean result = ValidationUtils.checkValidCarName(userInputArr);
        // then
        Assertions.assertThat(result).isTrue();
    }

    @Test
    void 시도횟수_검증() {
        // given
        String userInput = "a";
        // when

        // then
        Assertions.assertThatThrownBy(() -> {
            ValidationUtils.checkValidTryTimes(userInput);
        }).hasMessage("[ERROR] 시도횟수를 숫자로 입력해주세요.");
    }
}
