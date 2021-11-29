package service;

import TodoList.TodoListspring.domain.Todo;
import TodoList.TodoListspring.repository.MemoryTodoRepository;
import TodoList.TodoListspring.service.TodoService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class TodoServiceTest {
    MemoryTodoRepository memoryTodoRepository;
    TodoService todoService;

    @BeforeEach
    public void beforeEach(){
        memoryTodoRepository = new MemoryTodoRepository();
        todoService = new TodoService();
    }

    @AfterEach
    public void afterEach(){
        memoryTodoRepository.clearStore();
    }

    @Test
    public void 일정추가(){
        //given
        Todo todo = new Todo();
        todo.setTask("내일하자");
        todo.setDeadLine("내일");

        //when
        Long saveId = todoService.addTodoService(todo);

        //additional test
        System.out.println(todo.getTask());
        System.out.println(todo.getDeadLine());

        //then
        Todo findTodo = todoService.findOne(saveId).get();
        Assertions.assertThat(todo.getTask()).isEqualTo(findTodo.getTask());
    }

    @Test
    public void 중복일정추가(){
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
        Assertions.assertThat(e.getMessage()).isEqualTo("이미 존재하는 일정입니다.");
    }

    @Test
    public void 일정삭제(){
        //given
        Todo todo1 = new Todo();
        todo1.setTask("내일하자");
        todo1.setDeadLine("내일");

        Todo todo2 = new Todo();
        todo2.setTask("오늘하자");
        todo2.setDeadLine("오늘");

        //when
        todoService.addTodoService(todo1);
        todoService.addTodoService(todo2);
        List<Todo> resultCheck1 = todoService.fullCheckService();
        for(int i=0; i<resultCheck1.size(); i++){
            System.out.println(resultCheck1.get(i).getTask());
            System.out.println(resultCheck1.get(i).getDeadLine());
        }
        todoService.delTodoService("내일하자");

        //then
        List<Todo> resultCheck2 = todoService.fullCheckService();
        for(int i=0; i<resultCheck2.size(); i++){
            System.out.println(resultCheck2.get(i).getTask());
            System.out.println(resultCheck2.get(i).getDeadLine());
        } // 혹시 모르니 삭제하고싶은 일정만 삭제됐는지 확인하기 위한 출력
        Assertions.assertThat(todoService.fullCheckService().size()).isEqualTo(1);
    }

    @Test
    public void 없는일정삭제(){
        //given
        Todo todo = new Todo();
        todo.setTask("내일하자");
        todo.setDeadLine("내일");

        //when
        todoService.addTodoService(todo);

        //then
        IllegalStateException e = assertThrows(IllegalStateException.class, () -> todoService.delTodoService("오늘하자"));
        Assertions.assertThat(e.getMessage()).isEqualTo("존재하지 않는 일정입니다.");
    }

    @Test
    public void 전체일정확인(){
        //given
        Todo todo1 = new Todo();
        todo1.setTask("내일하자");
        todo1.setDeadLine("내일");

        Todo todo2 = new Todo();

        //when
        todo2.setTask("오늘하자");
        todo2.setDeadLine("오늘");
        todoService.addTodoService(todo1);
        todoService.addTodoService(todo2);
        List<Todo> resultCheck = todoService.fullCheckService();
        for(int i=0; i<resultCheck.size(); i++){
            System.out.println(resultCheck.get(i).getTask());
            System.out.println(resultCheck.get(i).getDeadLine());
        }

        //then
        Assertions.assertThat(resultCheck.size()).isEqualTo(2);
    }
}
