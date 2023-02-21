package com.wildcodeschool.JpaHibernateApp.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Entity
public class School {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "capacity")
    private int capacity;

    @Column(name = "country")
    private String country;

    @OneToMany(mappedBy = "school")
    private List<Wizard> wizards;


    public School() {
        id = 0L;
        setName("");
        setCapacity(0);
        setCountry("");
        wizards = new ArrayList<Wizard>();
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCapacity() {
        return this.capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public String getCountry() {
        return this.country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public List<Wizard> getWizards() {
        return wizards;
    }

    public void setWizards(List<Wizard> wizards) {
        this.wizards = wizards;
    }

    public void addWizard(Wizard wizard) {
        this.wizards.add(wizard);
    }
}
