package practice.race.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import practice.race.service.GameService;
import practice.race.service.SaveService;

@Controller
public class GameController {
    GameService gameService;
    @Autowired
    public GameController(GameService gameService) {
        this.gameService = gameService;
    }
    // 메인 View
    @GetMapping("/carracing/main")
    public String mainView(){
        return "/carracing/main";
    }

    // 시도
    @GetMapping("/carracing/progress")
    public String racing(Model model){
        if(gameService.checkEndGame()){
            return "redirect:/carracing/result";
        }
        gameService.tryRace();
        model.addAttribute("result",gameService.makeProgressResult());
        return "/carracing/progress";
    }

    // 결과
    @GetMapping("/carracing/result")
    public String result(Model model){
        model.addAttribute("winner",gameService.resultWinner());
        return "/carracing/result";
    }


}
