package practice.race.service;

import org.junit.jupiter.api.Test;
import practice.race.domain.GameRepository;

import static org.junit.jupiter.api.Assertions.*;

class ServiceTest {
    GameRepository gameRepository = new GameRepository();
    GameService gameService = new GameService(gameRepository);
    SaveService saveService = new SaveService(gameRepository);
    @Test
    void 결과창보기() {
        String userInputCarsRaw = "as , d, e";
        saveService.joinParticipants(userInputCarsRaw);
        gameService.tryRace();
        System.out.println(gameService.makeProgressResult());
    }

    @Test
    void 입력한시도횟수저장(){

    }
}