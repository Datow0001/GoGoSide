package com.ispan.demo.news.newsservice;

import java.util.List;

import org.springframework.data.domain.Page;

import com.ispan.demo.news.newsmodel.NewsMessages;

public interface NewsMessagesService {
	NewsMessages insert(NewsMessages nm);
	NewsMessages findById(Integer id);
	List<NewsMessages> findByNewsNumber(Integer newsNumber);
	Page<NewsMessages> findByPage(Integer pageNumber);
	void deleteById(Integer id);
	void deleteByNewsNumber(Integer newsNumber);
}

