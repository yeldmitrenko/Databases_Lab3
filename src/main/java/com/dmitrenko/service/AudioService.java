package com.dmitrenko.service;

import com.dmitrenko.domain.Audio;
import com.dmitrenko.repository.AudioRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AudioService extends AbstractService<Audio, Integer>{
    public AudioRepository audioRepository;

    @Override
    protected JpaRepository<Audio, Integer> getRepository() {
        return audioRepository;
    }
}
