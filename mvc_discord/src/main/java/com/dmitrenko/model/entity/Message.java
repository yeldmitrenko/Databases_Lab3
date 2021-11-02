package com.dmitrenko.model.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Message {

    private Integer id;
    private Integer date;
    private String message;
    private Integer gameChatId;

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
    public String toString() {
        return "\n\nMessage: id: " + id + ", date: " + date + ", message: "
                + message + ", game chat id: " + gameChatId;
    }
}
