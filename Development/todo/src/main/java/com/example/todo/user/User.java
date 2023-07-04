package com.example.todo.user;

import com.example.todo.common.BaseTimeEntity;
import com.example.todo.todo.Todo;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Table(name = "user_tb")
@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class User extends BaseTimeEntity {

    // 회원 식별자
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // 회원 이름
    private String name;

    // 회원 나이
    private int age;

    // 회원 이메일
    private String email;

    // 할일 목록
    @Builder.Default
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Todo> todoList = new ArrayList<>();

    public void modifyName(String name) {
        this.name = name;
    }

    public void modifyAge(int age) {
        this.age = age;
    }
}
