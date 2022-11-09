package com.ispan.demo.forum.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.ispan.demo.forum.model.ForumComment;
import com.ispan.demo.forum.model.ForumPost;

public interface ForumCommentService {

    ForumComment insert(ForumComment fc);
    ForumComment findById(Integer cmmtNo);
    List<ForumComment> findByPostNo(Integer postNo);
    Page<ForumComment> findByPage(Integer pageNumber);
    void deleteById(Integer cmmtNo);
    void deleteByPostNo(Integer postNo);
}
