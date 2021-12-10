package practice.baseball.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import practice.baseball.service.ComputerService;

@Controller
public class ComputerController {
    private ComputerService computerService;
    @Autowired
    public ComputerController(ComputerService computerService) {
        this.computerService = computerService;
    }

    @GetMapping("/baseball/main/newgame")
    public String createComputerNum(){
        computerService.createComputerNum();
        return "redirect:/baseball/form";
    }
}
