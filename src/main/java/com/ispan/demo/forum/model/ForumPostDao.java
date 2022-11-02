package com.ispan.demo.forum.model;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ForumPostDao extends JpaRepository<ForumPost, Integer> {

}
