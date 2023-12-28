package com.example.auth_service.dto;

import com.example.auth_service.models.Role;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class UserUpdate {
    private String email;
    private String password;
    private String newPassword;
    private String reNewPassword;
    private String fullname;
    private List<Role> roles;
}
