package com.example.demo.controller.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;

// DAO 역할을 하는 DB Layer 접근자.
// JpaRepository<Entity 클래스, PK 타입>을 상속하면 기본적인 CRUD가 생성된다.
public interface PostsRepository extends JpaRepository<Posts, Long> {

}
