package com.dmitrenko.service;

import com.dmitrenko.domain.GameChat;
import com.dmitrenko.repository.GameChatRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class GameChatService extends AbstractService<GameChat, Integer> {
    public GameChatRepository gameChatRepository;

    @Override
    protected JpaRepository<GameChat, Integer> getRepository() {
        return gameChatRepository;
    }
}
