package com.dmitrenko.controller;


import com.dmitrenko.DTO.AudioDTO;
import com.dmitrenko.domain.Audio;
import com.dmitrenko.mapper.AbstractMapper;
import com.dmitrenko.mapper.AudioMapper;
import com.dmitrenko.service.AbstractService;
import com.dmitrenko.service.AudioService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping(value = "/audio_files")
@RestController
@AllArgsConstructor
public class AudioController extends AbstractController<Audio, AudioDTO, Integer> {
    private final AudioService audioService;
    private final AudioMapper audioMapper;

    @Override
    protected AbstractService<Audio, Integer> getService() {
        return audioService;
    }

    @Override
    protected AbstractMapper<Audio, AudioDTO> getMapper() {
        return audioMapper;
    }
}
