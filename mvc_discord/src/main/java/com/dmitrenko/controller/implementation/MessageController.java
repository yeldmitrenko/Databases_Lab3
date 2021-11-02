package com.dmitrenko.controller.implementation;

import com.dmitrenko.controller.AbstractController;
import com.dmitrenko.model.entity.Message;
import com.dmitrenko.service.implementation.MessageService;

import java.sql.SQLException;
import java.util.List;

public class MessageController implements AbstractController<Message> {

    MessageService service = new MessageService();

    @Override
    public List<Message> findAll() throws SQLException {
        return service.findAll();
    }

    @Override
    public Message findById(Integer id) throws SQLException {
        return service.findById(id);
    }

    @Override
    public void create(Message entity) throws SQLException {
        service.create(entity);
    }

    @Override
    public void update(Integer id, Message entity) throws SQLException {
        service.update(id, entity);
    }

    @Override
    public void delete(Integer id) throws SQLException {
        service.delete(id);
    }
}
