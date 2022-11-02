package com.ispan.demo.news.newsmodel;

import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface NewsDao extends JpaRepository<News, Integer> {
	List<News> findTop3ByOrderByNewsNumberDesc();
	
	List<News> findTop5ByOrderByNewsClickCountDesc();
	
	List<News> findByNewsDate(Date date);
	
//	@Query(value ="select * from newstable where newsIndex like CONCAT('%',?1,'%') ORDER BY ?#{#pageable}",countQuery = "select count(*) from newstable where newsIndex like CONCAT('%',?1,'%')",nativeQuery = true)
	@Query(value ="select * from newstable where newsIndex like CONCAT('%',?1,'%') ORDER BY ?#{#pageable}",nativeQuery = true)
	Page<News> search(String word, Pageable pageable);
}
