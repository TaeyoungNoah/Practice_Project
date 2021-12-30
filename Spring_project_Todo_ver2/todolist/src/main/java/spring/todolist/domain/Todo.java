package spring.todolist.domain;

import lombok.Getter;
import lombok.Setter;
import spring.todolist.domain.task.State;
import spring.todolist.domain.task.TaskType;

@Getter @Setter
public class Todo {
    private Long id;
    private String task;
    private String startDate;
    private String deadLine;
    private State state = State.ONGOING;
    private TaskType taskType;
    public Todo() {}
    public Todo(String task, String startDate, String deadLine) {
        this.task = task;
        this.startDate = startDate;
        this.deadLine = deadLine;
    }
}
