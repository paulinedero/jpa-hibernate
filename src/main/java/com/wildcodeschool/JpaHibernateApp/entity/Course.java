package com.wildcodeschool.JpaHibernateApp.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title")
    private String title;

    @ManyToMany(mappedBy = "courses")
    private List<Wizard> wizards = new ArrayList<>();

    public Course() {
        id = 0L;
        setTitle("");
        setWizards(null);
    }

    public Course(String title) {
        id = 0L;
        setTitle(title);
        setWizards(null);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Wizard> getWizards() {
        return wizards;
    }

    public void setWizards(List<Wizard> wizards) {
        this.wizards = wizards;
    }
}
