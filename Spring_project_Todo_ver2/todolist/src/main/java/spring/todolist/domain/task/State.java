package spring.todolist.domain.task;

public enum State {
    FINISHED("완료"), ONGOING("진행중");

    private final String description;

    State(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
