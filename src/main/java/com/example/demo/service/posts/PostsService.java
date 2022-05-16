package com.example.demo.service.posts;

import com.example.demo.controller.domain.posts.Posts;
import com.example.demo.controller.domain.posts.PostsRepository;
import com.example.demo.controller.dto.PostsResponseDto;
import com.example.demo.controller.dto.PostsSaveRequestDto;
import com.example.demo.controller.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class PostsService {
    private final PostsRepository postsRepository;

    // 저장(Create)
    @Transactional
    public Long save(PostsSaveRequestDto requestDto) {
        return postsRepository.save(requestDto.toEntity()).getId();
    }

    // 변경(Update)
    @Transactional
    public Long update(Long id, PostsUpdateRequestDto requestDto) {
        // 변경하고자 하는 post 원본 가져오기
        Posts posts = postsRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id = " + id));

        // 원본을 변경하기.
        posts.update(requestDto.getTitle(), requestDto.getContent());

        return id;
    }

    // 조회(Read)
    @Transactional
    public PostsResponseDto findById(Long id) {
        Posts entity = postsRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id = " + id));

        return new PostsResponseDto(entity);
    }
}
