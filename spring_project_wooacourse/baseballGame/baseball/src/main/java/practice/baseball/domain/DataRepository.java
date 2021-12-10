package practice.baseball.domain;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Repository;

@Repository
@Getter @Setter
public class DataRepository {
    private int[] computerNum;
    private int[] userNum;
    private int strike;
    private int ball;

    public void resetComputerNum(){
        this.computerNum = new int[3];
    }
}
