package pl.szymonchowaniec.NHSystem.Service;

import pl.szymonchowaniec.NHSystem.Model.Member;
import pl.szymonchowaniec.NHSystem.Model.Task;

import java.util.List;

public interface TaskService {
    void addTask(Task task, Member member);
    List<Task> findMemberTasks(Member member);
}
