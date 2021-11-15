package com.dmitrenko.service.implementation;

import com.dmitrenko.model.dao.implementation.GameChatDAO;
import com.dmitrenko.model.entity.GameChat;
import com.dmitrenko.service.AbstractService;

import java.sql.SQLException;
import java.util.List;

public class GameChatService implements AbstractService<GameChat> {

    private final GameChatDAO dao = new GameChatDAO();

    @Override
    public List<GameChat> findAll() throws SQLException {
        return dao.findAll();
    }

    @Override
    public GameChat findById(Integer id) throws SQLException {
        return dao.findById(id);
    }

    @Override
    public void create(GameChat entity) throws SQLException {
        dao.create(entity);
    }

    @Override
    public void update(Integer id, GameChat entity) throws SQLException {
        dao.update(id, entity);
    }

    @Override
    public void delete(Integer id) throws SQLException {
        dao.delete(id);
    }
}
