package com.dmitrenko.service;

import com.dmitrenko.domain.Payment;
import com.dmitrenko.repository.PaymentRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PaymentService extends AbstractService<Payment, Integer> {
    public PaymentRepository paymentRepository;

    @Override
    protected JpaRepository<Payment, Integer> getRepository() {
        return paymentRepository;
    }
}
