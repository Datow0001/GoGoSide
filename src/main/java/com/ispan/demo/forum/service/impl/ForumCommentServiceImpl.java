package com.ispan.demo.forum.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ispan.demo.forum.model.ForumComment;
import com.ispan.demo.forum.model.ForumCommentDao;
import com.ispan.demo.forum.model.ForumPost;
import com.ispan.demo.forum.service.ForumCommentService;

@Transactional
@Service
public class ForumCommentServiceImpl implements ForumCommentService{
    
    @Autowired
    private ForumCommentDao fcDao;

    public ForumComment insert(ForumComment fc) {
        return fcDao.save(fc);
    }

    public ForumComment findById(Integer cmmtNo) {
        Optional <ForumComment> optional = fcDao.findById(cmmtNo);
        if (optional.isPresent()) {
            return optional.get();
        }
        return null;
    }
    
    public List<ForumComment> findByPostNo(ForumPost postNo) {
    	return fcDao.findAll();
    }
    
    public Page<ForumComment> findByPage(Integer pageNumber) {
    	Pageable pgb = PageRequest.of(pageNumber - 1, 5, Sort.Direction.DESC, "cmmtTime");
    	Page<ForumComment> page = fcDao.search(pageNumber, pgb);
    	return page;
    }
    
    public void deleteById(Integer cmmtNo) {
        fcDao.deleteById(cmmtNo);
    }

	public void deleteByPostNo(ForumPost postNo) {
		List<ForumComment> list = findByPostNo(postNo);
		for (ForumComment comment : list) {
			deleteById(comment.getCmmtNo());
		}
	}

	@Override
	public List<ForumComment> findByPostNo(Integer postNo) {
		return null;
	}

	@Override
	public void deleteByPostNo(Integer postNo) {
	}

}
