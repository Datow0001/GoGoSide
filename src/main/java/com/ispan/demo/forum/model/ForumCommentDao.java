package com.ispan.demo.forum.model;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ForumCommentDao extends JpaRepository<ForumComment, Integer> {

    List<ForumComment> findByPostNo(Integer postNo);

	@Query(value = "select * from forum_comments where postNo = ?1 ORDER BY ?#{#pageable}",  nativeQuery = true)
	Page<ForumComment> search(Integer postNo, Pageable pageable);
    
}
