package com.dmitrenko.service.implementation;

import com.dmitrenko.model.dao.implementation.AudioDAO;
import com.dmitrenko.model.entity.Audio;
import com.dmitrenko.service.AbstractService;

import java.sql.SQLException;
import java.util.List;

public class AudioService implements AbstractService<Audio> {

    AudioDAO dao = new AudioDAO();

    @Override
    public List<Audio> findAll() throws SQLException {
        return dao.findAll();
    }

    @Override
    public Audio findById(Integer id) throws SQLException {
        return dao.findById(id);
    }

    @Override
    public void create(Audio entity) throws SQLException {
        dao.create(entity);
    }

    @Override
    public void update(Integer id, Audio entity) throws SQLException {
        dao.update(id, entity);
    }

    @Override
    public void delete(Integer id) throws SQLException {
        dao.delete(id);
    }
}
