package spring.todolist.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import spring.todolist.domain.Todo;
import spring.todolist.domain.TodoRepository;

import javax.annotation.PostConstruct;
import java.util.List;

@Controller
@RequestMapping()
public class TodoController {
    private TodoRepository todoRepository;

    @Autowired
    public TodoController(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    // 전체일정 확인
    @GetMapping("/todo/todos")
    public String todos(Model model){
        List<Todo> todos = todoRepository.findAll();
        model.addAttribute("todos",todos);
        return "todo/todos";
    }

    // 일정 상세보기
    @GetMapping("/todo/todos/{todoId}")
    public String todo(@PathVariable Long todoId, Model model){
        Todo todo = todoRepository.findById(todoId);
        model.addAttribute("todo",todo);
        return "todo/todo";
    }

    // 일정 추가 폼 열기
    @GetMapping("/todo/todos/add")
    public String addForm(Model model){
        return "todo/addForm";
    }

    // 일정 추가
    @PostMapping("/todo/todos/add")
    public String add(@ModelAttribute Todo todo){
        todoRepository.save(todo);
        return "redirect:/todo/todos";
    }

    // 일정 수정 폼 열기
    @GetMapping("/todo/todos/{todoId}/edit")
    public String editForm(@PathVariable Long todoId, Model model){
        Todo todo = todoRepository.findById(todoId);
        model.addAttribute("todo",todo);
        return "todo/editForm";
    }

    // 일정 수정
    @PostMapping("/todo/todos/{todoId}/edit")
    public String edit(@PathVariable Long todoId, @ModelAttribute Todo revisedTodo){
        todoRepository.revise(todoId,revisedTodo);
        return "redirect:/todo/todos/{todoId}";
    }

    // 일정 삭제
    @GetMapping("/todo/todos/{todoId}/delete")
    public String delete(@PathVariable Long todoId, Model model){
        todoRepository.delete(todoId);
        return "redirect:/todo/todos";
    }

    // 일정 완료 여부 바꾸기
    @GetMapping("/todo/todos/{todoId}/finish")
    public String finish(@PathVariable Long todoId, Model model){
        Todo todo = todoRepository.findById(todoId);
        todo.setFinish(true);
        return "redirect:/todo/todos";
    }
    //테스트용 데이터 추가
    @PostConstruct
    public void init() {
        todoRepository.save(new Todo("task1", "20201121", "20201231"));
        todoRepository.save(new Todo("task2", "20200101", "20210101"));
    }

    //예외처리
    //중복된 일정 x
    //날짜가 양식에 맞는지?
    //UI를 조금 더 편리하게 (타임리프 추가 공부)

}
