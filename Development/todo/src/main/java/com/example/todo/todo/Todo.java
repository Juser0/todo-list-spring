package com.example.todo.todo;

import com.example.todo.common.BaseTimeEntity;
import com.example.todo.user.User;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Table(name = "todo_tb")
@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Todo extends BaseTimeEntity {

    // 할일 식별자
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // 할일에 해당하는 회원
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    // 할일 제목
    private String title;

    // 할일 내용
    private String contents;

    // 마감기한
    private LocalDateTime deadline;

    // 완료여부
    private Boolean isFinished;

    public void modifyTitle(String title) {
        this.title = title;
    }

    public void modifyContents(String contents) {
        this.contents = contents;
    }

    public void modifyDeadline(LocalDateTime deadline) {
        this.deadline = deadline;
    }

    public void modifyIsFinished(Boolean isFinished) {
        this.isFinished = isFinished;
    }
}
