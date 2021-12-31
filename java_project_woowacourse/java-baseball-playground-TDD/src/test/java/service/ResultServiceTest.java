package service;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class ResultServiceTest {
    ResultService resultService = new ResultService();
    List<Integer> computerNum = new ArrayList<>();
    List<Integer> userNum = new ArrayList<>();

    @BeforeEach
    void given() {
        // given(computerNum)
        computerNum.add(1);
        computerNum.add(2);
        computerNum.add(3);
        // given(userNum)
        userNum.add(1);
        userNum.add(3);
        userNum.add(6);
    }

    @Test
    void 출력결과() {
        // when
        String result = resultService.getResult(computerNum, userNum);
        String answer = "1볼 1스트라이크";
        // then
        Assertions.assertThat(result).isEqualTo(answer);
    }
}
