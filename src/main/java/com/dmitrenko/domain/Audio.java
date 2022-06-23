package com.dmitrenko.domain;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Audio {

    private Integer id;
    private Integer duration;
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
    @Column(name = "duration")
    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    @Basic
    @Column(name = "game_chat_id")
    public Integer getGameChatId() {
        return gameChatId;
    }

    public void setGameChatId(Integer gameChatId) {
        this.gameChatId = gameChatId;
    }

    public Audio() {

    }

    public Audio(Integer id, Integer duration, Integer gameChatId) {
        this.id = id;
        this.duration = duration;
        this.gameChatId = gameChatId;
    }

    public Audio(Integer duration, Integer gameChatId) {
        this(null, duration, gameChatId);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Audio)) return false;
        Audio audio = (Audio) o;
        return getId().equals(audio.getId()) && getDuration().equals(audio.getDuration()) &&
                getGameChatId().equals(audio.getGameChatId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getDuration(), getGameChatId());
    }

    @Override
    public String toString() {
        return "\nAudio\n{" +
                "id=" + id +
                ", duration=" + duration +
                ", gameChatId=" + gameChatId +
                '}';
    }
}
