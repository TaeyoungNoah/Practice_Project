package utils;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class CountUtilsTest {

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
        userNum.add(2);
    }

    @Test
    void 스트라이크_카운트() {
        // when
        int strike = CountUtils.countStrike(computerNum,userNum);
        // then
        Assertions.assertThat(strike).isEqualTo(1);
    }

    @Test
    void 볼_카운트() {
        // when
        int ball = CountUtils.countBall(computerNum,userNum);
        // then
        Assertions.assertThat(ball).isEqualTo(2);
    }
}
