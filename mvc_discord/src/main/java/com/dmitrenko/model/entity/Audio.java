package com.dmitrenko.model.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Audio {

    private Integer id;
    private Integer duration;
    private Integer gameChatId;

    public Audio(Integer id, Integer duration, Integer gameChatId) {
        this.id = id;
        this.duration = duration;
        this.gameChatId = gameChatId;
    }

    public Audio(Integer duration, Integer gameChatId) {
        this(null, duration, gameChatId);
    }

    @Override
    public String toString() {
        return "\n\nAudio: id: " + id + ", duration: " + duration +
                ", game chat id: " + gameChatId;
    }
}
