package ru.surin.yatm.model;

import jakarta.persistence.*;
import lombok.*;

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

    @ManyToOne
    @MapsId("characterId") //this is the property name of the @Embeddable class, not column name
    @JoinColumn(name = "dnd_character_id")
    private Character character;

    @ManyToOne
    @MapsId("skillId")
    @JoinColumn(name = "skill_id")
    private Skill skill;

    @Column(name = "skill_rank")
    private int skillRank = 0;

    public DndCharacterSkill(Character character, Skill skill) {
        this.id = new CharacterSkillId(character.getId(),skill.getId());
        this.character = character;
        this.skill = skill;


    }




    @Embeddable
    public class CharacterSkillId implements Serializable {

        private UUID characterId;

        private UUID skillId;

        public CharacterSkillId(UUID characterId, UUID skillId) {
            this.characterId = characterId;
            this.skillId = skillId;
        }

        public CharacterSkillId() {
        }

        public UUID getCharacterId() {
            return characterId;
        }

        public void setCharacterId(UUID characterId) {
            this.characterId = characterId;
        }

        public UUID getSkillId() {
            return skillId;
        }

        public void setSkillId(UUID skillId) {
            this.skillId = skillId;
        }
        // getters and setters
    }
}
