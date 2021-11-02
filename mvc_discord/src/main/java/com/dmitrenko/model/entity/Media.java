package com.dmitrenko.model.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Media {

    private Integer id;
    private String name;
    private Double size;
    private Integer date;
    private Integer gameChatId;

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
    public String toString() {
        return "\n\nMedia: id: " + id + ", name: " + name + ", size: " + size +
                ", date: " + date + ", game chat id: " + gameChatId;
    }
}
