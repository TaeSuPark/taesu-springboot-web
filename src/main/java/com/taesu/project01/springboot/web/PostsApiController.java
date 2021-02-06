package com.taesu.project01.springboot.web;


import com.taesu.project01.springboot.service.posts.PostsService;
import com.taesu.project01.springboot.web.dto.PostsResponseDto;
import com.taesu.project01.springboot.web.dto.PostsSaveRequestDto;
import com.taesu.project01.springboot.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

// index.js를 통해 사용
// Rest 규약에 맞춰 Mapping 사용 -> CRUD에 따라 Post, Put, Get, Delete를 사용
@RequiredArgsConstructor
@RestController
public class PostsApiController {

    private final PostsService postsService;

    @PostMapping("/api/v1/posts")
    public Long save(@RequestBody PostsSaveRequestDto requestDto) {

        return postsService.save(requestDto);
    }

    @PutMapping("/api/v1/posts/{id}")
    public Long update(@PathVariable Long id, @RequestBody PostsUpdateRequestDto requestDto) {

        return postsService.update(id, requestDto);
    }

    @GetMapping("/api/v1/posts/{id}")
    public PostsResponseDto findById(@PathVariable Long id) {

        return postsService.findById(id);
    }

    // 삭제 기능은 DeleteMapping 사용
    @DeleteMapping("/api/v1/posts/{id}")
    public Long delete(@PathVariable Long id) {

        postsService.delete(id); // 값을 반환하지 않음

        return id; // Controller에서 void 메소드를 사용하면 Mapping된 url 기반 template을 찾아 반환해주지만 해당 컨트롤러는 api 관련 RestController이기 때문에 void 불가
    }
}
