package www.ListOfTask.com.ListOfTask.DAO;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;
import www.ListOfTask.com.ListOfTask.entity.CompletedTask;
import www.ListOfTask.com.ListOfTask.entity.Task;
import www.ListOfTask.com.ListOfTask.entity.TaskStatus;

import java.util.List;
@Repository
public class AppDaoImpl implements AppDao {


    private EntityManager entityManager;
    public AppDaoImpl(EntityManager entityManager1){
        this.entityManager=entityManager1;
    }
    @Transactional
    @Override
    public void saveTask(Task newTask) {
        entityManager.persist(newTask);
    }

    @Override
    public List<Task> findAll() {
        TypedQuery<Task>query=entityManager.createQuery("FROM Task ", Task.class);
        List<Task>tasks=query.getResultList();
        return tasks;
    }

    @Override
    public Task findById(int id) {
        Task task=entityManager.find(Task.class,id);

        return task;
    }
    @Transactional
    @Override
    public Task updateTask(Task task) {
        return entityManager.merge(task);
    }

    @Transactional
    @Override
    public Task completedTask(Task task) {
        if(task!=null&&task.getStateTask()== TaskStatus.COMPLETED){
            CompletedTask completedTask=new CompletedTask(task);
            entityManager.persist(completedTask);
            entityManager.remove(task);
            entityManager.flush();
            return task;
        }
return task;

    }
@Transactional
    @Override
    public void deleteTaskById(int id) {
        Task task=entityManager.find(Task.class,id);
        entityManager.remove(task);
    }
}
