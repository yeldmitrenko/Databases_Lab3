package com.dmitrenko.service;

import com.dmitrenko.domain.Message;
import com.dmitrenko.repository.MessageRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class MessageService extends AbstractService<Message, Integer> {
    public MessageRepository messageRepository;

    @Override
    protected JpaRepository<Message, Integer> getRepository() {
        return messageRepository;
    }
}
