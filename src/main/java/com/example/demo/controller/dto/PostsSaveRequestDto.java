package com.example.demo.controller.dto;

import com.example.demo.controller.domain.posts.Posts;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/*
Entity 클래스와 DTO를 유사하게 구현한다.
유사하다고 해서 Entity를 절대 Request/Repsonse 클래스로 사용해서는 안된다.
Entity는 DB와 맞닿은 핵심 클래스이며, 이를 기준으로 테이블이 생성되고 스키마가 변경된다.
화면 변환같은 사소한 기능변경을 위해, 테이블과 연결된 Entity 클래스를 변경하는것은 너무 큰 변경이다.

DTO는 자주변경이 필요하다.
 */
@Getter
@NoArgsConstructor
public class PostsSaveRequestDto {
    private String title;
    private String content;
    private String author;

    @Builder
    public PostsSaveRequestDto(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public Posts toEntity() {
        return Posts.builder()
                .title(title)
                .content(content)
                .author(author)
                .build();
    }
}
