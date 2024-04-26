package com.example.Restful_Demo.Modul;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.NonNull;

import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "users")
public class Member {
    @Id
    @Column(name = "id")
    private String id;
    @NonNull
    @Column(name = "email")
    private String email;
    @NonNull
    @Column(name = "password")
    private String password;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}