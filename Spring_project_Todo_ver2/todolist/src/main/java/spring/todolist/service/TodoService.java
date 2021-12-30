package spring.todolist.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.todolist.domain.JdbcRepository;
import spring.todolist.domain.Todo;
import spring.todolist.domain.TodoRepository;

import java.util.List;
import java.util.Optional;

@Service
public class TodoService {
    private TodoRepository todoRepository;
    @Autowired
    public TodoService(TodoRepository todoRepository, JdbcRepository jdbcRepository) {
        this.todoRepository = todoRepository;
    }

    // 추가
    public void addTodo(Todo todo){
        validDataDuplicationAddTask(todo);
        validDataNumAddDate(todo);
        validDataLengthAddDate(todo);
        todoRepository.save(todo);
    }

    // 수정
    public void reviseTodo(Long todoId, Todo revisedTodo){
        validDataNumAddDate(revisedTodo);
        validDataLengthAddDate(revisedTodo);
        todoRepository.revise(todoId,revisedTodo);
    }

    // 삭제
    public void deleteTodo(Long todoId){
        todoRepository.delete(todoId);
    }

    // 전체조회
    public List<Todo> findAllTodo(){
        return todoRepository.findAll();
    }

    // findOne
    public Todo findOne(Long todoId){
        return todoRepository.findById(todoId);
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
}
