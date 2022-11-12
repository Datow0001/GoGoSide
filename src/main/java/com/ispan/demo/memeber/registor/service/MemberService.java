package com.ispan.demo.memeber.registor.service;

import java.util.List;

import com.ispan.demo.memeber.login.model.Login;
import com.ispan.demo.memeber.registor.model.member.Member;

public interface MemberService {


	List<Member> findAll();
	
	Member save(Member member);
	
	List<Member> findByUserIdAndPassword(String userId,String password);

	boolean existsByUserId(String userId);

	boolean existsByMail(String mail);

	boolean existsByPhone(String phone);

	Login cheakIdPassword(String userId,String password);
	
	Member findByUserId(String userId);
	
	void insert(Member member);
	
	Member findByPersonId(String id);
//	Member getMemberByMail(String mail);
	
}
