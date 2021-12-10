package practice.baseball.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import practice.baseball.service.UserService;

@Controller
public class UserController {
    private UserService userService;
    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/baseball/form")
    public String userForm(){
        return "/baseball/form";
    }

    @PostMapping("/baseball/form")
    public String createUserNum(@RequestParam String userInput, RedirectAttributes redirectAttributes){
        try{
            userService.createUserNum(userInput);
        } catch (IllegalArgumentException e){
            redirectAttributes.addAttribute("status",true);
            redirectAttributes.addAttribute("errorMsg",e.getMessage());
            return "redirect:/baseball/error";
        }
        return "redirect:/baseball/result";
    }

    @GetMapping("/baseball/error")
    public String errorPage(){
        return "/baseball/error";
    }
}
