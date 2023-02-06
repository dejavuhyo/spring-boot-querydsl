# Spring Boot QueryDSL

## 1. 설명
Spring Boot QueryDSL 예제이다. 포트는 8080을 사용한다.

## 2. 개발환경

* OpenJDK 17

* spring-boot 2.7.8

## 3. API 실행

### 1) 전체 조회

* GET
  - http://localhost:8080/querydsl/

### 2) ID 조회

* GET
  - http://localhost:8080/querydsl/1

### 3) 저장

* POST
  - http://localhost:8080/querydsl

> org.springframework.dao.InvalidDataAccessApiUsageException: org.hibernate.hql.internal.ast.QuerySyntaxException: unexpected token:
> QueryDSL 라이브러리 문제로 JpaRepository의 save를 이용

### 4) 수정

* PUT
  - http://localhost:8080/querydsl/1

### 5) 삭제

* DELETE
  - http://localhost:8080/querydsl/1
