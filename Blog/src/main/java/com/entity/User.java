package com.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by vicriss on 2015/09/10.
 */
@Entity
@Table(name = "admin")
public class User {
    private int id;
    private String name;
    private String password;
    @JsonIgnore
    private List<UserArticle> userArticles = new ArrayList<UserArticle>();

    @Id
    @JoinColumn(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @JoinColumn(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @JoinColumn(name = "password")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Column(name = "user_id")
    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
    public List<UserArticle> getUserArticles() {
        return userArticles;
    }

    public void setUserArticles(List<UserArticle> userArticles) {
        this.userArticles = userArticles;
    }
}
