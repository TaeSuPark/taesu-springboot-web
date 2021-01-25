package com.taesu.project01.springboot.service.posts;


import com.taesu.project01.springboot.domain.posts.Posts;
import com.taesu.project01.springboot.domain.posts.PostsRepository;
import com.taesu.project01.springboot.web.dto.PostsListResponseDto;
import com.taesu.project01.springboot.web.dto.PostsResponseDto;
import com.taesu.project01.springboot.web.dto.PostsSaveRequestDto;
import com.taesu.project01.springboot.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

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
        // dirty checking

        return id;
    }

    @Transactional
    public void delete(Long id) {
        Posts posts = postsRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id=" + id));

        postsRepository.delete(posts); // Repository 에서 지원하는 delete 메소드가 리턴타입이 void -> return id를 하지 않는 이유 : 삭제되서 의미가 없음
    }

    @Transactional(readOnly = true) // 트랜잭션이지만 조회 기능만 남겨두어 성능 향상을 위해 사용
    public List<PostsListResponseDto> findAllDesc() {

        // return postsRepository.findAllDesc().stream().map(posts -> new PostsListResponseDto(posts)).collect(Collectors.toList()); 같은 코드
        // 람다식 참고
        return postsRepository.findAllDesc().stream().map(PostsListResponseDto::new).collect(Collectors.toList());
    }

    public PostsResponseDto findById(Long id) {
        Posts entity = postsRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id=" + id));

        return new PostsResponseDto(entity);
    }

}
