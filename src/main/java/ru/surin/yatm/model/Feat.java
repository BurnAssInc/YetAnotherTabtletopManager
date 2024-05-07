package ru.surin.yatm.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "feat")

public class Feat extends BasicEntity{
    @Column(name="feat_name", nullable = false)
    private String name;
    @Column (name="feat_description", nullable = false)
    private String featDescription;

    @ManyToMany(mappedBy = "featList", fetch = FetchType.LAZY)          //mappedBy по названию полю листа в Character
    private List<Character> characterList;

    public Feat() {
        super();
    }

    public Feat(String name, String featDescription, List<Character> characterList) {
        super();
        this.name = name;
        this.featDescription = featDescription;
        this.characterList = characterList;
    }
}
