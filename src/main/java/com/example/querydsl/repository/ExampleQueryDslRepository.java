package com.example.querydsl.repository;

import com.example.querydsl.data.ExampleData;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

import static com.example.querydsl.entity.QExample.example;

@Repository
@Transactional
public class ExampleQueryDslRepository {

    @PersistenceContext
    private final EntityManager entityManager;
    private final JPAQueryFactory jpaQueryFactory;

    public ExampleQueryDslRepository(EntityManager entityManager, JPAQueryFactory jpaQueryFactory) {
        this.entityManager = entityManager;
        this.jpaQueryFactory = jpaQueryFactory;
    }

    public List<ExampleData> findAll() {
        return jpaQueryFactory
                .select(Projections.bean(ExampleData.class, example.userId, example.name, example.email))
                .from(example)
                .fetch();
    }
}
