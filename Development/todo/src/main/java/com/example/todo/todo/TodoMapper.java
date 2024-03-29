package com.example.todo.todo;

import com.example.todo.common.EntityMapper;
import com.example.todo.user.User;
import com.example.todo.user.UserRequestDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import static com.example.todo.todo.TodoRequestDto.*;
import static com.example.todo.todo.TodoResponseDto.*;

public interface TodoMapper {

    @Mapper
    interface TodoExecuteMapper extends EntityMapper<TodoExecuteRequestDto, TodoInfoResponseDto, Todo> {

        TodoExecuteMapper MAPPER = Mappers.getMapper(TodoExecuteMapper.class);

        @Override
        @Mapping(target = "id", ignore = true)
        @Mapping(target = "user", ignore = true)
        Todo toEntity(final TodoExecuteRequestDto requestDto);

        @Override
        @Mapping(target = "userId", ignore = true)
        TodoInfoResponseDto toDto(final Todo todo);
    }
}
