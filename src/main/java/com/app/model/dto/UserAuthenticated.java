package com.app.model.dto;

import java.io.Serializable;

public class UserAuthenticated implements Serializable {

    private String email;

    private String token;

    public UserAuthenticated(String email, String token) {
        this.email = email;
        this.token = token;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
