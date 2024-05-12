package ru.surin.yatm.model;



import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.UUID;


@MappedSuperclass
public abstract class BasicEntity {
    // TODO 001
    // TODO 006: Невыравнен код (ctr+alt+l)
    // TODO 005: Неудалённые закоментированные строки
    @Id
    //@GeneratedValue(strategy = GenerationType.AUTO)
    protected UUID id;

    public UUID getId() {
        return id;
    }

    public BasicEntity() {
        this.id = UUID.randomUUID();

    }
}
