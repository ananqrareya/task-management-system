package www.ListOfTask.com.ListOfTask.DTO;

import www.ListOfTask.com.ListOfTask.entity.TaskStatus;

public class TaskDto {
    private String taskName;
    private String description;
    private TaskStatus stateTask;

    public TaskDto() {

    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public TaskStatus getStateTask() {
        return stateTask;
    }

    public void setStateTask(TaskStatus stateTask) {
        this.stateTask = stateTask;
    }
}
