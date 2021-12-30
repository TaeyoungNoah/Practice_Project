package spring.todolist.domain;

import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class TodoRepository {
    private static final Map<Long,Todo> store = new HashMap<>();
    private static long sequence=0L;

    // 일정추가
    public Todo save(Todo todo){
        todo.setId(++sequence);
        store.put(todo.getId(), todo);
        return todo;
    }

    // 아이디값으로 일정 찾기
    public Todo findById(Long todoId){
        return store.get(todoId);
    }

    // task값으로 일정 찾기
    public Optional<Todo> findByTask(String task){
        return store.values().stream()
                    .filter(todo -> todo.getTask().equals(task))
                    .findAny();
    }

    // 전체 일정 조회
    public List<Todo> findAll(){
        return new ArrayList<>(store.values());
    }

    // 일정 수정하기
    public void revise(Long todoId, Todo reviseParam){
        Todo findTodo = store.get(todoId);
        findTodo.setTask(reviseParam.getTask());
        findTodo.setStartDate(reviseParam.getStartDate());
        findTodo.setDeadLine(reviseParam.getDeadLine());
        findTodo.setState(reviseParam.getState());
        findTodo.setTaskType(reviseParam.getTaskType());
    }

    // 일정 삭제하기
    public void delete(Long todoId){
        store.remove(todoId);
    }

    // store 비우기 (테스트용)
    public void clearStore(){
        store.clear();
    }
}
