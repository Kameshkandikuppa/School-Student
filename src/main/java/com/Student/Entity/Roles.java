package com.Student.Entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="roles")
  
public class Roles {
     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
    
     private int id;
     @Column(name="name")
     private String name;

     @ManyToMany(cascade = { CascadeType.MERGE, CascadeType.PERSIST })
     private List<Screen> screen;

    public Roles() {    
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Screen> getScreen() {
        return screen;
    }

    public void setScreen(List<Screen> screen) {
        this.screen = screen;
    }
}