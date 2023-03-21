package com.akhilscode;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
public class Item {
    @Id
    @SequenceGenerator(
            name="item_id_sequence",
            sequenceName = "item_id_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "item_id_sequence"
    )
    private Integer ID;
    private String name;
    private String category;
    private Integer cost;

    public Item(Integer ID, String name, String category, Integer cost) {
        this.ID = ID;
        this.name = name;
        this.category = category;
        this.cost = cost;
    }

    public Item() {
    }

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Integer getCost() {
        return cost;
    }

    public void setCost(Integer cost) {
        this.cost = cost;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return Objects.equals(ID, item.ID) && Objects.equals(name, item.name) && Objects.equals(category, item.category) && Objects.equals(cost, item.cost);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ID, name, category, cost);
    }

    @Override
    public String toString() {
        return "Item{" +
                "ID=" + ID +
                ", name='" + name + '\'' +
                ", category='" + category + '\'' +
                ", cost=" + cost +
                '}';
    }
}
