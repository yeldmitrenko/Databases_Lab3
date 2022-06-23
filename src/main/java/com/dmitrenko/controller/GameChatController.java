package com.dmitrenko.controller;

import com.dmitrenko.DTO.GameChatDTO;
import com.dmitrenko.domain.GameChat;
import com.dmitrenko.mapper.AbstractMapper;
import com.dmitrenko.mapper.GameChatMapper;
import com.dmitrenko.service.AbstractService;
import com.dmitrenko.service.GameChatService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping(value = "/game_chats")
@RestController
@AllArgsConstructor
public class GameChatController extends AbstractController<GameChat, GameChatDTO, Integer> {
    private final GameChatService gameChatService;
    private final GameChatMapper gameChatMapper;

    @Override
    protected AbstractService<GameChat, Integer> getService() {
        return gameChatService;
    }

    @Override
    protected AbstractMapper<GameChat, GameChatDTO> getMapper() {
        return gameChatMapper;
    }
}
