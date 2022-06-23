package com.dmitrenko.mapper;

import com.dmitrenko.DTO.PaymentDTO;
import com.dmitrenko.domain.Payment;
import org.springframework.stereotype.Component;

@Component
public class PaymentMapper extends AbstractMapper<Payment, PaymentDTO> {

    @Override
    public PaymentDTO mapObjectToDTO(Payment payment) {
        if (payment == null) {
            return null;
        }

        PaymentDTO.PaymentDTOBuilder paymentDTO = PaymentDTO.builder();
        paymentDTO.id(payment.getId());
        paymentDTO.cardNumber(payment.getCardNumber());
        paymentDTO.expirationDate(payment.getExpirationDate());
        paymentDTO.cvc(payment.getCvc());
        paymentDTO.name(payment.getName());

        return paymentDTO.build();
    }
}
