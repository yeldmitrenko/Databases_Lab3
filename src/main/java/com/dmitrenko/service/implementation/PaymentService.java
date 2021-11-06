package com.dmitrenko.service.implementation;

import com.dmitrenko.model.dao.implementation.PaymentDAO;
import com.dmitrenko.model.entity.Payment;
import com.dmitrenko.service.AbstractService;

import java.sql.SQLException;
import java.util.List;

public class PaymentService implements AbstractService<Payment> {

    private final PaymentDAO dao = new PaymentDAO();

    @Override
    public List<Payment> findAll() throws SQLException {
        return dao.findAll();
    }

    @Override
    public Payment findById(Integer id) throws SQLException {
        return dao.findById(id);
    }

    @Override
    public void create(Payment entity) throws SQLException {
        dao.create(entity);
    }

    @Override
    public void update(Integer id, Payment entity) throws SQLException {
        dao.update(id, entity);
    }

    @Override
    public void delete(Integer id) throws SQLException {
        dao.delete(id);
    }


}
