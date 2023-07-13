package com.example.todo.common;

public interface EntityMapper <REQ, RES, E>{
    E toEntity(final REQ dto);
    RES toDto(final E entity);
}
