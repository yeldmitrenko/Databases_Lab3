package com.dmitrenko.service.implementation;

import com.dmitrenko.model.dao.implementation.MessageDAO;
import com.dmitrenko.model.entity.Message;
import com.dmitrenko.service.AbstractService;

import java.sql.SQLException;
import java.util.List;

public class MessageService implements AbstractService<Message> {

    MessageDAO dao = new MessageDAO();

    @Override
    public List<Message> findAll() throws SQLException {
        return dao.findAll();
    }

    @Override
    public Message findById(Integer id) throws SQLException {
        return dao.findById(id);
    }

    @Override
    public void create(Message entity) throws SQLException {
        dao.create(entity);
    }

    @Override
    public void update(Integer id, Message entity) throws SQLException {
        dao.update(id, entity);
    }

    @Override
    public void delete(Integer id) throws SQLException {
        dao.delete(id);
    }
}
