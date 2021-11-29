package service;

import TodoList.TodoListspring.domain.Todo;
import TodoList.TodoListspring.repository.TodoRepository;
import TodoList.TodoListspring.service.TodoService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;

import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
@Transactional
public class TodoServiceIntegrationTest {
    @Autowired
    TodoService todoService;
    @Autowired
    TodoRepository todoRepository;

    @Test
    public void 일정추가() throws Exception{
        //given
        Todo todo = new Todo();
        todo.setTask("내일하자");
        todo.setDeadLine("내일");

        //when
        Long saveId = todoService.addTodoService(todo);

        //then
        Todo findTodo = todoRepository.findById(saveId).get();
        Assertions.assertEquals(todo.getTask(),findTodo.getTask());
    }

    @Test
    public void 중복일정추가() throws Exception{
        //given
        Todo todo1 = new Todo();
        todo1.setTask("내일하자");
        todo1.setDeadLine("내일");

        Todo todo2 = new Todo();
        todo2.setTask("내일하자");
        todo2.setDeadLine("내일");

        //when
        todoService.addTodoService(todo1);
        IllegalStateException e = assertThrows(IllegalStateException.class, () -> todoService.addTodoService(todo2));
        org.assertj.core.api.Assertions.assertThat(e.getMessage()).isEqualTo("이미 존재하는 일정입니다.");

    }

}
