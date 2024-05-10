package www.ListOfTask.com.ListOfTask.DAO;

import www.ListOfTask.com.ListOfTask.entity.CompletedTask;

import java.util.List;

public interface CompletedTaskDao {
    public List<CompletedTask> findAll();
}
