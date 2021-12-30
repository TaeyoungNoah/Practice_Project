package utils;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CreateUtilsTest {
    @Test
    void 컴퓨터_난수_확인() {
        System.out.println(CreateUtils.createComputerNum());
    }
    @Test
    void 사용자입력으로_컬랙션만들기() {
        // given
        String userInput = "123";
        // when
        List<Integer> userNum = CreateUtils.createUserNum(userInput);
        List<Integer> result = new ArrayList<>();
        result.add(1);
        result.add(2);
        result.add(3);
        // then
        Assertions.assertThat(userNum).isEqualTo(result);
    }
}
