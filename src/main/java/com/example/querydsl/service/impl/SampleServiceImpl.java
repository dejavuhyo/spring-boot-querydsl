package com.example.querydsl.service.impl;

import com.example.querydsl.model.Sample;
import com.example.querydsl.repository.SampleRepository;
import com.example.querydsl.service.SampleService;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SampleServiceImpl implements SampleService {

    @Autowired
    private SampleRepository sampleRepository;

    @Autowired
    private JPAQueryFactory jpaQueryFactory;

    @Override
    public List<Sample> findAllInfo() {
        return null;
    }
}
