package com.dmitrenko.mapper;

import com.dmitrenko.DTO.AudioDTO;
import com.dmitrenko.domain.Audio;
import org.springframework.stereotype.Component;

@Component
public class AudioMapper extends AbstractMapper<Audio, AudioDTO> {

    @Override
    public AudioDTO mapObjectToDTO(Audio audio) {
        if (audio == null) {
            return null;
        }

        AudioDTO.AudioDTOBuilder audioDTO = AudioDTO.builder();
        audioDTO.id(audio.getId());
        audioDTO.duration(audio.getDuration());
        audioDTO.gameChatId(audio.getGameChatId());

        return audioDTO.build();
    }
}
