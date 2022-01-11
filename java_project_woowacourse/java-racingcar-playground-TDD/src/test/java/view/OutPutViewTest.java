package view;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class OutPutViewTest {

    OutputView outputView = new OutputView();

    @Test
    void 한번당출력() {
        // given
        String carName = "test";
        String carPosition = "---";
        // when
        String result = outputView.makeOneTryPositionString(carName,carPosition);
        String answer = "test : ---";
        // then
        Assertions.assertThat(result).isEqualTo(answer);
    }

    @Test
    void 우승자출력() {
        // given
        List<String> winners = new ArrayList<>(Arrays.asList("mon", "tue"));
        // when
        String result = outputView.makeWinnersString(winners);
        String answer = "mon, tue가 최종 우승했습니다.";
        // then
        Assertions.assertThat(result).isEqualTo(answer);
    }
}
