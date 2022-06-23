package com.dmitrenko.domain;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Message {

    private Integer id;
    private Integer date;
    private String message;
    private Integer gameChatId;

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
    @Column(name = "date")
    public Integer getDate() {
        return date;
    }

    public void setDate(Integer date) {
        this.date = date;
    }

    @Basic
    @Column(name = "message")
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Basic
    @Column(name = "game_chat_id")
    public Integer getGameChatId() {
        return gameChatId;
    }

    public void setGameChatId(Integer gameChatId) {
        this.gameChatId = gameChatId;
    }

    public Message() {
    }

    public Message(Integer id, Integer date, String message, Integer gameChatId) {
        this.id = id;
        this.date = date;
        this.message = message;
        this.gameChatId = gameChatId;
    }

    public Message(Integer date, String message, Integer gameChatId) {
        this(null, date, message, gameChatId);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Message)) return false;
        Message message = (Message) o;
        return getId().equals(message.getId()) && getDate().equals(message.getDate()) &&
                getMessage().equals(message.getMessage()) && getGameChatId().equals(message.getGameChatId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getDate(), getMessage(), getGameChatId());
    }

    @Override
    public String toString() {
        return "\nMessage\n{" +
                "id=" + id +
                ", date=" + date +
                ", message='" + message + '\'' +
                ", gameChatId=" + gameChatId +
                '}';
    }
}
