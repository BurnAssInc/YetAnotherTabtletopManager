package ru.surin.yatm.model;



import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.UUID;



@MappedSuperclass
public abstract class BasicEntity {
    @Id
    //@GeneratedValue(strategy = GenerationType.AUTO)
    protected UUID id;

    public BasicEntity() {
        this.id = UUID.randomUUID();
    }
}
