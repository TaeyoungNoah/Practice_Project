package domain;

public class CarName {
    String name;

    public CarName(String name) {
        final int MAX_NAME_LENGTH=5;
        if (name.length()>MAX_NAME_LENGTH){
            throw new IllegalArgumentException("[ERROR] 자동차 이름은 5글자를 초과할 수 없습니다.");
        }
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
}
