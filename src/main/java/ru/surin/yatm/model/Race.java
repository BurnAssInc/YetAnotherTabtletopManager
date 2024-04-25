package ru.surin.yatm.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "race")

public class Race extends BasicEntity{
    @Column (name="race_name", nullable = false)
    private String raceName;


    public Race() {
        super();
    }

    public Race(String raceName) {
        super();
        this.raceName = raceName;
    }
}
