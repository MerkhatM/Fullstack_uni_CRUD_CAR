package com.example.auth_service.mapper;

import com.example.auth_service.dto.UserCreate;
import com.example.auth_service.dto.UserUpdate;
import com.example.auth_service.dto.UserView;
import com.example.auth_service.models.User;

import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(builder = @Builder(disableBuilder = true))
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    UserView toView(User user);
    User toEntity(UserCreate userCreate);
    User toEntity(UserUpdate userUpdate);
}
