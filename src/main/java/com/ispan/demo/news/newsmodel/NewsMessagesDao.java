package com.ispan.demo.news.newsmodel;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface NewsMessagesDao extends JpaRepository<NewsMessages, Integer> {

	List<NewsMessages> findByNewsNumber(Integer newsNumber);

//	@Query(value = "select * from newsmessage where newsNumber = ?1 ORDER BY ?#{#pageable}", countQuery = "select count(*) from newsmessage  where newsNumber = ?1", nativeQuery = true)
	@Query(value = "select * from newsmessage where newsNumber = ?1 ORDER BY ?#{#pageable}",  nativeQuery = true)
	Page<NewsMessages> search1(Integer newsNumber, Pageable pageable);
	
	
}
