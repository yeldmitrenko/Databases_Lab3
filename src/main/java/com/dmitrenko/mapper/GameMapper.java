package com.dmitrenko.mapper;

import com.dmitrenko.DTO.GameDTO;
import com.dmitrenko.domain.Game;
import org.springframework.stereotype.Component;

@Component
public class GameMapper extends AbstractMapper<Game, GameDTO> {

    @Override
    public GameDTO mapObjectToDTO(Game game) {
        if (game == null) {
            return null;
        }

        GameDTO.GameDTOBuilder gameDTO = GameDTO.builder();
        gameDTO.id(game.getId());
        gameDTO.name(game.getName());
        gameDTO.price(game.getPrice());
        gameDTO.category(game.getCategory());

        return gameDTO.build();
    }
}
