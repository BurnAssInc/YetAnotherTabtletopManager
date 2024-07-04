package ru.surin.yatm.model;


import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;

import java.util.UUID;


@MappedSuperclass
public abstract class BasicEntity {

    @Id
    protected UUID id;

    public UUID getId() {
        return id;
    }

    public BasicEntity() {
        this.id = UUID.randomUUID();

    }
}
