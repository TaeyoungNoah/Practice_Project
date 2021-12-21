package spring.todolist.domain.task;

public enum TaskType {
    STUDY("공부"), WORK("일"), LEISURE("여가"), ETC("기타");

    private final String description;

    TaskType(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
