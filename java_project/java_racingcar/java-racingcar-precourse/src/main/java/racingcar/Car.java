package racingcar;

import utils.DataUtils;
import utils.RandomUtils;

public class Car {
    private final String name;
    private int position = 0;
    private String progress="";
    private boolean finishRace=false;
    DataUtils dataUtils=new DataUtils();
    // 객체의 이름 저장하는 생성자
    public Car(String name) {
        this.name = name;
    }

    // 객체의 이름 반환
    public String getName(){return this.name;}

    // 객체가 이동할지 말지 확인 후 결과를 저장하는 메서드
    public void checkAdvance(){
        final int ADVANCE_BORDER=4;
        int number=tryRandom();
        if(number>=ADVANCE_BORDER){
            this.position+=1;
            this.progress+="-";
        }
        checkFinish();
        return;
    }

    // 객체가 이동할지 말지 결정하는 난수를 얻는 메서드
    private int tryRandom(){
        final int START_INCLUSIVE = 0;
        final int END_INCLUSIVE = 9;
        int number = RandomUtils.nextInt(START_INCLUSIVE, END_INCLUSIVE);
        return number;
    }

    // progress 를 반환하는 메서드
    public String printProgress(){return this.progress;}

    // 객체의 완주 여부를 반환하는 메서드
    public boolean getFinish(){return finishRace;}

    // 객체의 완주 여부를 저장하는 메서드
    private void checkFinish(){
        if(this.position== dataUtils.getTryTimes()){
            this.finishRace=true;
            return;
        }
        return;
    }
}
