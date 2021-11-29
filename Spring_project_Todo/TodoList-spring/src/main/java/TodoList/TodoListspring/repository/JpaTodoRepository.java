package TodoList.TodoListspring.repository;

import TodoList.TodoListspring.domain.Todo;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Transactional
public class JpaTodoRepository implements TodoRepository{

    private final EntityManager em;

    public JpaTodoRepository(EntityManager em) {
        this.em = em;
    }

    @Override
    public Todo addTodo(Todo todo) {
        em.persist(todo);
        return todo;
    }

    @Override
    public void delTodo(String task) {
        Optional<Todo> del = findByTask(task);
        em.remove(del.get());
    }

    @Override
    public Optional<Todo> findByTask(String task) {
        List<Todo> result = em.createQuery("select t from Todo t where t.task = :task", Todo.class)
                .setParameter("task", task)
                .getResultList();
        return result.stream().findAny();
    }

    @Override
    public Optional<Todo> findById(Long id) {
        Todo todo = em.find(Todo.class, id);
        return Optional.ofNullable(todo);
    }

    @Override
    public List<Todo> fullCheck() {
        return null;
    }
}
