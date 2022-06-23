package com.dmitrenko.service;

import com.dmitrenko.domain.Game;
import com.dmitrenko.repository.GameRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class GameService extends AbstractService<Game, Integer> {
    public GameRepository gameRepository;

    @Override
    protected JpaRepository<Game, Integer> getRepository() {
        return gameRepository;
    }
}
