package com.dmitrenko.controller;

import com.dmitrenko.DTO.MediaDTO;
import com.dmitrenko.domain.Media;
import com.dmitrenko.mapper.AbstractMapper;
import com.dmitrenko.mapper.MediaMapper;
import com.dmitrenko.service.AbstractService;
import com.dmitrenko.service.MediaService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping(value = "/media")
@RestController
@AllArgsConstructor
public class MediaController extends AbstractController<Media, MediaDTO, Integer> {
    private final MediaService mediaService;
    private final MediaMapper mediaMapper;

    @Override
    protected AbstractService<Media, Integer> getService() {
        return mediaService;
    }

    @Override
    protected AbstractMapper<Media, MediaDTO> getMapper() {
        return mediaMapper;
    }
}
