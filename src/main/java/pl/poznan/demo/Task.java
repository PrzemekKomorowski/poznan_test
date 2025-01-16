package pl.poznan.demo;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.Objects;

@Entity
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String description;

    @Enumerated(EnumType.STRING)
    private TaskStatus status;

    protected Task() { }

    // Błędem który zobaczyłem jest użycie "status" jako "this.status" problem, że on nie będzie miał nigdy miejsca
    public void setStatus(TaskStatus status) {
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        // tutaj linia była zakomentowana wydaje mi się że to był zabieg celowy lecz postanowiłem o tym wspomnieć w komentarzu
            this.description = description;
    }


    // Tutaj klasa TaskStatus była prywatna i zostało to zmienione na Publiczne ponieważ otrzymanie statusu możemy rządać z zewnątrz a nie koniecznie tylko z samej klasy Task. Uważam to za błąd dlatego zmieniłem
    // klasę na private
    private TaskStatus getStatus() {
        return status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Task task)) return false;
        return Objects.equals(id, task.id) && Objects.equals(description, task.description) && status == task.status;
    }

    @Override
    public int hashCode() {
        return 0;
    }
}
