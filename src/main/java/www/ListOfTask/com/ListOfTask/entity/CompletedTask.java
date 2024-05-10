package www.ListOfTask.com.ListOfTask.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@Getter
@Setter
@Table(name = "completedTask")
public class CompletedTask {
    @Id
    private int id;
    @Column(name = "task_name")
    private String taskName;
    @Column(name = "description")
    private String description;

    public CompletedTask(Task task) {
        this.id = task.getId();
        this.taskName = task.getTaskName();
        this.description = task.getDescription();
    }
}
