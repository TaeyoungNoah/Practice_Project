package TodoList.TodoListspring.controller;

import TodoList.TodoListspring.domain.Todo;
import TodoList.TodoListspring.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class TodoController {
    private final TodoService todoService;

    @Autowired
    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @GetMapping("/todo/new")
    public String creatForm(){
        return "todo/createTodoForm";
    }

    @PostMapping("/todo/new")
    public String create(TodoForm form){
        Todo todo = new Todo();
        todo.setTask(form.getTask());
        todo.setDeadLine(form.getDeadLine());

        this.todoService.addTodoService(todo);

        return "redirect:/";
    }

    @GetMapping(value = "/todo/list")
    public String list(Model model) {
        List<Todo> todoList = todoService.fullCheckService();
        model.addAttribute("todoList", todoList);
        return "todo/todoList";
    }

    @GetMapping(value = "/todo/del")
    public String deleteForm(Model model) {
        return "todo/delTodoForm";
    }

    @PostMapping("/todo/del")
    public String delete(DelTodoForm form){
        this.todoService.delTodoService(form.getTask());
        return "redirect:/";
    }

}
