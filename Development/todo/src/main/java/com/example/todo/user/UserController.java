package com.example.todo.user;

import com.example.todo.common.CommonResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.example.todo.user.UserRequestDto.*;
import static com.example.todo.user.UserResponseDto.*;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping
    public ResponseEntity<CommonResponse<?>> findUserAll() {
        List<UserInfoResponseDto> userList = userService.readAll();

        return ResponseEntity.status(200)
                .body(CommonResponse.builder()
                        .responseCode("USERS_FOUND")
                        .responseMessage("회원 전체 조회 완료")
                        .data(userList)
                        .build());
    }

    @GetMapping("/{userId}")
    public ResponseEntity<CommonResponse<?>> findUserOne(@PathVariable(value = "userId") Long id) {
        UserInfoResponseDto responseDto = userService.read(id);

        return ResponseEntity.status(200)
                .body(CommonResponse.builder()
                        .responseCode("USER_FOUND")
                        .responseMessage("회원 조회 완료")
                        .data(responseDto)
                        .build());

    }

    @PostMapping
    public ResponseEntity<CommonResponse<?>> createUser(@RequestBody UserCreateRequestDto requestDto) {
        UserInfoResponseDto responseDto = userService.create(requestDto);

        return ResponseEntity.status(201)
                .body(CommonResponse.builder()
                        .responseCode("USER_REGISTERED")
                        .responseMessage("회원 가입(생성) 완료")
                        .data(responseDto)
                        .build());
    }

    @PutMapping("/{userId}")
    public ResponseEntity<CommonResponse<?>> updateUser(@RequestBody UserUpdateRequestDto requestDto, @PathVariable(value = "userId") Long id) {
        UserUpdateResponseDto responseDto = userService.update(id, requestDto);

        return ResponseEntity.status(200)
                .body(CommonResponse.builder()
                        .responseCode("USER_UPDATED")
                        .responseMessage("회원 정보 수정 완료")
                        .data(responseDto)
                        .build());
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<CommonResponse<?>> deleteUser(@PathVariable(value = "userId") Long id) {
        userService.delete(id);

        return ResponseEntity.status(204)
                .body(CommonResponse.builder()
                        .responseCode("USER_DELETED")
                        .responseMessage("회원 정보 삭제(탈퇴) 완료")
                        .build());
    }
}
