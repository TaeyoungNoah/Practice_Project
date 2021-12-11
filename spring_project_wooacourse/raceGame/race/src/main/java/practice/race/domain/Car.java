package practice.race.domain;


import lombok.Getter;
import lombok.Setter;
import practice.race.utils.RandomUtils;

@Getter @Setter
public class Car {
    private String name;
    private int progressNum=0;
    private String progressString="";

    public Car(String name) {
        this.name = name;
    }

    public void doRace(){
        final int START_INCLUSIVE=0;
        final int END_INCLUSIVE=9;
        int carRandomNum = RandomUtils.nextInt(START_INCLUSIVE, END_INCLUSIVE);
        if(carRandomNum>=4){
            this.progressString+="-";
            this.progressNum+=1;
        }
    }

}
