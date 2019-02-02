package com.example.springbootfun.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.List;

@Entity
public class Role {
    @Id
    private String fullName;
    @ManyToMany(mappedBy = "roles")
    private List<User> user;

    public Role() { }

    public Role(String fullName) {
        this.fullName = fullName;
    }

    public Role(String fullName, List<User> user) {
        this.fullName = fullName;
        this.user = user;
    }

    public String getName() {
        return fullName;
    }

    public void setName(String fullName) {
        this.fullName = fullName;
    }

    public List<User> getUser() {
        return user;
    }

    public void setUser(List<User> user) {
        this.user = user;
    }
}
