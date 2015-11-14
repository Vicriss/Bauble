package com.entity;

import javax.persistence.*;

/**
 * Created by vicriss on 2015/09/21.
 */
@Entity
@Table(name = "user_art")
public class UserArticle {

    private int id;
    private User user;
    private Article article;

    public UserArticle(){}

    public UserArticle(User user, Article article) {
        this.user = user;
        this.article = article;
    }

    @Id
    @GeneratedValue
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @JoinColumn(name = "user_id")
    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @JoinColumn(name = "art_id")
    @ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    public Article getArticle() {
        return article;
    }

    public void setArticle(Article article) {
        this.article = article;
    }
}
