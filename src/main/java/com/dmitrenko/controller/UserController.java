package com.dmitrenko.controller;

import com.dmitrenko.DTO.UserDTO;
import com.dmitrenko.domain.User;
import com.dmitrenko.mapper.AbstractMapper;
import com.dmitrenko.mapper.UserMapper;
import com.dmitrenko.service.AbstractService;
import com.dmitrenko.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping(value = "/users")
@RestController
@AllArgsConstructor
public class UserController extends AbstractController<User, UserDTO, Integer> {
    private final UserService userService;
    private final UserMapper userMapper;

    @Override
    protected AbstractService<User, Integer> getService() {
        return userService;
    }

    @Override
    protected AbstractMapper<User, UserDTO> getMapper() {
        return userMapper;
    }
}
