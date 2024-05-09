package ru.surin.yatm.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Set;
// TODO 006
@Entity
@Setter
@Getter
@Table(name = "skill")
public class Skill extends BasicEntity {
    @Column (name="skill_name", nullable = false)
    private String name;
    @Column (name="skill_description", nullable = false)
    private String skillDescription;
    @ManyToMany (mappedBy = "skillList", fetch = FetchType.LAZY)
    private Set<Character> characterList;

    public Skill() {
        super();
    }

    public Skill(String name, String skillDescription, Set <Character> charecterList) {
        super();
        this.name = name;
        this.skillDescription = skillDescription;
        this.characterList = charecterList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSkillDescription() {
        return skillDescription;
    }

    public void setSkillDescription(String skillDescription) {
        this.skillDescription = skillDescription;
    }

    public Set<Character> getCharacterList() {
        return characterList;
    }

    public void setCharacterList(Set<Character> characterList) {
        this.characterList = characterList;
    }
}
