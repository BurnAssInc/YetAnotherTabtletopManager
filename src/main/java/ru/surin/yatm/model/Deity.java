package ru.surin.yatm.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "deity")
public class Deity extends BasicEntity{
    @Column(name="deity_name", nullable = false)
    private String deityName;

    public Deity() {
        super();
    }

    public Deity(String deityName) {
        super();
        this.deityName = deityName;
    }
}
