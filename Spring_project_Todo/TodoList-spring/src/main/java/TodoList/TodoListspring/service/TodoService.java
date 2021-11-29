package TodoList.TodoListspring.service;

import TodoList.TodoListspring.domain.Todo;
import TodoList.TodoListspring.repository.MemoryTodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TodoService {
    private final MemoryTodoRepository memoryTodoRepository;

    @Autowired
    public TodoService(MemoryTodoRepository memoryTodoRepository) {
        this.memoryTodoRepository = memoryTodoRepository;
    }

    // 새로운 일정을 등록하는 메서드
    public Long addTodoService(Todo todo){
        validDataDuplicationAddTask(todo);
        memoryTodoRepository.addTodo(todo);
        return todo.getId();
    }

    // 새로운 일정을 등록할 때 중복을 검사하는 메서드
    public void validDataDuplicationAddTask(Todo todo){
        memoryTodoRepository.findByTask(todo.getTask())
                .ifPresent((Todo t)-> {
                    throw new IllegalStateException("이미 존재하는 일정입니다.");
                });
    }

    // 새로운 일정을 삭제하는 메서드
    public void delTodoService(String task){
        validDataDuplicationDelTask(task);
        memoryTodoRepository.delTodo(task);
    }

    // 삭제할 일정이 존재하는지 확인하는 메서드
    public void validDataDuplicationDelTask(String task) {
        Optional<Todo> vaildtodo = memoryTodoRepository.findByTask(task);
        if (vaildtodo.isPresent()) {
            return;
        }
        throw new IllegalStateException("존재하지 않는 일정입니다.");
    }

    // 전체 일정을 확인하는 메서드
    public List<Todo> fullCheckService(){
        return memoryTodoRepository.fullCheck();
    }


    // id로 객체를 확인하는 메서드
    public Optional<Todo> findOne (Long todoId){
        return memoryTodoRepository.findById(todoId);
    }
}
