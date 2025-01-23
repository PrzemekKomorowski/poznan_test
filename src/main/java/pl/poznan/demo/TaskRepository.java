package pl.poznan.demo;

import pl.poznan.demo.Task;
import pl.poznan.demo.TaskStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {

    @Query("SELECT t FROM Task t WHERE " +
            "(:status IS NULL OR t.status = :status) AND " +
            "(:priority IS NULL OR t.priority = :priority) AND " +
            "(:dueDate IS NULL OR t.dueDate = :dueDate)")
    List<Task> filterTasks(@Param("status") TaskStatus status,
                           @Param("priority") String priority,
                           @Param("dueDate") LocalDate dueDate);
}
