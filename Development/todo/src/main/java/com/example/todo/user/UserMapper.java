package com.example.todo.user;

import static com.example.todo.user.UserRequestDto.*;
import static com.example.todo.user.UserResponseDto.*;

import com.example.todo.common.EntityMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

public interface UserMapper {

    @Mapper
    public interface UserCreateMapper extends EntityMapper<UserCreateRequestDto, UserInfoResponseDto, User> {

        UserCreateMapper MAPPER = Mappers.getMapper(UserCreateMapper.class);

        @Override
        @Mapping(target = "id", ignore = true)
        @Mapping(target = "todoList", ignore = true)
        User toEntity(final UserCreateRequestDto dto);
    }

    @Mapper
    public interface UserUpdateMapper extends EntityMapper<UserUpdateRequestDto, UserUpdateResponseDto, User> {

        UserUpdateMapper MAPPER = Mappers.getMapper(UserUpdateMapper.class);
    }
}
