package com.example.todo.todo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

public class TodoRequestDto {

    @Getter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class TodoExecuteRequestDto {
        private String title;
        private String contents;
        private LocalDateTime deadline;
        private Boolean isFinished;
    }
}
