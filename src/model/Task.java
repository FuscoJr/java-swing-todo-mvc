package model;

public class Task {

//    ATTRIBUTES
    private String title;
    private TaskStatus status;

//    CONSTRUCTOR
    public Task(String title) {
        this.title = title;
        this.status = TaskStatus.OPEN;
    }

//    GETTER
    public String getTitle() {
        return title;
    }
    public TaskStatus getStatus() {
        return status;
    }

//    SETTER
    public void setTitle(String title) {
        this.title = title;
    }
    public void setStatus(TaskStatus status) {
        this.status = status;
    }

//    METHOD
    @Override
    public String toString() {
        return "[" + status + "] " + title;
    }
}
