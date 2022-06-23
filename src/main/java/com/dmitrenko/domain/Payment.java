package com.dmitrenko.domain;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Payment {

    private Integer id;
    private Long cardNumber;
    private Integer expirationDate;
    private Integer cvc;
    private String name;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "card_number")
    public Long getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(Long cardNumber) {
        this.cardNumber = cardNumber;
    }

    @Basic
    @Column(name = "expiration_date")
    public Integer getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Integer expirationDate) {
        this.expirationDate = expirationDate;
    }

    @Basic
    @Column(name = "cvc")
    public Integer getCvc() {
        return cvc;
    }

    public void setCvc(Integer cvc) {
        this.cvc = cvc;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Payment() {
    }

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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Payment)) return false;
        Payment payment = (Payment) o;
        return getId().equals(payment.getId()) && getCardNumber().equals(payment.getCardNumber()) &&
                getExpirationDate().equals(payment.getExpirationDate()) && getCvc().equals(payment.getCvc()) &&
                getName().equals(payment.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getCardNumber(), getExpirationDate(), getCvc(), getName());
    }

    @Override
    public String toString() {
        return "\nPayment\n{" +
                "id=" + id +
                ", cardNumber=" + cardNumber +
                ", expirationDate=" + expirationDate +
                ", cvc=" + cvc +
                ", name='" + name + '\'' +
                "}";
    }
}
