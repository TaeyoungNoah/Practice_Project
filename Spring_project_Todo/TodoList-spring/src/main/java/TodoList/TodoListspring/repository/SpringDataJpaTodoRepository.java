package TodoList.TodoListspring.repository;

import TodoList.TodoListspring.domain.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SpringDataJpaTodoRepository extends JpaRepository<Todo, Long> , TodoRepository{

}
