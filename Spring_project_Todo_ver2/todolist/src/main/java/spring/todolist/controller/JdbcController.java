package spring.todolist.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import spring.todolist.domain.Todo;
import spring.todolist.service.JdbcService;

@Controller
public class JdbcController {
    JdbcService jdbcService;
    @Autowired
    public JdbcController(JdbcService jdbcService) {
        this.jdbcService = jdbcService;
    }

    @GetMapping("/jdbc/test")
    public String test(Todo todo, Model model) {
        jdbcService.test(todo);
        model.addAttribute("todoId",todo.getId());
        model.addAttribute("todoTask",todo.getTask());
        return "/test/test";
    }
}
