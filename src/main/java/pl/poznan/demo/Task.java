package pl.poznan.demo;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Objects;

@Entity
@Getter
@Setter
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String description;

    @Enumerated(EnumType.STRING)
    private TaskStatus status;

    private Integer priority;
    private LocalDate dueDate;

    // Konstruktor bezargumentowy wymagany przez JPA
    public Task() {
    }

    // Konstruktor umożliwiający inicjalizację zadania z danymi
    public Task(String description, TaskStatus status) {
        this.description = description;
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Task task)) return false;
        return Objects.equals(id, task.id) && Objects.equals(description, task.description) && status == task.status;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, description, status);
    }
}



/*
 * Na obecną chwilę mogę wspomnieć o poprawkach, jakie miały miejsce w metodach:
 * - SetStatus,
 * - SetDescription,
 * - prywatnej metodzie getStatus.
 *
 * Nie mogę już jak we wcześniejszym commicie wskazać miejsc tych poprawek, gdyż zastosowałem LOMBOKA w celu uproszczenia kodu,
 * jak wymaga tego zadanie. Użycie Lomboka uznałem za najlepsze rozwiązanie, aby zachować czystość i czytelność kodu,
 * jednocześnie nie zaśmiecając klasy zbędnymi metodami getterami i setterami.
 */