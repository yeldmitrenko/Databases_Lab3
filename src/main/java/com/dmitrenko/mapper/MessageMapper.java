package com.dmitrenko.mapper;

import com.dmitrenko.DTO.MessageDTO;
import com.dmitrenko.domain.Message;
import org.springframework.stereotype.Component;

@Component
public class MessageMapper extends AbstractMapper<Message, MessageDTO> {

    @Override
    public MessageDTO mapObjectToDTO(Message messages) {
        if (messages == null) {
            return null;
        }

        MessageDTO.MessageDTOBuilder messageDTO = MessageDTO.builder();
        messageDTO.id(messages.getId());
        messageDTO.date(messages.getDate());
        messageDTO.message(messages.getMessage());
        messageDTO.gameChatId(messages.getGameChatId());

        return messageDTO.build();
    }
}
