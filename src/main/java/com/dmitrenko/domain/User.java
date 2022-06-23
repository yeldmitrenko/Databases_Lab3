package com.dmitrenko.domain;

import javax.persistence.*;
import java.util.Objects;

@Entity
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

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "surname")
    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    @Basic
    @Column(name = "username")
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Basic
    @Column(name = "phone_number")
    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Basic
    @Column(name = "inform")
    public String getInform() {
        return inform;
    }

    public void setInform(String inform) {
        this.inform = inform;
    }

    @Basic
    @Column(name = "game_chat_id")
    public Integer getGameChatId() {
        return gameChatId;
    }

    public void setGameChatId(Integer gameChatId) {
        this.gameChatId = gameChatId;
    }

    @Basic
    @Column(name = "payment_id")
    public Integer getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(Integer paymentId) {
        this.paymentId = paymentId;
    }

    @Basic
    @Column(name = "security_login")
    public String getSecurityLogin() {
        return securityLogin;
    }

    public void setSecurityLogin(String securityLogin) {
        this.securityLogin = securityLogin;
    }

    public User() {
    }

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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return getId().equals(user.getId()) && getName().equals(user.getName()) && Objects.equals(getSurname(),
                user.getSurname()) && getUsername().equals(user.getUsername())
                && getPhoneNumber().equals(user.getPhoneNumber()) && Objects.equals(getInform(), user.getInform())
                && getGameChatId().equals(user.getGameChatId()) && getPaymentId().equals(user.getPaymentId())
                && getSecurityLogin().equals(user.getSecurityLogin());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getSurname(), getUsername(), getPhoneNumber(), getInform(),
                getGameChatId(), getPaymentId(), getSecurityLogin());
    }

    @Override
    public String toString() {
        return "\nUser\n{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", username='" + username + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", inform='" + inform + '\'' +
                ", gameChatId=" + gameChatId +
                ", paymentId=" + paymentId +
                ", securityLogin='" + securityLogin + '\'' +
                '}';
    }
}
