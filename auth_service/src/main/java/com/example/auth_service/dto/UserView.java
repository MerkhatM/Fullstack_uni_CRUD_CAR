package com.example.auth_service.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
public class UserView {
    private Long id;
    private String email;
    private String fullname;

}
