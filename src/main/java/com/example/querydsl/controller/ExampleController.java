package com.example.querydsl.controller;

import com.example.querydsl.data.ExampleData;
import com.example.querydsl.repository.ExampleQueryDslRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/sample")
public class ExampleController {
    private final ExampleQueryDslRepository exampleQueryDslRepository;

    @GetMapping("/")
    @ResponseBody
    public List<ExampleData> findAll() {
        return exampleQueryDslRepository.findAll();
    }
}
