package com.nosin.emberv2.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Entity
public class User {

    @Id
    @GeneratedValue
    private int id;

    @NotNull
    @Size(min = 3, max = 15)
    private String username;

    @NotNull
    @Size(min = 6)
    private String password;

    /* TODO: Add in role */

    public User() { }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUserEmname(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}