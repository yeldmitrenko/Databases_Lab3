package com.dmitrenko.service.implementation;

import com.dmitrenko.model.dao.implementation.GameDAO;
import com.dmitrenko.model.entity.Game;
import com.dmitrenko.service.AbstractService;

import java.sql.SQLException;
import java.util.List;

public class GameService implements AbstractService<Game> {

    private final GameDAO dao = new GameDAO();

    @Override
    public List<Game> findAll() throws SQLException {
        return dao.findAll();
    }

    @Override
    public Game findById(Integer id) throws SQLException {
        return dao.findById(id);
    }

    @Override
    public void create(Game entity) throws SQLException {
        dao.create(entity);
    }

    @Override
    public void update(Integer id, Game entity) throws SQLException {
        dao.update(id, entity);
    }

    @Override
    public void delete(Integer id) throws SQLException {
        dao.delete(id);
    }
}
