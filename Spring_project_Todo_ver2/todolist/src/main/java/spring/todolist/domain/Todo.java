package spring.todolist.domain;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Todo {
    private Long id;
    private String task;
    private String startDate;
    private String deadLine;
    private boolean finish=false;

    public Todo(String task, String startDate, String deadLine) {
        this.task = task;
        this.startDate = startDate;
        this.deadLine = deadLine;
    }
}
