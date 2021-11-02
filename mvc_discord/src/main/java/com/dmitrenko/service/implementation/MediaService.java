package com.dmitrenko.service.implementation;

import com.dmitrenko.model.dao.implementation.AudioDAO;
import com.dmitrenko.model.dao.implementation.MediaDAO;
import com.dmitrenko.model.entity.Audio;
import com.dmitrenko.model.entity.Media;
import com.dmitrenko.service.AbstractService;

import java.sql.SQLException;
import java.util.List;

public class MediaService implements AbstractService<Media> {

    MediaDAO dao = new MediaDAO();

    @Override
    public List<Media> findAll() throws SQLException {
        return dao.findAll();
    }

    @Override
    public Media findById(Integer id) throws SQLException {
        return dao.findById(id);
    }

    @Override
    public void create(Media entity) throws SQLException {
        dao.create(entity);
    }

    @Override
    public void update(Integer id, Media entity) throws SQLException {
        dao.update(id, entity);
    }

    @Override
    public void delete(Integer id) throws SQLException {
        dao.delete(id);
    }
}
