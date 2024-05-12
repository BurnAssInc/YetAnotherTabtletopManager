package ru.surin.yatm.model;

import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Objects;
import java.util.Set;

// TODO 006
@Entity
@Setter
@Getter
@Table(name = "skill")
public class Skill extends BasicEntity {
    @Column(name = "skill_name", nullable = false)
    private String name;
    @Column(name = "skill_description", nullable = false)
    private String skillDescription;
    @OneToMany(mappedBy = "skill", fetch = FetchType.LAZY)
    @Nullable
    private Set<DndCharacterSkill> dndCharacterSkillSet;

    public Skill() {
        super();
    }

    public Skill(String name, String skillDescription, Set<DndCharacterSkill> dndCharacterSkillSet) {
        super();
        this.name = name;
        this.skillDescription = skillDescription;
        this.dndCharacterSkillSet = dndCharacterSkillSet;
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

    public Set<DndCharacterSkill> getDndCharacterSkillSet() {
        return dndCharacterSkillSet;
    }

    public void setDndCharacterSkillSet(Set<DndCharacterSkill> dndCharacterSkillSet) {
        this.dndCharacterSkillSet = dndCharacterSkillSet;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Skill skill = (Skill) o;
        return Objects.equals(name, skill.name);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(name);
    }
}
