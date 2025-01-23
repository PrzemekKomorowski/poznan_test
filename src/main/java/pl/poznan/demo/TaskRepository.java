package pl.poznan.demo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Long> {

    List<Task> findByStatus(TaskStatus status);

    List<Task> findByPriority(Integer priority);

    List<Task> findByDueDate(LocalDate dueDate);

    @Query("SELECT t FROM Task t WHERE " +
            "(:status IS NULL OR t.status = :status) AND " +
            "(:priority IS NULL OR t.priority = :priority) AND " +
            "(:dueDate IS NULL OR t.dueDate = :dueDate)")
    List<Task> filterTasks(@Param("status") TaskStatus status,
                           @Param("priority") Integer priority,
                           @Param("dueDate") LocalDate dueDate);
}
