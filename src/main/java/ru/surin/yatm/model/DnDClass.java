package ru.surin.yatm.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "dnd_class")
public class DnDClass extends BasicEntity {
    @Column (name = "dnd_class_name")
    private String name;
    @Column (name = "class_description")
    private String classDescription;

}
