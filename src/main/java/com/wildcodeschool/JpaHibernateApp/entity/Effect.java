package com.wildcodeschool.JpaHibernateApp.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Effect {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String description;

    @ManyToMany(mappedBy = "effects")
    private List<Potion> potions = new ArrayList<>();

    public Effect() {
        id=0L;
        setDescription(description);
        potions = new ArrayList<Potion>();
    }

    public Effect(String description) {
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Potion> getPotions() {
        return potions;
    }

    public void setPotions(List<Potion> potions) {
        this.potions = potions;
    }
}
