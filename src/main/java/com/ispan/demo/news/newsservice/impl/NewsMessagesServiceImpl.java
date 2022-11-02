package com.ispan.demo.news.newsservice.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ispan.demo.news.newsmodel.NewsMessages;
import com.ispan.demo.news.newsmodel.NewsMessagesDao;
import com.ispan.demo.news.newsservice.NewsMessagesService;

@Service
@Transactional
public class NewsMessagesServiceImpl implements NewsMessagesService  {

	@Autowired
	private NewsMessagesDao nDao;

	public NewsMessages insert(NewsMessages nm) {
		return nDao.save(nm);
	}

	public NewsMessages findById(Integer id) {
		Optional<NewsMessages> op = nDao.findById(id);
		if (op.isPresent()) {
			return op.get();
		}
		return null;
	}

	public List<NewsMessages> findByNewsNumber(Integer newsNumber) {
		return nDao.findByNewsNumber(newsNumber);
	}


	public Page<NewsMessages> findByPage(Integer pageNumber) {
		Pageable pageable = PageRequest.of(pageNumber - 1, 3, Sort.Direction.DESC, "postTime");
		Page<NewsMessages> page = nDao.search1(pageNumber, pageable);
		return page;
	}
	
	public void deleteById(Integer id) {
		nDao.deleteById(id);
	}
	public void deleteByNewsNumber(Integer newsNumber) {
	List<NewsMessages> m =	findByNewsNumber(newsNumber);
	for (NewsMessages newsMessages : m) {
		deleteById(newsMessages.getPostNumber());
	}
	}
}
