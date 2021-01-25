package com.taesu.project01.springboot.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

// mybatis에서의 Dao 역할
// SpringDataJpa에서 기본적인 CRUD 메소드가 자동생성됨 자동생성되는 메소드 목록은?
// count, delete, deleteAll, deleteAll, deleteById, existsById, findById, save (CRUD)
// findAll (Paging and Sorting)
// count, exists, findAll, findOne (QueryByExampleExecutor) -> ??
public interface PostsRepository extends JpaRepository<Posts, Long> {

    //해당 기능은 SpringDataJpa에서 기본적으로 지원해주는 방법으로 사용할 수 있으나 쿼리를 사용하여 구현할 수도 있음.
    @Query("SELECT p FROM Posts p ORDER BY p.id DESC")
    List<Posts> findAllDesc();
}
