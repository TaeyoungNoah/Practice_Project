package practice.race.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class GameRepositoryTest {

    private GameRepository gameRepository = new GameRepository();
    @Test
    void 저장() {
        String userInputCarsRaw = "as , d, e";
        gameRepository.save(userInputCarsRaw);
        List<Car> cars = gameRepository.getCars();
        for(Car car : cars){
            System.out.println("car.getName() = " + car.getName());
        }
    }

    @Test
    void 예외처리(){
        String userInputCarsRaw = "asasdf , d, e";
        IllegalStateException e = assertThrows(IllegalStateException.class, () -> gameRepository.save(userInputCarsRaw));
        Assertions.assertThat(e.getMessage()).isEqualTo("자동차 이름은 5글자 이하이어야 합니다.");
    }
}