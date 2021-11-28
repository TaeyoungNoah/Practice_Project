package TodoList.TodoListspring.repository;

import TodoList.TodoListspring.domain.Todo;

import java.util.List;
import java.util.Optional;

public interface TodoRepository {
    Todo addTodo(Todo todo);
    void delTodo(String task);
    Optional<Todo> findByTask(String task);
    Optional<Todo> findById(Long id);
    List<Todo> fullCheck();
}
