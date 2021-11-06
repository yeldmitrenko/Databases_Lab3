package com.dmitrenko.controller.implementation;

import com.dmitrenko.controller.AbstractController;
import com.dmitrenko.model.dao.implementation.AudioDAO;
import com.dmitrenko.model.entity.Audio;
import com.dmitrenko.model.entity.Media;
import com.dmitrenko.service.implementation.MediaService;

import java.sql.SQLException;
import java.util.List;

public class MediaController implements AbstractController<Media> {

    MediaService service = new MediaService();

    @Override
    public List<Media> findAll() throws SQLException {
        return service.findAll();
    }

    @Override
    public Media findById(Integer id) throws SQLException {
        return service.findById(id);
    }

    @Override
    public void create(Media entity) throws SQLException {
        service.create(entity);
    }

    @Override
    public void update(Integer id, Media entity) throws SQLException {
        service.update(id, entity);
    }

    @Override
    public void delete(Integer id) throws SQLException {
        service.delete(id);
    }
}
