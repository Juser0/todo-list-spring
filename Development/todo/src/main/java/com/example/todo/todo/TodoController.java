package com.example.todo.todo;

import com.example.todo.common.CommonResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.example.todo.todo.TodoResponseDto.*;
import static com.example.todo.todo.TodoRequestDto.*;

@RestController
@RequestMapping("/todos")
@RequiredArgsConstructor
public class TodoController {

    private final TodoService todoService;

    @GetMapping
    public ResponseEntity<CommonResponse<?>> findAll() {
        List<TodoInfoResponseDto> todoList = todoService.readAll();

        return ResponseEntity.status(200)
                .body(CommonResponse.builder()
                        .responseCode("TODOS_FOUND")
                        .responseMessage("할일 전체 조회 완료")
                        .data(todoList)
                        .build());
    }

    @GetMapping("/{userId}")
    public ResponseEntity<CommonResponse<?>> findOneByUserId(@PathVariable Long userId) {
        TodoInfoResponseDto responseDto = todoService.read(userId);

        return ResponseEntity.status(200)
                .body(CommonResponse.builder()
                        .responseCode("TODOS_FOUND_BY_USER")
                        .responseMessage("사용자 할일 조회 완료")
                        .data(responseDto)
                        .build());
    }

    @PostMapping("/{userId}")
    public ResponseEntity<CommonResponse<?>> createTodo(@PathVariable Long todoId, @RequestBody TodoExecuteRequestDto requestDto) {
        TodoInfoResponseDto responseDto = todoService.create(requestDto, todoId);
        
        return ResponseEntity.status(201)
                .body(CommonResponse.builder()
                        .responseCode("TODO_CREATED")
                        .responseMessage("할일 생성 완료")
                        .data(responseDto)
                        .build());
    }

    @PutMapping("/{todoId}")
    public ResponseEntity<CommonResponse<?>> updateTodo(@PathVariable Long todoId, @RequestBody TodoExecuteRequestDto requestDto) {
        TodoInfoResponseDto responseDto = todoService.update(todoId, requestDto);

        return ResponseEntity.status(200)
                .body(CommonResponse.builder()
                        .responseCode("TODO_UPDATED")
                        .responseMessage("할일 업데이트 완료")
                        .data(responseDto)
                        .build());
    }

    @DeleteMapping("/{todoId}")
    public ResponseEntity<CommonResponse<?>> deleteTodo(@PathVariable Long todoId) {
        todoService.delete(todoId);

        return ResponseEntity.status(204)
                .body(CommonResponse.builder()
                        .responseCode("TODO_DELETED")
                        .responseMessage("할일 삭제 완료")
                        .build());
    }
}
