package com.example.todo.todo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

public class TodoResponseDto {

    @Getter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class TodoInfoResponseDto {
        private Long id;
        private Long userId;
        private String title;
        private String contents;
        private LocalDateTime deadline;
        private Boolean isFinished;
        private LocalDateTime createdAt;
        private LocalDateTime modifiedAt;

        public void modifyUserId(Long id) {
            this.userId = id;
        }
    }
}
