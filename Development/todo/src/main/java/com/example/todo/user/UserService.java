package com.example.todo.user;

import static com.example.todo.user.UserRequestDto.*;
import static com.example.todo.user.UserResponseDto.*;
import static com.example.todo.user.UserMapper.*;

import com.example.todo.common.CrudService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService implements CrudService<UserCreateRequestDto, UserUpdateRequestDto, UserInfoResponseDto, UserUpdateResponseDto> {

    private final UserRepository userRepository;

    @Override
    public UserInfoResponseDto create(UserCreateRequestDto requestDto) {
        User user = UserCreateMapper.MAPPER.toEntity(requestDto);
        userRepository.save(user);

        UserInfoResponseDto responseDto = UserCreateMapper.MAPPER.toDto(user);
        return responseDto;
    }

    @Override
    public UserInfoResponseDto read(Long id) {
        User user = userRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("잘못된 회원입니다"));

        UserInfoResponseDto responseDto = UserCreateMapper.MAPPER.toDto(user);
        return responseDto;
    }

    @Override
    public List<UserInfoResponseDto> readAll() {
        List<User> list = userRepository.findAll();
        List<UserInfoResponseDto> userList = new ArrayList<>();
        for (User user : list) {
            UserInfoResponseDto dto = UserCreateMapper.MAPPER.toDto(user);
            userList.add(dto);
        }
        return userList;
    }

    @Override
    public UserUpdateResponseDto update(Long id, UserUpdateRequestDto requestDto) {
        User user = userRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("잘못된 회원입니다"));
        user.modifyAge(requestDto.getAge());
        user.modifyName(requestDto.getName());
        userRepository.save(user);

        UserUpdateResponseDto responseDto = UserUpdateMapper.MAPPER.toDto(user);
        return responseDto;
    }

    @Override
    public void delete(Long id) {
        userRepository.deleteById(id);
    }
}
