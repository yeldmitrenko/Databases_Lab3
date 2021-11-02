package com.dmitrenko.model.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GameChat {

    private Integer id;
    private String name;
    private Integer gameId;

    public GameChat(Integer id, String name, Integer gameId) {
        this.id = id;
        this.name = name;
        this.gameId = gameId;
    }

    public GameChat(String name, Integer gameId) {
        this(null, name, gameId);
    }

    @Override
    public String toString() {
        return "\n\nGame Chat: id: " + id + ", name: " + name + ", game id: " + gameId;
    }
}
