package com.example.querydsl.service.impl;

import com.example.querydsl.dto.ExampleDto;
import com.example.querydsl.repository.ExampleQueryDslRepository;
import com.example.querydsl.service.ExampleService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExampleServiceImpl implements ExampleService {

    private final ExampleQueryDslRepository exampleQueryDslRepository;

    public ExampleServiceImpl(ExampleQueryDslRepository exampleQueryDslRepository) {
        this.exampleQueryDslRepository = exampleQueryDslRepository;
    }

    @Override
    public List<ExampleDto> findAll() {
        return exampleQueryDslRepository.findAll();
    }

    @Override
    public ExampleDto findById(String id) {
        return exampleQueryDslRepository.findById(id);
    }

    @Override
    public void save(ExampleDto example) {
        exampleQueryDslRepository.save(example);
    }

    @Override
    public void put(ExampleDto example) {
        exampleQueryDslRepository.put(example);
    }

    @Override
    public void deleteById(String id) {
        exampleQueryDslRepository.deleteById(id);
    }
}
