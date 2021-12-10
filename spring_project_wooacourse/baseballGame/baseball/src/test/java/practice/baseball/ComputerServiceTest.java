package practice.baseball;

import org.junit.jupiter.api.Test;
import practice.baseball.utils.RandomUtils;

public class ComputerServiceTest {
    final int START_INCLUSIVE = 1;
    final int END_INCLUSIVE = 9;
    final int COMPUTER_NUMBER_LEN = 3;
    private int[] computerNum= new int[COMPUTER_NUMBER_LEN];

    @Test
    public void createComputerNum() {
        int count = 0;
        while(count<COMPUTER_NUMBER_LEN){
            int num = RandomUtils.nextInt(START_INCLUSIVE,END_INCLUSIVE);
            if(checkDuplicate(count,num)){
                computerNum[count]=num;
                count+=1;
            }
        }
        for(int i=0; i<3; i++){
            System.out.println(computerNum[i]);
        }
    }

    private boolean checkDuplicate(int count, int num){
        for(int i=0; i<count; i++){
            if(computerNum[i]==num){
                return false;
            }
        }
        return true;
    }
}
