package com.dmitrenko.service.implementation;

import com.dmitrenko.model.dao.implementation.SecurityDAO;
import com.dmitrenko.model.entity.Security;
import com.dmitrenko.service.AbstractService;

import java.sql.SQLException;
import java.util.List;

public class SecurityService implements AbstractService<Security> {
    private final SecurityDAO dao = new SecurityDAO();

    @Override
    public List<Security> findAll() throws SQLException {
        return dao.findAll();
    }

    @Override
    public Security findByLogin(String login) throws SQLException {
        return dao.findByLogin(login);
    }

    @Override
    public void create(Security entity) throws SQLException {
        dao.create(entity);
    }

    @Override
    public void update(String login, Security entity) throws SQLException {
        dao.update(login, entity);
    }

    @Override
    public void delete(String login) throws SQLException {
        dao.delete(login);
    }
}
