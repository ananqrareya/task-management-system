package www.ListOfTask.com.ListOfTask.DAO;

import www.ListOfTask.com.ListOfTask.entity.Task;

import java.util.List;

public interface AppDao {
    public void saveTask(Task newTask);
    public List<Task> findAll();
    public Task findById(int id);
    public Task updateTask(Task task);
    public  Task completedTask(Task task);
    public void deleteTaskById(int id);
}
