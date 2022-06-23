package com.dmitrenko.mapper;

import com.dmitrenko.DTO.MediaDTO;
import com.dmitrenko.domain.Media;
import org.springframework.stereotype.Component;

@Component
public class MediaMapper extends AbstractMapper<Media, MediaDTO> {

    @Override
    public MediaDTO mapObjectToDTO(Media media) {
        if (media == null) {
            return null;
        }

        MediaDTO.MediaDTOBuilder mediaDTO = MediaDTO.builder();
        mediaDTO.id(media.getId());
        mediaDTO.name(media.getName());
        mediaDTO.size(media.getSize());
        mediaDTO.date(media.getDate());
        mediaDTO.gameChatId(media.getGameChatId());

        return mediaDTO.build();
    }
}
