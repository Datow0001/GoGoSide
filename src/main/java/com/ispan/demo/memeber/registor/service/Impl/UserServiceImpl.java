//package com.ispan.demo.memeber.registor.service.Impl;
//
//import java.util.Collections;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
//import com.ispan.demo.memeber.registor.exception.ResourceNotFoundException;
//import com.ispan.demo.memeber.registor.model.member.Member;
//import com.ispan.demo.memeber.registor.service.MemberService;
//
//@Service
//public class UserServiceImpl implements UserDetailsService {
//
//	@Autowired
//	private MemberService mService;
//
//	@Override
//	// 參數<-傳入登入畫面的帳號
//	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//		try {
//			// 到資料庫比對資料
//			Member user = mService.getMemberByMail(username);
//
//			// 使用他的帳號與密碼建立user物件，並傳給驗證機制使用
//			// User()是套件提供，Collections回傳權限
//			return new User(user.getUserId(), user.getPassword(), Collections.emptyList());
//		} catch (ResourceNotFoundException e) {
//			throw new UsernameNotFoundException("Username is wrong");
//		}
//	}
//
//}
