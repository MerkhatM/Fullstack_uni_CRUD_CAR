package com.example.auth_service.services;



import com.example.auth_service.models.Role;
import com.example.auth_service.repositories.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleService {
    @Autowired
    private RoleRepository roleRepository;

    public List<Role> getRoles(){
        return roleRepository.findAll();
    }
}
