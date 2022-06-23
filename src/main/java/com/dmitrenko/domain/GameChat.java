package com.dmitrenko.domain;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "game_chat", schema = "dmitrenko")
public class GameChat {

    private Integer id;
    private String name;
    private Integer gameId;

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
    @Column(name = "game_id")
    public Integer getGameId() {
        return gameId;
    }

    public void setGameId(Integer gameId) {
        this.gameId = gameId;
    }


    public GameChat() {
    }

    public GameChat(Integer id, String name, Integer gameId) {
        this.id = id;
        this.name = name;
        this.gameId = gameId;
    }

    public GameChat(String name, Integer gameId) {
        this(null, name, gameId);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof GameChat)) return false;
        GameChat gameChat = (GameChat) o;
        return getId().equals(gameChat.getId()) && getName().equals(gameChat.getName()) && getGameId().equals(gameChat.getGameId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getGameId());
    }

    @Override
    public String toString() {
        return "\nGameChat\n{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", gameId=" + gameId +
                '}';
    }
}
