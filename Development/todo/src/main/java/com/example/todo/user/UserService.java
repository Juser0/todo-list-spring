package com.example.todo.user;

import com.example.todo.common.CrudService;
import static com.example.todo.user.UserRequestDto.*;
import static com.example.todo.user.UserResponseDto.*;
import java.util.List;

public class UserService implements CrudService<UserCreateRequestDto, UserUpdateRequestDto, UserInfoResponseDto, UserUpdateResponseDto> {


    @Override
    public UserInfoResponseDto create(UserCreateRequestDto requestDto) {
        return null;
    }

    @Override
    public UserInfoResponseDto read(Long id) {
        return null;
    }

    @Override
    public List<UserInfoResponseDto> readAll() {
        return null;
    }

    @Override
    public UserUpdateResponseDto update(Long id, UserUpdateRequestDto requestDto) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }
}
