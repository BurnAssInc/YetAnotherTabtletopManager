package ru.surin.yatm.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "item")

public class Item extends BasicEntity{
    @Column(name="item_name", nullable = false)
    private String itemName;
    @Column (name="item_description", nullable = false)
    private String itemDescription;
    @Column (name="item_price", nullable = false)
    private int itemPrice;

    @ManyToMany(mappedBy = "itemList", fetch = FetchType.LAZY)
    private List<Character> characterList; //по идее в item не должно быть поля character, нужно ли оптсывать их взаимосвязь

    public Item() {
        super();
    }

    public Item(String itemName, String itemDescription, int itemPrice, List<Character> characterList) {
        super();
        this.itemName = itemName;
        this.itemDescription = itemDescription;
        this.itemPrice = itemPrice;
        this.characterList = characterList;
    }
}
