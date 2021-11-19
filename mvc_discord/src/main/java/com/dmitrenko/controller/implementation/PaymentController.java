package com.dmitrenko.controller.implementation;

import com.dmitrenko.controller.AbstractController;
import com.dmitrenko.model.entity.Payment;
import com.dmitrenko.service.implementation.PaymentService;

import java.sql.SQLException;
import java.util.List;

public class PaymentController implements AbstractController<Payment> {

    PaymentService service = new PaymentService();

    @Override
    public List<Payment> findAll() throws SQLException {
        return service.findAll();
    }

    @Override
    public Payment findById(Integer id) throws SQLException {
        return (Payment) service.findById(id);
    }

    @Override
    public void create(Payment entity) throws SQLException {
        service.create(entity);
    }

    @Override
    public void update(Integer id, Payment entity) throws SQLException {
        service.update(id, entity);
    }

    @Override
    public void delete(Integer id) throws SQLException {
        service.delete(id);
    }
}
