import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class SimpleTest {
    @Test
    void test() {
        String a = "123";
        Assertions.assertThat(a.charAt(0)).isEqualTo(1);
    }
}
