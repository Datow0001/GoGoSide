package com.ispan.demo.login.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.ispan.demo.login.model.member.Member;
import com.ispan.demo.login.service.MemberService;

@Controller
public class emptyFormController {

    @Autowired
    MemberService mService;

//    // 首頁畫面
//    @GetMapping("/")
//    public String home() {
//        return "index";
//    }

    // 空的註冊表單
    @GetMapping("/registerForm")
    // 給定一個空的模型
    public String register(Model model) {
//        Member member = new Member();
        model.addAttribute("newMember",new Member());
        // 建一個存放會員資料的模型(變數名稱newMember)
        return "member/register";
    }

//    查看會員資料
    @GetMapping("/personForm")
    public String preson(Member member) {
        return "member/person";
    }
    
    // 會員登入畫面
    @GetMapping("/loginForm")
    public String Longin() {
        return "member/login";
    }
}
