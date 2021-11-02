package com.dmitrenko.model.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class User {

    private Integer id;
    private String name;
    private String surname;
    private String username;
    private String phoneNumber;
    private String inform;
    private Integer gameChatId;
    private Integer paymentId;
    private String securityLogin;

    public User(Integer id, String name, String surname, String username, String phoneNumber,
                String inform, Integer gameChatId, Integer paymentId, String securityLogin) {
        this.id = id;
        this.name = name;
        this.surname =  surname;
        this.username = username;
        this.phoneNumber = phoneNumber;
        this.inform = inform;
        this.gameChatId = gameChatId;
        this.paymentId = paymentId;
        this.securityLogin = securityLogin;
    }

    public User(String name, String surname, String username, String phoneNumber, String inform,
                Integer gameChatId, Integer paymentId, String securityLogin) {
        this(null, name, null, username, phoneNumber, null, gameChatId, paymentId, securityLogin);
    }

    @Override
    public String toString() {
        return "\n\nUser: id: " + id + ", name: " + name + ", surname: " + surname + ", username: " + username +
                ", phone number: " + phoneNumber + ", information: " + inform + ", game chat id: " + gameChatId +
                ", payment id: " + paymentId + ", security login: " + securityLogin;
    }
}
