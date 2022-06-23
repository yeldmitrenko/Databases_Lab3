package com.dmitrenko.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDTO {
    private Integer id;
    private String name;
    private String surname;
    private String username;
    private String phoneNumber;
    private String inform;
    private Integer gameChatId;
    private Integer paymentId;
    private String securityLogin;
}
