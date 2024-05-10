package www.ListOfTask.com.ListOfTask.DTO;

import www.ListOfTask.com.ListOfTask.entity.TaskStatus;

public class TaskStatusDTO {
    private TaskStatus taskStatus; // Ensure the field name matches the getter/setter methods.

    public TaskStatus getTaskStatus() {
        return taskStatus;
    }

    public void setTaskStatus(TaskStatus taskStatus) {
        this.taskStatus = taskStatus;
    }

}