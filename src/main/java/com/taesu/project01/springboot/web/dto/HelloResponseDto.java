package com.taesu.project01.springboot.web.dto;


import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter // 선택된 필드의 get 메소드를 생성
@RequiredArgsConstructor // 선언된 final 필드를 포함한 생성자를 생성( final이 아니면 포함 x)
public class HelloResponseDto {

    private final String name;
    private final int amount;
}
