package com.taesu.project01.springboot.web.dto;

import com.taesu.project01.springboot.domain.posts.Posts;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
// save 동작을 수행하기 위한 Dto
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
