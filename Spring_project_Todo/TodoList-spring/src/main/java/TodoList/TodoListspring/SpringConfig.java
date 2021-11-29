package TodoList.TodoListspring;


import TodoList.TodoListspring.repository.JpaTodoRepository;
import TodoList.TodoListspring.repository.TodoRepository;
import TodoList.TodoListspring.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;
import javax.sql.DataSource;

@Configuration
public class SpringConfig {

    private final TodoRepository todoRepository;
    @Autowired
    public SpringConfig(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    @Bean
    public TodoService todoService() {
        return new TodoService(todoRepository);
    }

}