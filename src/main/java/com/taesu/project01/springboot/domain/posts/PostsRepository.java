package com.taesu.project01.springboot.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;
// mybatis에서의 Dao 역할
// JPA에서 기본적인 CRUD 메소드가 자동생성됨 자동생성되는 메소드 목록은?
// count, delete, deleteAll, deleteAll, deleteById, existsById, findById, save (CRUD)
// findAll (Paging and Sorting)
// count, exists, findAll, findOne (QueryByExampleExecutor) -> ??
public interface PostsRepository extends JpaRepository<Posts, Long> {
}
