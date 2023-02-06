package com.example.querydsl.repository;

import com.example.querydsl.dto.ExampleDto;
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

    public List<ExampleDto> findAll() {
        return jpaQueryFactory.select(Projections.bean(ExampleDto.class, example.id, example.name, example.email))
                .from(example)
                .fetch();
    }

    public ExampleDto findById(String id) {
        return jpaQueryFactory.select(Projections.bean(ExampleDto.class, example.id, example.name, example.email))
                .from(example)
                .where(example.id.eq(id))
                .fetchOne();
    }

    public void save(ExampleDto exampleData) {
        jpaQueryFactory.insert(example)
                .columns(example.id, example.name, example.email)
                .values(exampleData.getId(), exampleData.getName(), exampleData.getEmail())
                .execute();
    }

    public void put(ExampleDto exampleData) {
        jpaQueryFactory.update(example)
                .where(example.id.eq(exampleData.getId()))
                .set(example.name, exampleData.getName())
                .set(example.email, exampleData.getEmail())
                .execute();
    }

    public void deleteById(String id) {
        jpaQueryFactory.delete(example)
                .where(example.id.eq(id))
                .execute();
    }
}
