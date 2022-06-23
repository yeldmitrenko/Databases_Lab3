package com.dmitrenko.domain;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Media {

    private Integer id;
    private String name;
    private Double size;
    private Integer date;
    private Integer gameChatId;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
    @Column(name = "size")
    public Double getSize() {
        return size;
    }

    public void setSize(Double size) {
        this.size = size;
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
    @Column(name = "game_chat_id")
    public Integer getGameChatId() {
        return gameChatId;
    }

    public void setGameChatId(Integer gameChatId) {
        this.gameChatId = gameChatId;
    }

    public Media() {
    }

    public Media(Integer id, String name, Double size, Integer date, Integer gameChatId) {
        this.id = id;
        this.name = name;
        this.size = size;
        this.date = date;
        this.gameChatId = gameChatId;
    }

    public Media(String name, Double size, Integer date, Integer gameChatId) {
        this(null, name, size, date, gameChatId);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Media)) return false;
        Media media = (Media) o;
        return getId().equals(media.getId()) && getName().equals(media.getName()) && getSize().equals(media.getSize())
                && getDate().equals(media.getDate()) && getGameChatId().equals(media.getGameChatId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getSize(), getDate(), getGameChatId());
    }

    @Override
    public String toString() {
        return "\nMedia\n{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", size=" + size +
                ", date=" + date +
                ", gameChatId=" + gameChatId +
                '}';
    }
}
