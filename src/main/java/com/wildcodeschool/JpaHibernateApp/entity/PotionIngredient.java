package com.wildcodeschool.JpaHibernateApp.entity;

import javax.persistence.*;

@Entity

public class PotionIngredient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "potion_id")
    private Potion potion;

    @ManyToOne
    @JoinColumn(name = "ingredient_id")
    private Ingredient ingredient;


    private Integer quantity;


    public PotionIngredient() {
        id=0L;
        setPotion(null);
        setIngredient(null);
        setQuantity(0);
    }

    public PotionIngredient (Potion potion, Ingredient ingredient, Integer quantity) {
        this.potion = potion;
        this.ingredient = ingredient;
        this.quantity = quantity;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Potion getPotion() {
        return potion;
    }

    public void setPotion(Potion potion) {
        this.potion = potion;
    }

    public Ingredient getIngredient() {
        return ingredient;
    }

    public void setIngredient(Ingredient ingredient) {
        this.ingredient = ingredient;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
