package com.taesu.project01.springboot.service.posts;


import com.taesu.project01.springboot.domain.posts.Posts;
import com.taesu.project01.springboot.domain.posts.PostsRepository;
import com.taesu.project01.springboot.web.dto.PostsResponseDto;
import com.taesu.project01.springboot.web.dto.PostsSaveRequestDto;
import com.taesu.project01.springboot.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;

//Service 계층에서는 Transaction 간의 순서만 보장
//@Autowired로 Bean을 주입 x -> 생성자 방식으로 변경 -> @RequiredArgsConstructor : final 필드를 인자로 가진 생성자를 생성해줌
@RequiredArgsConstructor
@Service
public class PostsService {

    private final PostsRepository postsRepository;

    @Transactional
    public Long save(PostsSaveRequestDto requestDto) {
        return postsRepository.save(requestDto.toEntity()).getId(); // 해당 id 값에 toEntity()로 생성한 객체를 save
    }

    @Transactional
    public Long update(Long id, PostsUpdateRequestDto requestDto) {
        Posts posts = postsRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id=" + id));

        posts.update(requestDto.getTitle(), requestDto.getContent()); //쿼리를 날리지 않음 -> JPA 영속성 때문
        // 29번째 줄에서 DB에 접근하여 데이터를 가져왔으므로 변경이 있으면 트랜잭션 종료 후 자동 반영

        return id;
    }

    public PostsResponseDto findById(Long id) {
        Posts entity = postsRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id=" + id));

        return new PostsResponseDto(entity);
    }

}
