package spring.todolist.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import spring.todolist.domain.Todo;
import spring.todolist.domain.task.State;
import spring.todolist.domain.task.TaskType;
import spring.todolist.service.TodoService;

import javax.annotation.PostConstruct;
import java.util.List;

@Controller
@RequestMapping()
public class TodoController {
    private TodoService todoService;

    @Autowired
    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    // 상태관련 Enum
    @ModelAttribute("states")
    public State[] states() {
        return State.values();
    }

    // 일의 타입 Enum
    @ModelAttribute("taskTypes")
    public TaskType[] taskTypes() {
        return TaskType.values();
    }

    // 전체일정 확인
    @GetMapping("/todo/todos")
    public String todos(Model model){
        List<Todo> todos = todoService.findAllTodo();
        model.addAttribute("todos",todos);
        return "todo/todos";
    }

    // 일정 상세보기
    @GetMapping("/todo/todos/{todoId}")
    public String todo(@PathVariable Long todoId, Model model){
        Todo todo = todoService.findOne(todoId);
        model.addAttribute("todo",todo);
        return "todo/todo";
    }

    // 일정 추가 폼 열기
    @GetMapping("/todo/todos/add")
    public String addForm(Model model){
        model.addAttribute("todo",new Todo());
        return "todo/addForm";
    }

    // 일정 추가
    @PostMapping("/todo/todos/add")
    public String add(@ModelAttribute Todo todo, RedirectAttributes redirectAttributes){
        try {
            todoService.addTodo(todo);
            return "redirect:/todo/todos";
        } catch (IllegalStateException e){
            redirectAttributes.addAttribute("status",true);
            redirectAttributes.addAttribute("errorMsg",e.getMessage());
            return "redirect:/todo/todos/error";
        }

    }


    // 일정 수정 폼 열기
    @GetMapping("/todo/todos/{todoId}/edit")
    public String editForm(@PathVariable Long todoId, Model model){
        Todo todo = todoService.findOne(todoId);
        model.addAttribute("todo",todo);
        return "todo/editForm";
    }

    // 일정 수정
    @PostMapping("/todo/todos/{todoId}/edit")
    public String edit(@PathVariable Long todoId, @ModelAttribute Todo revisedTodo, RedirectAttributes redirectAttributes){
        try {
            todoService.reviseTodo(todoId,revisedTodo);
            return "redirect:/todo/todos/{todoId}";
        } catch (IllegalStateException e){
            redirectAttributes.addAttribute("status",true);
            redirectAttributes.addAttribute("errorMsg",e.getMessage());
            return "redirect:/todo/todos/error";
        }
    }

    // 일정 삭제
    @GetMapping("/todo/todos/{todoId}/delete")
    public String delete(@PathVariable Long todoId, Model model){
        todoService.deleteTodo(todoId);
        return "redirect:/todo/todos";
    }


    // 에러페이지 맵핑
    @GetMapping("/todo/todos/error")
    public String error(){
        return "todo/error";
    }

    //테스트용 데이터 추가
    @PostConstruct
    public void init() {
        todoService.addTodo(new Todo("task1", "20201121", "20201231"));
        todoService.addTodo(new Todo("task2", "20200101", "20210101"));
    }

}
