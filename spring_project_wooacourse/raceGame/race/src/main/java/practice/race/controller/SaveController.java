package practice.race.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import practice.race.service.SaveService;

@Controller
public class SaveController {
    SaveService saveService;
    @Autowired
    public SaveController(SaveService saveService) {
        this.saveService = saveService;
    }

    @GetMapping("/carracing/main/newgame")
    public String newGame(){
        return "/carracing/form";
    }

    @PostMapping("/carracing/main/newgame")
    public String saveData(@RequestParam String userInputCarName,
                           @RequestParam String maxTryTimes,
                           RedirectAttributes redirectAttributes){
        try{
            saveService.joinParticipants(userInputCarName);
            saveService.saveMaxTryTimes(maxTryTimes);
        } catch(IllegalStateException e){
            redirectAttributes.addAttribute("status",true);
            redirectAttributes.addAttribute("errorMsg",e.getMessage());
            return "redirect:/carracing/error";
        }
        return "redirect:/carracing/progress";
    }

    @GetMapping("/carracing/reset")
    public String reset(Model model){
        saveService.resetGame();
        return "redirect:/carracing/main";
    }

    @GetMapping("/carracing/error")
    public String errorPage(){
        saveService.resetGame();
        return "/carracing/error";
    }
}
