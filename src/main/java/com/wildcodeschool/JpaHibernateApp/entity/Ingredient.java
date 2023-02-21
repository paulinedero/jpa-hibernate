package com.wildcodeschool.JpaHibernateApp.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Ingredient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(mappedBy = "ingredient", cascade = CascadeType.ALL)
    private List<PotionIngredient> potionIngredients = new ArrayList<>();


    public Ingredient() {
        id=0L;
        setName("");
        potionIngredients = new ArrayList<PotionIngredient>();
    }

    public Ingredient (String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<PotionIngredient> getPotionIngredients() {
        return potionIngredients;
    }

    public void setPotionIngredients(List<PotionIngredient> potionIngredients) {
        this.potionIngredients = potionIngredients;
    }
}
