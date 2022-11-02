package com.ispan.demo.news.newsservice;

import java.util.List;

import org.springframework.data.domain.Page;

import com.ispan.demo.news.newsmodel.News;

public interface NewsService {
	void getNews() ;
	void download(String urlString, String filename, String savePath) throws Exception;
	List<News> findAllNews();
	Page<News> findByPage(Integer pageNumber);
	News findById(Integer id);
	List<News> findLastThree();
	List<News> findTopClick();
	void deleteNews(Integer id);
	News insert(News news);
	Page<News> findBySearch(String word);
}
