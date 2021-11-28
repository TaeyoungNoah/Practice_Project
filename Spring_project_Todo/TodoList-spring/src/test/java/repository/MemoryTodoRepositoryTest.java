package repository;

import TodoList.TodoListspring.domain.Todo;
import TodoList.TodoListspring.repository.MemoryTodoRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

public class MemoryTodoRepositoryTest {
    MemoryTodoRepository repository = new MemoryTodoRepository();

    @AfterEach
    public void afterEach(){
        repository.clearStore();
    }

    @Test
    public void addTodo(){
        Todo todo = new Todo();
        todo.setTask("내일하자");
        todo.setDeadLine("내일");
        repository.addTodo(todo);

        Todo result = repository.findById(todo.getId()).get();
        Assertions.assertThat(todo).isEqualTo(result);
    }

    @Test
    public void delTodo(){
        Todo todo = new Todo();
        todo.setTask("내일할까");
        todo.setDeadLine("내일");
        repository.addTodo(todo);

        repository.delTodo("내일할까");

        List<Todo> result = repository.fullCheck();
        Assertions.assertThat(result.size()).isEqualTo(0);

    }

    @Test
    public void fullCheck(){
        Todo todo1 = new Todo();
        todo1.setTask("내일하자");
        todo1.setDeadLine("내일");
        repository.addTodo(todo1);

        Todo todo2 = new Todo();
        todo2.setTask("오늘하자");
        todo2.setDeadLine("오늘");
        repository.addTodo(todo2);

        List<Todo> result = repository.fullCheck();
        Assertions.assertThat(result.size()).isEqualTo(2);
    }
}
