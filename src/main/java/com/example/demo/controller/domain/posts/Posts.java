package com.example.demo.controller.domain.posts;

import com.example.demo.controller.domain.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter @NoArgsConstructor // Lombok Annotation
@Entity // JPA Annotation
public class Posts extends BaseTimeEntity {
    // 실제 DB 테이블과 매칭될 클래스.
    @Id // PK 필드.
    @GeneratedValue(strategy = GenerationType.IDENTITY) // PK생성 규칙, IDENTITY -> auto_increment가 된다.
    private Long id;

    @Column(length = 500, nullable = false) // 굳이 선언하지 않더라도 칼럼이 된다.
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    private String author;

    @Builder // Lombok Annotation,
    public Posts(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public void update(String title, String content) {
        this.title = title;
        this.content = content;
    }
}
