package com.taesu.project01.springboot.web.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
// update 수행 dto -> 데이터 유무를 판별하고 해당 값을 가져오는 과정이 있으므로 따로 insert를 하지 않아도 됨 -> entity와의 연결 필요 x
@Getter
@NoArgsConstructor
public class PostsUpdateRequestDto {
    private String title;
    private String content;

    @Builder
    public PostsUpdateRequestDto(String title, String content) {
        this.title = title;
        this.content = content;
    }
}
