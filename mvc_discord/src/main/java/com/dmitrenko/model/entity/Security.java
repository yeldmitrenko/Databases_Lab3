package com.dmitrenko.model.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Security {

    private String login;
    private String password;

    public Security(String login, String password) {
        this.login = login;
        this.password = password;
    }

    @Override
    public String toString() {
        return "\nSecurity: login: " + login + ", password: " + password;
    }
}
