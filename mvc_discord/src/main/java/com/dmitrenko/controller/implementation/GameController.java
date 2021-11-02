package com.dmitrenko.controller.implementation;

import com.dmitrenko.controller.AbstractController;
import com.dmitrenko.model.entity.Game;
import com.dmitrenko.service.implementation.GameService;

import java.sql.SQLException;
import java.util.List;

public class GameController implements AbstractController<Game> {

    GameService service = new GameService();

    @Override
    public List<Game> findAll() throws SQLException {
        return service.findAll();
    }

    @Override
    public Game findById(Integer id) throws SQLException {
        return service.findById(id);
    }

    @Override
    public void create(Game entity) throws SQLException {
        service.create(entity);
    }

    @Override
    public void update(Integer id, Game entity) throws SQLException {
        service.update(id, entity);
    }

    @Override
    public void delete(Integer id) throws SQLException {
        service.delete(id);
    }
}
