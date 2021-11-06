package com.dmitrenko.controller.implementation;

import com.dmitrenko.controller.AbstractController;
import com.dmitrenko.model.entity.GameChat;
import com.dmitrenko.service.implementation.GameChatService;

import java.sql.SQLException;
import java.util.List;

public class GameChatController implements AbstractController<GameChat> {

    GameChatService service = new GameChatService();

    @Override
    public List<GameChat> findAll() throws SQLException {
        return service.findAll();
    }

    @Override
    public GameChat findById(Integer id) throws SQLException {
        return service.findById(id);
    }

    @Override
    public void create(GameChat entity) throws SQLException {
        service.create(entity);
    }

    @Override
    public void update(Integer id, GameChat entity) throws SQLException {
        service.update(id, entity);
    }

    @Override
    public void delete(Integer id) throws SQLException {
        service.delete(id);
    }
}
