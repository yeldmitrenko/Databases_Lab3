package com.dmitrenko.controller;

import com.dmitrenko.DTO.SecurityDTO;
import com.dmitrenko.domain.Security;
import com.dmitrenko.mapper.AbstractMapper;
import com.dmitrenko.mapper.SecurityMapper;
import com.dmitrenko.service.AbstractService;
import com.dmitrenko.service.SecurityService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping(value = "/security_data")
@RestController
@AllArgsConstructor
public class SecurityController extends AbstractController<Security, SecurityDTO, String> {
    private final SecurityService securityService;
    private final SecurityMapper securityMapper;

    @Override
    protected AbstractService<Security, String> getService() {
        return securityService;
    }

    @Override
    protected AbstractMapper<Security, SecurityDTO> getMapper() {
        return securityMapper;
    }
}
