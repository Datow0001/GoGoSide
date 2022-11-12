package com.ispan.demo.forum.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ispan.demo.forum.model.ForumPost;
import com.ispan.demo.forum.model.ForumPostDao;
import com.ispan.demo.forum.service.ForumPostService;
import com.ispan.demo.news.newsmodel.News;

@Transactional
@Service
public class ForumPostServiceImpl implements ForumPostService{

	@Autowired
	private ForumPostDao fDao;
	
	public List<ForumPost> findAllPosts(){
		return fDao.findAll();
	}
	
	public Page<ForumPost> findByPage(Integer pageNumber){
		Pageable pgb = PageRequest.of(pageNumber-1, 10, Sort.Direction.DESC, "postTime");
		Page<ForumPost> page = fDao.findAll(pgb);
		return page;
	}
	
	public ForumPost findById(Integer id) {
		Optional<ForumPost> optional = fDao.findById(id);
		
		if(optional.isPresent()) {
			return optional.get();
		}
		return null;
	}
	
	public List<ForumPost> findLastThree(){
		List<ForumPost> list = fDao.findTop3ByOrderByPostNoDesc();
		return list;
	}
	
	public List<ForumPost> findMostViews(){
		List<ForumPost> list = fDao.findTop5ByOrderByPostViewsDesc();
		return list;
	}
	
	public ForumPost insert(ForumPost fp) {
		return fDao.save(fp);
	}
	
	public void deleteById(Integer id) {
		fDao.deleteById(id);
	}

	public Page<ForumPost> findBySearch(String word) {
		Pageable pageable = PageRequest.of(0, 3, Sort.Direction.DESC, "postNo");
		Page<ForumPost> page =fDao.search(word, pageable);	
		return page;
	}

	@Override
	public Page<ForumPost> findByuserId(String userId,Integer pageNumber) {				
		//使用SERCH之後分頁失效 自行分頁
				List<ForumPost> list = fDao.findByUserId(userId);
				Collections.reverse(list);//反轉 因為SORT沒用
				List list2 = new ArrayList<>();
				Sort sort = Sort.by(Sort.Direction.DESC, "newsNumber");//sort 沒用
				Pageable pageable = PageRequest.of(pageNumber-1, 5, sort);
				if (pageable.getOffset() > list.size()) {
				    long total = 0L;
				    PageImpl<ForumPost> emptyPage = new PageImpl<>(list2, pageable, total);
				    return emptyPage;
				}

				if (pageable.getOffset() <= list.size() && pageable.getOffset() + pageable.getPageSize() > list.size()) {
				    List<ForumPost> bizPojos = list.subList((int)pageable.getOffset(), list.size());
				    PageImpl<ForumPost> pPage = new PageImpl<>(bizPojos, pageable, list.size());
				    return pPage;
				}

				List<ForumPost> newNews = list.subList((int)pageable.getOffset(), (int)(pageable.getOffset() + pageable.getPageSize()));
				
				Page<ForumPost> page = new PageImpl<>(newNews, pageable, list.size());
				return page;
	}

	@Override
	public Page<ForumPost> findByTeamName(String teamName, Integer pageNumber) {
		List<ForumPost> list = fDao.findByTeamName(teamName);
		Collections.reverse(list);//反轉 因為SORT沒用
		List list2 = new ArrayList<>();
		Sort sort = Sort.by(Sort.Direction.DESC, "newsNumber");//sort 沒用
		Pageable pageable = PageRequest.of(pageNumber-1, 5, sort);
		if (pageable.getOffset() > list.size()) {
		    long total = 0L;
		    PageImpl<ForumPost> emptyPage = new PageImpl<>(list2, pageable, total);
		    return emptyPage;
		}

		if (pageable.getOffset() <= list.size() && pageable.getOffset() + pageable.getPageSize() > list.size()) {
		    List<ForumPost> bizPojos = list.subList((int)pageable.getOffset(), list.size());
		    PageImpl<ForumPost> pPage = new PageImpl<>(bizPojos, pageable, list.size());
		    return pPage;
		}

		List<ForumPost> newNews = list.subList((int)pageable.getOffset(), (int)(pageable.getOffset() + pageable.getPageSize()));
		
		Page<ForumPost> page = new PageImpl<>(newNews, pageable, list.size());
		return page;
	}
	    
}
