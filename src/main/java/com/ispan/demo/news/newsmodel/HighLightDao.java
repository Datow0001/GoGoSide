package com.ispan.demo.news.newsmodel;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface HighLightDao extends JpaRepository<HighLight, Integer> {
	
	List<HighLight> findTop7ByOrderByHighLightIdDesc();

}
