package TodoList.TodoListspring.repository;

import TodoList.TodoListspring.domain.Todo;

import java.util.List;
import java.util.Optional;

public interface TodoRepository {
    Todo addTodo(Todo todo);
    Todo delTodo(Todo todo);
    List<Todo> fullCheck();
}
