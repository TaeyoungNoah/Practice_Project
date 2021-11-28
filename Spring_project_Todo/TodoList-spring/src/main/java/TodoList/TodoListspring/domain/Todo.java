package TodoList.TodoListspring.domain;

public class Todo {
    private String todoSomething;
    private String deadLine;

    public String getTodoSomething() {
        return todoSomething;
    }

    public void setTodoSomething(String todoSomething) {
        this.todoSomething = todoSomething;
    }

    public String getDeadLine() {
        return deadLine;
    }

    public void setDeadLine(String deadLine) {
        this.deadLine = deadLine;
    }
}
