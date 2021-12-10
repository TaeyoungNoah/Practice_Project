package practice.baseball.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import practice.baseball.service.GameService;

@Controller
public class GameController {
    private GameService gameService;
    @Autowired
    public GameController(GameService gameService) {
        this.gameService = gameService;
    }

    @GetMapping("/baseball/main")
    public String initialize(){
        gameService.resetGame();
        return "/baseball/main";
    }

    @GetMapping("/baseball/result")
    public String result(Model model){
        gameService.countBallAndStrike();
        int strike = gameService.getStrikeCount();
        if(checkFinishGame(strike)){
            return "baseball/end";
        }
        int ball = gameService.getBallCount();
        model.addAttribute("strike",strike);
        model.addAttribute("ball",ball);
        return "/baseball/result";
    }

    private boolean checkFinishGame(int strike){
        if(strike==3){
            return true;
        }
        return false;
    }

}
