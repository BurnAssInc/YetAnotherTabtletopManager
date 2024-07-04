package ru.surin.yatm.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.io.Serializable;
import java.util.UUID;

@Entity
@Table(name = "dnd_character_skill")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DndCharacterSkill {

    @EmbeddedId
    private CharacterSkillId id;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JsonIgnore
    @OnDelete(action = OnDeleteAction.CASCADE)
    @MapsId("characterId") //this is the property name of the @Embeddable class, not column name
    @JoinColumn(name = "dnd_character_id")
    private Character character;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JsonIgnore
    @MapsId("skillId")
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "skill_id")
    private Skill skill;

    @Column(name = "skill_rank")
    private int skillRank;
    @Column(name = "skill_name")
    private String skillName;


    public DndCharacterSkill(Character character, Skill skill, int skillRank, String skillName) {
        this.id = new CharacterSkillId(character.getId(), skill.getId());
        this.character = character;
        this.skill = skill;
        this.skillRank = skillRank;
        this.skillName = skillName;
    }

    public int getSkillRank() {
        return skillRank;
    }

    public void setSkillRank(int skillRank) {
        this.skillRank = skillRank;
    }

    public String getSkillName() {
        return skillName;
    }

    public void setSkillName(String skillName) {
        this.skillName = skillName;
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @Embeddable
    public static class CharacterSkillId implements Serializable {

        private UUID characterId;

        private UUID skillId;


    }
}
