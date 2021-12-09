package spring.todolist.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
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
    public String add(@ModelAttribute Todo todo, RedirectAttributes redirectAttributes){
        try {
            validDataDuplicationAddTask(todo);
            validDataNumAddDate(todo);
            validDataLengthAddDate(todo);
            todoRepository.save(todo);
            return "redirect:/todo/todos";
        } catch (IllegalStateException e){
            redirectAttributes.addAttribute("status",true);
            redirectAttributes.addAttribute("errorMsg",e.getMessage());
            return "redirect:/todo/todos/error";
        }

    }

    // 중복된 일정임을 확인하는 메서드
    private void validDataDuplicationAddTask(Todo todo){
        todoRepository.findByTask(todo.getTask())
                .ifPresent((Todo t) -> {
                    throw new IllegalStateException("[ERROR] 이미 존재하는 일정입니다.");
                });
    }

    // 날짜 입력 방식이 올바른지 확인하는 메서드 (숫자?)
    private void validDataNumAddDate(Todo todo){
        try {
            Integer.parseInt(todo.getStartDate());
            Integer.parseInt(todo.getDeadLine());
        }catch (NumberFormatException e){
            throw new IllegalStateException("[ERROR] 날짜를 양식(YYYYMMDD)에 맞게 입력하세요.");
        }
    }

    // 날짜 입력 방식이 올바른지 확인하는 메서드 (길이)
    private void validDataLengthAddDate(Todo todo){
        if(todo.getStartDate().length()!=8 || todo.getDeadLine().length()!=8){
            throw new IllegalStateException("[ERROR] 날짜를 양식(YYYYMMDD)에 맞게 입력하세요.");
        }
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

    // 에러페이지 맵핑
    @GetMapping("/todo/todos/error")
    public String error(){
        return "todo/error";
    }

    //테스트용 데이터 추가
    @PostConstruct
    public void init() {
        todoRepository.save(new Todo("task1", "20201121", "20201231"));
        todoRepository.save(new Todo("task2", "20200101", "20210101"));
    }

}
