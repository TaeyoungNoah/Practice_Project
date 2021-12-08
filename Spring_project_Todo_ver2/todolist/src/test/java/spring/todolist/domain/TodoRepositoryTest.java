package spring.todolist.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TodoRepositoryTest {

    TodoRepository todoRepository = new TodoRepository();

    @AfterEach
    void clear(){
        todoRepository.clearStore();
    }
    @Test
    void save() {
        //given
        Todo todo = new Todo("task", "startDate", "deadLine");
        //when
        Todo savedTodo = todoRepository.save(todo);
        //then
        Todo findTodo = todoRepository.findById(todo.getId());
        Assertions.assertThat(savedTodo).isEqualTo(findTodo);
    }

    @Test
    void findAll() {
        //given
        Todo todo1 = new Todo("task1", "startDate1", "deadLine1");
        Todo todo2 = new Todo("task2", "startDate2", "deadLine2");
        todoRepository.save(todo1);
        todoRepository.save(todo2);
        //when
        List<Todo> findTodos = todoRepository.findAll();
        //then
        Assertions.assertThat(findTodos.size()).isEqualTo(2);
        Assertions.assertThat(findTodos).contains(todo1,todo2);
    }

    @Test
    void revise() {
        //given
        Todo todo = new Todo("task", "startDate", "deadLine");
        Todo savedTodo = todoRepository.save(todo);
        Long todoId = savedTodo.getId();

        //when
        Todo reviseParam = new Todo("reTask","reStartDate","reDeadLine");
        todoRepository.revise(todoId, reviseParam);
        //then
        Todo findTodo = todoRepository.findById(todoId);
        Assertions.assertThat(reviseParam.getTask()).isEqualTo(findTodo.getTask());
        Assertions.assertThat(reviseParam.getStartDate()).isEqualTo(findTodo.getStartDate());
        Assertions.assertThat(reviseParam.getDeadLine()).isEqualTo(findTodo.getDeadLine());
    }

    @Test
    void delete() {
        //given
        Todo todo1 = new Todo("task1", "startDate1", "deadLine1");
        Todo todo2 = new Todo("task2", "startDate2", "deadLine2");
        Todo savedTodo1 = todoRepository.save(todo1);
        Todo savedTodo2 = todoRepository.save(todo2);
        //when
        Long savedTodoId = savedTodo1.getId();
        //then
        todoRepository.delete(savedTodoId);
        Assertions.assertThat(todoRepository.findAll().size()).isEqualTo(1);
        Assertions.assertThat(todoRepository.findAll()).contains(savedTodo2);
    }
}