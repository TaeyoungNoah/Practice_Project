package view;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InputViewTest {

    InputView inputView = new InputView();

    @Test
    void 사용자입력으로_배열생성() {
        // given
        String test = "mon,tue,wed";
        // when
        String[] result = inputView.makeCarNameArr(test);
        String[] answerArr = {"mon", "tue", "wed"};
        // then
        Assertions.assertThat(result).isEqualTo(answerArr);
    }

    @Test
    void 시도횟수_예외처리() {
        // given
        String testUserInput = "e";
        // when & then
        Assertions.assertThatThrownBy(() -> {
            inputView.checkValidTryTimes(testUserInput);
        }).hasMessage("[ERROR] 시도 횟수를 숫자로 입력하세요.");
    }
}