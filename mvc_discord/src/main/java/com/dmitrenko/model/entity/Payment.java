package com.dmitrenko.model.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Payment {

    private Integer id;
    private Long cardNumber;
    private Integer expirationDate;
    private Integer cvc;
    private String name;

    public Payment(Integer id, Long cardNumber, Integer expirationDate, Integer cvc, String name) {
        this.id = id;
        this.cardNumber = cardNumber;
        this.expirationDate = expirationDate;
        this.cvc = cvc;
        this.name = name;
    }

    public Payment(Long cardNumber, Integer expirationDate, Integer cvc, String name) {
        this(null, cardNumber, expirationDate, cvc, name);
    }

    @Override
    public String toString() {
        return "\nPayment: card number: " + cardNumber + ", expiration date: "
                + expirationDate + ", cvc: " + cvc + ", name: " + name;
    }
}
