package com.example.todo.user;

import com.example.todo.todo.Todo;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

public class UserResponseDto {

    public static class UserSignUpResponseDto {

    }

    public static class UserSignInResponseDto {

    }

    @Getter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class UserInfoResponseDto {
        private Long id;
        private String name;
        private int age;
        private String email;
        private List<Todo> todoList;
        private LocalDateTime createdAt;
        private LocalDateTime modifiedAt;
    }

    @Getter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class UserUpdateResponseDto {
        private Long id;
        private String name;
        private int age;
        private LocalDateTime createdAt;
        private LocalDateTime modifiedAt;
    }
}
