package com.dmitrenko.service;

import com.dmitrenko.domain.Security;
import com.dmitrenko.repository.SecurityRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class SecurityService extends AbstractService<Security, String> {
    public SecurityRepository securityRepository;

    @Override
    protected JpaRepository<Security, String> getRepository() {
        return securityRepository;
    }
}
