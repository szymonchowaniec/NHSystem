package pl.szymonchowaniec.NHSystem.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.szymonchowaniec.NHSystem.Model.Member;
import pl.szymonchowaniec.NHSystem.Model.Task;
import pl.szymonchowaniec.NHSystem.Repository.TaskRepository;

import java.util.List;


@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    public void addTask(Task task, Member member){
        task.setMember(member);
        taskRepository.save(task);
    }

    public List<Task> findMemberTasks(Member member){
        return taskRepository.findByMember(member);
    }
}
