package practice.baseball.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import practice.baseball.domain.DataRepository;
import practice.baseball.utils.RandomUtils;

@Service
public class ComputerService {
    private DataRepository dataRepository;
    @Autowired
    public ComputerService(DataRepository dataRepository) {
        this.dataRepository = dataRepository;
    }

    final int START_INCLUSIVE = 1;
    final int END_INCLUSIVE = 9;
    final int COMPUTER_NUMBER_LEN = 3;
    private int[] computerNum= new int[COMPUTER_NUMBER_LEN];

    public void createComputerNum() {
        int count = 0;
        while(count<COMPUTER_NUMBER_LEN){
            int num = RandomUtils.nextInt(START_INCLUSIVE,END_INCLUSIVE);
            if(checkDuplicate(count,num)){
                computerNum[count]=num;
                count+=1;
            }
        }
        dataRepository.setComputerNum(computerNum);
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
