package com.taesu.project01.springboot.domain.posts;


import com.taesu.project01.springboot.domain.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;


//Entity 클래스로 DB 테이블과 매칭 되는 클래스
@Getter
@NoArgsConstructor // 기본 생성자 자동 추가
@Entity // 주요 어노테이션을 클래스에 가까이 -> JPA 어노테이션
public class Posts extends BaseTimeEntity { // Entity 클래스에는 Setter 생성 x

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 500, nullable = false) // 굳이 선언하지 않아도 기본값으로 칼럼적용
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    private String author;

    @Builder
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
