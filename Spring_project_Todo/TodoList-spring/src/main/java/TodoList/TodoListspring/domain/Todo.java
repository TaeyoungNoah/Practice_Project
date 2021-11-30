package TodoList.TodoListspring.domain;

public class Todo {
    private Long id;
    private String task;
    private String deadLine;

    // id의 Getter&Setter
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    // task의 Getter&Setter
    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }

    // deadLine의 Getter&Setter
    public String getDeadLine() {
        return deadLine;
    }

    public void setDeadLine(String deadLine) {
        this.deadLine = deadLine;
    }
}
