package com.Student.Entity;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "screen")

public class Screen {
   
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
   
    @ManyToMany(mappedBy = "screen")
    @JsonIgnore
    
    private List<Roles> roles;
    
    public Screen() {
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
    public List<Roles> getRoles() {
        return roles;
    }
    public void setRoles(List<Roles> roles) {
        this.roles = roles;
    }
}