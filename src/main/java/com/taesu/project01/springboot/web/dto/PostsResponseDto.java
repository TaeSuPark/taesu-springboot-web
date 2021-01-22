package com.taesu.project01.springboot.web.dto;

import com.taesu.project01.springboot.domain.posts.Posts;
import lombok.Getter;
//Posts 관련 명령을 수행하고 그에 대한 응답을 반환하기 위한 Dto
@Getter
public class PostsResponseDto {

    private Long id;
    private String title;
    private String content;
    private String author;

    public PostsResponseDto(Posts entity){
        this.id = entity.getId();
        this.title = entity.getTitle();
        this.content = entity.getContent();
        this.author = entity.getAuthor();
    }
}
