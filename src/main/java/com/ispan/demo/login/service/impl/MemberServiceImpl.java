package com.ispan.demo.login.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ispan.demo.login.model.member.Member;
import com.ispan.demo.login.repository.MemberRepository;
import com.ispan.demo.login.service.MemberService;

@Service
@Transactional
public class MemberServiceImpl implements MemberService {

    @Autowired
    private MemberRepository mRepository;

    @Override
    public List<Member> findAll() {
        return mRepository.findAll();
    }

    @Override
    public Member findByUserId(String userId) {
        return mRepository.findByUserId(userId);
    }

//    檢查帳號是否存在
    @Override
    public boolean isUserIdExists(String userId) {
        boolean exist = false;
        List<Member> member = mRepository.findAll();
        if (member.size() > 0) {
            exist = true;
        }
        return exist;

    }

//    驗證方法
    @Override
    public Optional<String> register(Member member) {

//        檢查帳號是否重複
        Member memberData = mRepository.findByUserId(member.getUserId());
        if (memberData != null) {
            System.out.println("id already used");
            return Optional.of("帳號已存在");
        }

//        檢查兩個密碼是否相符
        if (member.getPassword().equals(member.getPasswordAgain())) {
            return Optional.of("密碼輸入不相符");
        }

//        檢查帳號是否添加成功
        Member result = mRepository.save(member);
        if (result == null) {
            return Optional.of("新增會員發生錯誤");
        }

        return Optional.empty();
    }


}
