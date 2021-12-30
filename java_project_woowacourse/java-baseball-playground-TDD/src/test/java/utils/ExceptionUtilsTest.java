package utils;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class ExceptionUtilsTest {
    ExceptionUtils exceptionUtils = new ExceptionUtils();

    @Test
    void 숫자만입력() {
        // given
        String userInputRaw = "q12";
        // when & then
        Assertions.assertThatThrownBy(() -> {
                    exceptionUtils.checkValidInput(userInputRaw);
                }).isInstanceOf(IllegalStateException.class)
                .hasMessage("[ERROR] 숫자만 입력하세요.");
    }

    @Test
    void 세자리숫자() {
        // given
        String userInputRaw = "14";
        // when & then
        Assertions.assertThatThrownBy(() -> {
                    exceptionUtils.checkValidInput(userInputRaw);
                }).isInstanceOf(IllegalStateException.class)
                .hasMessage("[ERROR] 세자리로 입력하세요.");
    }

    @Test
    void 중복된숫자() {
        // given
        String userInputRaw = "112";
        // when & then
        Assertions.assertThatThrownBy(() -> {
                    exceptionUtils.checkValidInput(userInputRaw);
                }).isInstanceOf(IllegalStateException.class)
                .hasMessage("[ERROR] 중복되지 않은 숫자를 입력하세요.");
    }

    @Test
    void 영입력() {
        // given
        String userInputRaw = "012";
        // when & then
        Assertions.assertThatThrownBy(() -> {
                    exceptionUtils.checkValidInput(userInputRaw);
                }).isInstanceOf(IllegalStateException.class)
                .hasMessage("[ERROR] 0을 입력하지 마세요");
    }
}
