package www.ListOfTask.com.ListOfTask.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import www.ListOfTask.com.ListOfTask.DAO.AppDao;
import www.ListOfTask.com.ListOfTask.DTO.TaskDto;
import www.ListOfTask.com.ListOfTask.DTO.TaskStatusDTO;
import www.ListOfTask.com.ListOfTask.email.MailTraoEmailSend;
import www.ListOfTask.com.ListOfTask.entity.Task;
import www.ListOfTask.com.ListOfTask.entity.TaskStatus;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService {
    @Autowired
    private AppDao appDAO;
    @Autowired
    private MailTraoEmailSend emailSend;

    public void save(Task task){
        appDAO.saveTask(task);
        emailSend.sendEmail("ananhajj2002@gmail.com", "New Task Created", formatEmail(task));

    }
    public List<Task> findAll(){
        return appDAO.findAll();
    }
    public Task findById(int id){
        return appDAO.findById(id);
    }
    public Task updateTask(int id , TaskDto taskDto){
        Task task=appDAO.findById(id);
        if(task!=null) {
            task.setTaskName(Optional.ofNullable(taskDto.getTaskName()).orElse(task.getTaskName()));
            task.setDescription(Optional.ofNullable(taskDto.getDescription()).orElse(task.getDescription()));
            task.setStateTask(Optional.ofNullable(taskDto.getStateTask()).orElse(task.getStateTask()));
        }
        return appDAO.updateTask(task);
    }
    public Task completedTask(int id, TaskStatusDTO taskStatusDTO){
        Task task=appDAO.findById(id);
        if(task!=null){
        task.setStateTask(Optional.ofNullable(taskStatusDTO.getTaskStatus()).orElse(task.getStateTask()));
        return appDAO.completedTask(task);}
        return null ;
    }
    public void deleteTask(int id){
        appDAO.deleteTaskById(id);
    }
    private String formatEmail(Task task) {
        return "A new task has been created:\n\n" +
                "Task ID: " + task.getId() + "\n" +
                "Task Name: " + task.getTaskName() + "\n" +
                "Description: " + task.getDescription();
    }
}
