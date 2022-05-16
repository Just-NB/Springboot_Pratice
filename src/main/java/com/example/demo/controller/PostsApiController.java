package com.example.demo.controller;

import com.example.demo.controller.dto.PostsResponseDto;
import com.example.demo.controller.dto.PostsSaveRequestDto;
import com.example.demo.controller.dto.PostsUpdateRequestDto;
import com.example.demo.service.posts.PostsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class PostsApiController {

    private final PostsService postsService;
    // 1. 저장하기 (Create)
    @PostMapping("/api/v1/posts")
    public Long save(@RequestBody PostsSaveRequestDto requestDto) {
        return postsService.save(requestDto);
    }

    // 2. 수정하기 (Update)
    @PutMapping("/api/v1/posts/{id}")
    public Long update(@PathVariable Long id, @RequestBody PostsUpdateRequestDto requestDto) {
        return postsService.update(id, requestDto);
    }

    // 3. 조회하기 (Read)
    @GetMapping("/api/v1/posts/{id}")
    public PostsResponseDto findById(@PathVariable Long id) {
        return postsService.findById(id);
    }
}
