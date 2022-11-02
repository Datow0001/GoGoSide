package com.ispan.demo.forum.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ispan.demo.forum.model.ForumPost;
import com.ispan.demo.forum.model.ForumPostDao;

@Transactional
@Service
public class ForumPostService {

	@Autowired
	private ForumPostDao fDao;
	
	public ForumPost insert(ForumPost fp) {
		return fDao.save(fp);
	}
	
	public ForumPost findById(Integer id) {
		Optional<ForumPost> optional = fDao.findById(id);
		
		if(optional.isPresent()) {
			return optional.get();
		}
		return null;
	}
	
	public void deleteById(Integer id) {
		fDao.deleteById(id);
	}
	
	public List<ForumPost> findAllPosts(){
		return fDao.findAll();
	}
	
	public Page<ForumPost> findByPage(Integer pageNumber){
		Pageable pgb = PageRequest.of(pageNumber-1, 10, Sort.Direction.DESC, "postTime");
		Page<ForumPost> page = fDao.findAll(pgb);
		return page;
	}
	
}
