package com.oaes.instrument_service.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int authorId;

    private String username;
    private String password;

    @OneToMany(mappedBy = "author")@JsonIgnore
    List<Item> items = new ArrayList<Item>();

    public Author() {}

    public Author(int authorId, String username, String password, List<Item> items) {
        this.authorId = authorId;
        this.username = username;
        this.password = password;
        this.items = items;
    }

    public int getAuthorId() {
        return authorId;
    }

    public void setAuthorId(int authorId) {
        this.authorId = authorId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }
}
