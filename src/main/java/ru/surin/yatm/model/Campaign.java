package ru.surin.yatm.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "campaign")
public class Campaign extends BasicEntity {
    @Column (name = "campaign_name", nullable = false)
    private String name;
// TODO 006

    @ManyToMany (mappedBy = "campaignList",fetch = FetchType.LAZY)
    private List <Player> playerList;

    @ManyToMany (mappedBy = "campaignList", fetch = FetchType.LAZY)
    private List<Character> characterList;

    public Campaign() {
        super();
    }

    public Campaign(String name, List <Player> playerList, List<Character> characterList) {
        super();
        this.name = name;
        this.playerList = playerList;
        this.characterList = characterList;
    }
}
