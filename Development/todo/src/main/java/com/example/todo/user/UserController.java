package com.example.todo.user;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import static com.example.todo.user.UserRequestDto.*;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping
    public void findUserAll() {

    }

    @GetMapping("/{userId}")
    public void findUserOne(@PathVariable(value = "userId") Long id) {

    }

    @PostMapping
    public void createUser(@RequestBody UserCreateRequestDto requestDto) {

    }

    @PutMapping("/{userId}")
    public void updateUser(@RequestBody UserUpdateRequestDto requestDto, @PathVariable(value = "userId") Long id) {

    }

    @DeleteMapping("/{userId}")
    public void deleteUser(@PathVariable(value = "userId") Long id) {

    }
}
