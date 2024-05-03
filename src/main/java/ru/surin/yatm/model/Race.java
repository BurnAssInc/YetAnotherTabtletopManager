package ru.surin.yatm.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "race")

public class Race extends BasicEntity{
    @Column (name="race_name", nullable = false)

    private String raceName;

    @OneToMany(mappedBy = "race", fetch = FetchType.LAZY)
    private List<Character> characterList;


    public Race() {
        super();
    }

    public Race(String raceName, List<Character>characterList) {
        super();
        this.raceName = raceName;
        this.characterList = characterList;
    }
}
