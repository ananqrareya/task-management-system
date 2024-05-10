package www.ListOfTask.com.ListOfTask.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import www.ListOfTask.com.ListOfTask.DAO.CompletedTaskDao;
import www.ListOfTask.com.ListOfTask.DTO.TaskDto;
import www.ListOfTask.com.ListOfTask.DTO.TaskStatusDTO;
import www.ListOfTask.com.ListOfTask.Service.TaskService;
import www.ListOfTask.com.ListOfTask.email.MailTraoEmailSend;
import www.ListOfTask.com.ListOfTask.entity.CompletedTask;
import www.ListOfTask.com.ListOfTask.entity.Task;
import www.ListOfTask.com.ListOfTask.entity.TaskStatus;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/TDList")
public class RestControllerTask {
    @Autowired
    private TaskService taskService;
@Autowired
private CompletedTaskDao completedTaskDao;

    @PostMapping("/newTask")
    public ResponseEntity<Task> addTask(@RequestBody Task task) throws IOException {
        taskService.save(task);
        return ResponseEntity.status(HttpStatus.CREATED).body(task);
    }
    @GetMapping("/AllTask")
    public List<Task> getAllTask(){
        return taskService.findAll();
    }
    @GetMapping("/Task/{id}")
    public ResponseEntity<Task> getTaskById(@PathVariable int id){
        Task task=taskService.findById(id);
        if(task!=null){
            return new ResponseEntity<>(task,HttpStatus.OK);
        }else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @PutMapping("/updateTask/{id}")
    public ResponseEntity<Task> updateTask(@PathVariable int id ,@RequestBody TaskDto taskDto){
        Task task1=taskService.updateTask(id,taskDto);
        return new ResponseEntity<>(task1,HttpStatus.ACCEPTED);
    }
@PutMapping("/completedTask/{id}")
    public ResponseEntity<String> completedTask(@PathVariable int id ,@RequestBody TaskStatusDTO compTaskDto){
        Task task=taskService.completedTask(id,compTaskDto);
        if(task.getStateTask()==TaskStatus.COMPLETED){
            return new ResponseEntity<>("Task is Completed",HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>("Task is NotCompleted or not found",HttpStatus.OK);
        }


}
@GetMapping("/TaskCompleted")
public List<CompletedTask> findAll(){
return completedTaskDao.findAll();
}

    @DeleteMapping("/deleteTask/{id}")
    public String deleteTask(@PathVariable int id){
        taskService.deleteTask(id);
        return "Task is :"+id+" Deleted ";
    }
}
