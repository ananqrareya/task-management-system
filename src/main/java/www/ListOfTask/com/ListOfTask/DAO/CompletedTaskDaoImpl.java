package www.ListOfTask.com.ListOfTask.DAO;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;
import www.ListOfTask.com.ListOfTask.entity.CompletedTask;

import java.util.List;

@Repository
public class CompletedTaskDaoImpl implements CompletedTaskDao{
    private EntityManager entityManager;
    public  CompletedTaskDaoImpl(EntityManager entityManager1){
        this.entityManager=entityManager1;
    }
    @Override
    public List<CompletedTask> findAll() {
        TypedQuery<CompletedTask>query=entityManager.createQuery("FROM CompletedTask ", CompletedTask.class);
        List<CompletedTask> completedTasks=query.getResultList();
        return  completedTasks;
    }
}
