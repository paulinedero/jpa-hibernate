package com.wildcodeschool.JpaHibernateApp.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Potion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="name")
    private String name;

    @Column(name="power")
    private Integer power;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    @ManyToMany
    @JoinTable(
            name = "potion_effect",
            joinColumns = @JoinColumn(name = "potion_id"),
            inverseJoinColumns = @JoinColumn(name = "effect_id")
    )
    private List<Effect> effects = new ArrayList<>();

    @OneToMany(mappedBy = "potion", cascade = CascadeType.ALL)
    private List<PotionIngredient> potionIngredients = new ArrayList<>();

    public Potion() {
        id=0L;
        setName("");
        setPower(0);
        setCategory(null);
        effects = new ArrayList<Effect>();
        potionIngredients = new ArrayList<PotionIngredient>();
    }

    public Potion (String name, Integer power, Category category) {
        this.name = name;
        this.power = power;
        this.category = category;
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

    public Integer getPower() {
        return power;
    }

    public void setPower(Integer power) {
        this.power = power;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public List<Effect> getEffects() {
        return effects;
    }

    public void setEffects(List<Effect> effects) {
        this.effects = effects;
    }

    public List<PotionIngredient> getPotionIngredients() {
        return potionIngredients;
    }

    public void setPotionIngredients(List<PotionIngredient> potionIngredients) {
        this.potionIngredients = potionIngredients;
    }
}
