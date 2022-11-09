package com.ispan.demo.forum.model;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ForumPostDao extends JpaRepository<ForumPost, Integer> {
    
	List<ForumPost> findTop3ByOrderByPostNoDesc();
	
    List<ForumPost> findTop5ByOrderByPostViewsDesc();
    
    @Query(value ="select * from forum_post where postContent like CONCAT('%',?1,'%') ORDER BY ?#{#pageable}",nativeQuery = true)
	Page<ForumPost> search(String word, Pageable pageable);
    
	List<ForumPost> findBySportType(String type);
	
	List<ForumPost> findTop3BySportTypeOrderByPostNoDesc(String type);
    
}
