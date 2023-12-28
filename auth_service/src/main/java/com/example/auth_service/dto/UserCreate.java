package com.example.auth_service.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserCreate {
    private String email;
    private String password;
    private String rePassword;
    private String fullname;
}
