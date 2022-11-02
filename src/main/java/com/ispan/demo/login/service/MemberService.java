package com.ispan.demo.login.service;

import java.util.List;
import java.util.Optional;

import com.ispan.demo.login.model.member.Member;

public interface MemberService {

    boolean isUserIdExists(String userId);

    List<Member> findAll();

    Member findByUserId(String userId);
    
    Optional<String> register(Member member);

    
}
