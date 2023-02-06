package com.example.querydsl.controller;

import com.example.querydsl.dto.ExampleDto;
import com.example.querydsl.service.ExampleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/querydsl")
public class ExampleController {
    private final ExampleService exampleService;

    /**
     * 전체 조회
     *
     * @return
     */
    @GetMapping("/")
    @ResponseBody
    public List<ExampleDto> findAll() {
        return exampleService.findAll();
    }

    /**
     * id 조회
     *
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    @ResponseBody
    public ExampleDto findById(@PathVariable("id") String id) {
        return exampleService.findById(id);
    }

    /**
     * 저장
     *
     * org.springframework.dao.InvalidDataAccessApiUsageException: org.hibernate.hql.internal.ast.QuerySyntaxException: unexpected token:
     * QueryDSL 라이브러리 문제로 JpaRepository의 save를 이용
     *
     * @param exampleDto
     */
//    @PostMapping("/")
//    @ResponseStatus(HttpStatus.CREATED)
//    @ResponseBody
//    public void save(@RequestBody ExampleDto exampleDto) {
//        exampleService.save(exampleDto);
//    }

    /**
     * 수정
     *
     * @param exampleData
     */
    @PutMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void update(@PathVariable("id") String id, @RequestBody ExampleDto exampleData) {
        exampleData.setId(id);
        exampleService.put(exampleData);
    }

    /**
     * 삭제
     *
     * @param id
     */
    @DeleteMapping(value = "/{id}")
    public void deleteById(@PathVariable("id") String id) {
        exampleService.deleteById(id);
    }
}
