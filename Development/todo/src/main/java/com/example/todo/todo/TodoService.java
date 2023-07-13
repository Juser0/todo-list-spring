package com.example.todo.todo;

import com.example.todo.common.CrudService;
import com.example.todo.user.User;
import com.example.todo.user.UserMapper;
import com.example.todo.user.UserRepository;
import com.example.todo.user.UserResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static com.example.todo.todo.TodoRequestDto.*;
import static com.example.todo.todo.TodoResponseDto.*;
import static com.example.todo.todo.TodoMapper.*;

@Service
@RequiredArgsConstructor
public class TodoService implements CrudService<TodoExecuteRequestDto, TodoExecuteRequestDto, TodoInfoResponseDto, TodoInfoResponseDto> {

    private final UserRepository userRepository;
    private final TodoRepository todoRepository;

    @Override
    public TodoInfoResponseDto create(TodoExecuteRequestDto requestDto) {
        return null;
    }

    public TodoInfoResponseDto create(TodoExecuteRequestDto requestDto, Long id) {
        Todo todo = TodoExecuteMapper.MAPPER.toEntity(requestDto);
        todo.modifyUser(userRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("잘못된 회원입니다")));
        todoRepository.save(todo);

        TodoInfoResponseDto responseDto = TodoExecuteMapper.MAPPER.toDto(todo);
        responseDto.modifyUserId(id);
        return responseDto;
    }

    @Override
    public TodoInfoResponseDto read(Long id) {
        return null;
    }

    public List<TodoInfoResponseDto> readById(Long id) {
        User user = userRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("잘못된 회원입니다"));
        List<Todo> list = todoRepository.findByUser(user);
        List<TodoInfoResponseDto> todoList = new ArrayList<>();
        for (Todo todo : list) {
            TodoInfoResponseDto dto = TodoExecuteMapper.MAPPER.toDto(todo);
            todoList.add(dto);
        }
        return todoList;
    }

    @Override
    public List<TodoInfoResponseDto> readAll() {
        List<Todo> list = todoRepository.findAll();
        List<TodoInfoResponseDto> todoList = new ArrayList<>();
        for (Todo todo : list) {
            TodoInfoResponseDto dto = TodoExecuteMapper.MAPPER.toDto(todo);
            dto.modifyUserId(todo.getUser().getId());
            todoList.add(dto);
        }
        return todoList;
    }

    @Override
    public TodoInfoResponseDto update(Long id, TodoExecuteRequestDto requestDto) {
        Todo todo = todoRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("잘못된 할일입니다"));
        todo.modifyTitle(requestDto.getTitle());
        todo.modifyContents(requestDto.getContents());
        todo.modifyDeadline(requestDto.getDeadline());
        todo.modifyIsFinished(requestDto.getIsFinished());
        todoRepository.save(todo);

        TodoInfoResponseDto responseDto = TodoExecuteMapper.MAPPER.toDto(todo);
        responseDto.modifyUserId(todo.getUser().getId());
        return responseDto;
    }

    @Override
    public void delete(Long id) {
        todoRepository.deleteById(id);
    }
}
