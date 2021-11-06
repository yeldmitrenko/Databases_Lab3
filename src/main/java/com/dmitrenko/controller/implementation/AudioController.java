package com.dmitrenko.controller.implementation;

import com.dmitrenko.controller.AbstractController;
import com.dmitrenko.model.entity.Audio;
import com.dmitrenko.service.implementation.AudioService;

import java.sql.SQLException;
import java.util.List;

public class AudioController implements AbstractController<Audio> {

    AudioService service = new AudioService();

    @Override
    public List<Audio> findAll() throws SQLException {
        return service.findAll();
    }

    @Override
    public Audio findById(Integer id) throws SQLException {
        return service.findById(id);
    }

    @Override
    public void create(Audio entity) throws SQLException {
        service.create(entity);
    }

    @Override
    public void update(Integer id, Audio entity) throws SQLException {
        service.update(id, entity);
    }

    @Override
    public void delete(Integer id) throws SQLException {
        service.delete(id);
    }
}
