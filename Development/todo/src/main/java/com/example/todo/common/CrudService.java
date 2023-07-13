package com.example.todo.common;

import java.util.List;

public interface CrudService<CreateRequest, UpdateRequest, CreateResponse, UpdateResponse> {
    CreateResponse create(CreateRequest requestDto);
    CreateResponse read(Long id);
    List<CreateResponse> readAll();
    UpdateResponse update(Long id, UpdateRequest requestDto);
    void delete(Long id);
}
