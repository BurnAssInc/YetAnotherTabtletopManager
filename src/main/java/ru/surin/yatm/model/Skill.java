package ru.surin.yatm.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Setter
@Getter
@Table(name = "skill")
public class Skill extends BasicEntity {
    @Column (name="skill_name", nullable = false)
    private String skillName;
    @Column (name="skill_description", nullable = false)
    private String skillDescription;
    @ManyToMany (mappedBy = "skillList", fetch = FetchType.LAZY)
    private List<Character> characterList;

    public Skill() {
        super();
    }

    public Skill(String skillName, String skillDescription,List <Character> charecterList) {
        super();
        this.skillName = skillName;
        this.skillDescription = skillDescription;
        this.characterList = charecterList;
    }
}
