package pl.szymonchowaniec.NHSystem.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.szymonchowaniec.NHSystem.Model.Member;
import pl.szymonchowaniec.NHSystem.Model.Task;

import java.util.List;


public interface TaskRepository extends JpaRepository<Task, Long> {
    List<Task> findByMember(Member member);
}
