package com.example.projectapp;

public class Users {


    String emaill,username,password;

    public Users() {
    }

    public Users(String emaill, String username, String password) {
        this.emaill = emaill;
        this.username = username;
        this.password = password;
    }

    public String getEmaill() {
        return emaill;
    }

    public void setEmaill(String emaill) {
        this.emaill = emaill;
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
}
