package com.taesu.project01.springboot.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;
// mybatis에서의 Dao 역할
public interface PostsRepository extends JpaRepository<Posts, Long> {
}
