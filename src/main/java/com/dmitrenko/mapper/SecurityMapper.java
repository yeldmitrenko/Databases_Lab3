package com.dmitrenko.mapper;

import com.dmitrenko.DTO.SecurityDTO;
import com.dmitrenko.domain.Security;
import org.springframework.stereotype.Component;

@Component
public class SecurityMapper extends AbstractMapper<Security, SecurityDTO> {

    @Override
    public SecurityDTO mapObjectToDTO(Security security) {
        if (security == null) {
            return null;
        }

        SecurityDTO.SecurityDTOBuilder securityDTO = SecurityDTO.builder();
        securityDTO.login(security.getLogin());
        securityDTO.password(security.getPassword());

        return securityDTO.build();
    }
}
