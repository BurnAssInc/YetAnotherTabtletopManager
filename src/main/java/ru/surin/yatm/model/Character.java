package ru.surin.yatm.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;


@Entity
@Getter
@Setter
@Table(name = "dnd_character")

public class Character extends BasicEntity {
    @Column (name = "character_name",nullable = false)
    private String characterName;

    @Column (name = "strength", nullable = false)
    private int strength;
    @Column (name = "dexterity", nullable = false)
    private int dexterity;
    @Column (name = "constitution", nullable = false)
    private int constitution;
    @Column (name = "intelligence", nullable = false)
    private int intelligence;
    @Column (name = "wisdom", nullable = false)
    private int wisdom;
    @Column (name = "charisma", nullable = false)
    private int charisma;
    @Column (name = "character_hp", nullable = false)
    private int characterHp;
    @Column (name = "character_ac", nullable = false)
    private int characterAc;
    @Column (name = "character_speed", nullable = false)
    private int characterSpeed;


    @ManyToOne
    @JoinColumn (name = "fk_player_id",nullable = false)
    private Player player;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name="dnd_character_campaign",joinColumns = @JoinColumn(name = "dnd_character_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn (name = "campaign_id", referencedColumnName = "id"))
    private List<Campaign>campaignList;


    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name="dnd_character_feat", joinColumns = @JoinColumn(name = "dnd_character_id",  referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn (name = "feat_id", referencedColumnName = "id"))
    private List<Feat> featList;

    @ManyToMany
    @JoinTable(name="dnd_character_skill", joinColumns = @JoinColumn(name = "dnd_character_id",referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn (name = "skill_id",referencedColumnName = "id"))
    private List<Skill> skillList;

    @ManyToOne
    @JoinColumn(name = "fk_race_id",nullable = false)
    private Race race;

    @ManyToOne
    @JoinColumn(name = "fk_deity_id",nullable = false)
    private Deity deity;

    @ManyToMany
    @JoinTable (name = "dnd_character_item", joinColumns = @JoinColumn(name = "dnd_character_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn (name = "item_id", referencedColumnName = "id"))
    private List<Item> itemList;

    @Column (name = "other_description")
    private String otherDescription;

    public Character() {
        super();
    }

    public Character(String characterName, int strength, int dexterity, int constitution, int intelligence, int wisdom, int charisma, int characterHp, int characterAc, int characterSpeed, int characterBaseAttackBonus, Player player, List<Campaign> campaignList, List<Feat> featList, List<Skill> skillList, Race race, Deity deity, List<Item> itemList, String otherDescription) {
        super();
        this.characterName = characterName;
        this.strength = strength;
        this.dexterity = dexterity;
        this.constitution = constitution;
        this.intelligence = intelligence;
        this.wisdom = wisdom;
        this.charisma = charisma;
        this.characterHp = characterHp;
        this.characterAc = characterAc;
        this.characterSpeed = characterSpeed;
        this.player = player;
        this.campaignList = campaignList;
        this.featList = featList;
        this.skillList = skillList;
        this.race = race;
        this.deity = deity;
        this.itemList = itemList;
        this.otherDescription = otherDescription;
    }
}
