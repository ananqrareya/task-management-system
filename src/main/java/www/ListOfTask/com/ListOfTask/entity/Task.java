package www.ListOfTask.com.ListOfTask.entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.stereotype.Component;

@Entity
@NoArgsConstructor
@Getter
@Setter
@ToString
@Table(name = "Task")
public class Task {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private int id;
        @Column(name = "task_name")
        private String taskName;
        @Column(name = "description")
        private String description;
        @Enumerated(EnumType.STRING)
        @Column(name = "state_Task")
        private TaskStatus stateTask=TaskStatus.PENDING;




}
