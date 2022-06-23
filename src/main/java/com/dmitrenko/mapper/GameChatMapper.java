package com.dmitrenko.mapper;

import com.dmitrenko.DTO.GameChatDTO;
import com.dmitrenko.domain.GameChat;
import org.springframework.stereotype.Component;

@Component
public class GameChatMapper extends AbstractMapper<GameChat, GameChatDTO> {

    @Override
    public GameChatDTO mapObjectToDTO(GameChat gameChat) {
        if (gameChat == null) {
            return null;
        }

        GameChatDTO.GameChatDTOBuilder gameChatDTO = GameChatDTO.builder();
        gameChatDTO.id(gameChat.getId());
        gameChatDTO.name(gameChat.getName());
        gameChatDTO.gameId(gameChat.getGameId());

        return gameChatDTO.build();
    }
}
