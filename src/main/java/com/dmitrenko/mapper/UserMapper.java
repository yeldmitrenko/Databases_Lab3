package com.dmitrenko.mapper;

import com.dmitrenko.DTO.UserDTO;
import com.dmitrenko.domain.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper extends AbstractMapper<User, UserDTO> {

    @Override
    public UserDTO mapObjectToDTO(User user) {
        if (user == null) {
            return null;
        }

        UserDTO.UserDTOBuilder userDTO = UserDTO.builder();
        userDTO.id(user.getId());
        userDTO.name(user.getName());
        userDTO.surname(user.getSurname());
        userDTO.username(user.getUsername());
        userDTO.phoneNumber(user.getPhoneNumber());
        userDTO.inform(user.getInform());
        userDTO.gameChatId(user.getGameChatId());
        userDTO.paymentId(user.getPaymentId());
        userDTO.securityLogin(user.getSecurityLogin());

        return userDTO.build();
    }
}
