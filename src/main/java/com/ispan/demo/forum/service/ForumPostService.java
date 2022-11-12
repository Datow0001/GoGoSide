package com.ispan.demo.forum.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.ispan.demo.forum.model.ForumPost;

public interface ForumPostService {

	ForumPost insert(ForumPost fp);
	ForumPost findById(Integer id);
	void deleteById(Integer id);
	List<ForumPost> findAllPosts();
	Page<ForumPost> findByPage(Integer pageNumber);
	List<ForumPost> findMostViews();
	List<ForumPost> findLastThree();
	Page<ForumPost> findBySearch(String word);
	Page<ForumPost> findByuserId(String userId,Integer pageNumber);
	Page<ForumPost> findByTeamName(String teamName,Integer pageNumber);
	
}
