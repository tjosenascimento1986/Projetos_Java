package com.login.login.model;

import jakarta.persistence.*;

@Entity
@Table(name = "usuarios")
public class User {
    @Id()
    private String username;
    private char[] senha= new char[16];

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public char[] getSenha() {
        return senha;
    }

    public void setSenha(char[] senha) {
        this.senha = senha;
    }
}
