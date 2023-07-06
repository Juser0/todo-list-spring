package com.example.todo.user;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class UserRequestDto {

    public static class UserSignUpRequestDto {

    }

    public static class UserSignInRequestDto {

    }

    @Getter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class UserCreateRequestDto {
        private String name;
        private int age;
        private String email;
    }

    @Getter
    @AllArgsConstructor
    public static class UserUpdateRequestDto {
        private String name;
        private int age;
    }
}
