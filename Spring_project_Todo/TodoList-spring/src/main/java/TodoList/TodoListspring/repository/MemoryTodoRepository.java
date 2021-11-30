package TodoList.TodoListspring.repository;

import TodoList.TodoListspring.domain.Todo;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class MemoryTodoRepository implements TodoRepository{
    private static Map<Long, Todo> store = new HashMap<>();
    private static long sequence = 0L;

    @Override
    public Todo addTodo(Todo todo) {
        todo.setId(++sequence);
        store.put(todo.getId(), todo);
        return todo;
    }

    @Override
    public void delTodo(String task) {
        Optional<Todo> todo = findByTask(task);
        store.remove(todo.get().getId());
    }

    @Override
    public Optional<Todo> findByTask(String task) {
        return store.values().stream()
                .filter(todo -> todo.getTask().equals(task))
                .findAny();
    }

    @Override
    public Optional<Todo> findById(Long id) {
        return Optional.ofNullable(store.get(id));
    }

    @Override
    public List<Todo> fullCheck() {
        return new ArrayList<>(store.values());
    }

    public void clearStore(){
        store.clear();
    }
}
