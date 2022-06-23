package com.dmitrenko.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PaymentDTO {
    private Integer id;
    private Long cardNumber;
    private Integer expirationDate;
    private Integer cvc;
    private String name;
}
