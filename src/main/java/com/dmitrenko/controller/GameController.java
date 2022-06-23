package com.dmitrenko.controller;

import com.dmitrenko.DTO.GameDTO;
import com.dmitrenko.domain.Game;
import com.dmitrenko.mapper.AbstractMapper;
import com.dmitrenko.mapper.GameMapper;
import com.dmitrenko.service.AbstractService;
import com.dmitrenko.service.GameService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping(value = "/games")
@RestController
@AllArgsConstructor
public class GameController extends AbstractController<Game, GameDTO, Integer> {
    private GameService gameService;
    private GameMapper gameMapper;

    @Override
    protected AbstractService<Game, Integer> getService() {
        return gameService;
    }

    @Override
    protected AbstractMapper<Game, GameDTO> getMapper() {
        return gameMapper;
    }
}
