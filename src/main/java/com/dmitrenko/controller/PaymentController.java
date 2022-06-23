package com.dmitrenko.controller;

import com.dmitrenko.DTO.PaymentDTO;
import com.dmitrenko.domain.Payment;
import com.dmitrenko.mapper.AbstractMapper;
import com.dmitrenko.mapper.PaymentMapper;
import com.dmitrenko.service.AbstractService;
import com.dmitrenko.service.PaymentService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping(value = "/payment")
@RestController
@AllArgsConstructor
public class PaymentController extends AbstractController<Payment, PaymentDTO, Integer> {
    private final PaymentService paymentService;
    private final PaymentMapper paymentMapper;

    @Override
    protected AbstractService<Payment, Integer> getService() {
        return paymentService;
    }

    @Override
    protected AbstractMapper<Payment, PaymentDTO> getMapper() {
        return paymentMapper;
    }
}
