package com.dmitrenko.service;

import com.dmitrenko.domain.Media;
import com.dmitrenko.repository.MediaRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class MediaService extends AbstractService<Media, Integer> {
    public MediaRepository mediaRepository;

    @Override
    protected JpaRepository<Media, Integer> getRepository() {
        return mediaRepository;
    }
}
