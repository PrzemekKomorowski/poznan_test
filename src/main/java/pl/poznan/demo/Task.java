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

    protected Task() {
    }

    // Błędem który zobaczyłem jest użycie "status" jako "this.status" problem, że on nie będzie miał nigdy miejsca, zamieniłem je miejscami
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


    // Tutaj metoda była prywatna i zostało to zmienione na Publiczne ponieważ otrzymanie statusu możemy rządać z zewnątrz a nie koniecznie tylko z samej klasy Task.
    public TaskStatus getStatus() {
        return status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Task task)) return false;
        return Objects.equals(id, task.id) && Objects.equals(description, task.description) && status == task.status;
    }

    // hashCode nie powinno zawsze zwracać 0. Bo nie ma wtedy sensu stosowania tej metody, ponieważ wtedy wszystkie wartości są sobie równe po porównaniu na podstawie hashCode.
    // Wykorzystałem 3 najważniejsze dane do stworzenia hashCode czyli Id, Opis i status
    @Override
    public int hashCode() {
        return Objects.hash(id, description, status);
    }
}
