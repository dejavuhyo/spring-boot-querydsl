package com.example.querydsl.service;

import com.example.querydsl.dto.ExampleDto;

import java.util.List;

public interface ExampleService {
    List<ExampleDto> findAll();

    ExampleDto findById(String id);

    void save(ExampleDto exampleDto);

    void put(ExampleDto exampleDto);

    void deleteById(String id);
}
