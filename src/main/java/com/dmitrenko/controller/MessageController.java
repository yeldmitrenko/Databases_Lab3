package com.dmitrenko.controller;

import com.dmitrenko.DTO.MessageDTO;
import com.dmitrenko.domain.Message;
import com.dmitrenko.mapper.AbstractMapper;
import com.dmitrenko.mapper.MessageMapper;
import com.dmitrenko.service.AbstractService;
import com.dmitrenko.service.MessageService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping(value = "/messages")
@RestController
@AllArgsConstructor
public class MessageController extends AbstractController<Message, MessageDTO, Integer> {
    private final MessageService messageService;
    private final MessageMapper messageMapper;

    @Override
    protected AbstractService<Message, Integer> getService() {
        return messageService;
    }

    @Override
    protected AbstractMapper<Message, MessageDTO> getMapper() {
        return messageMapper;
    }
}
