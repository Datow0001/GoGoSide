package com.ispan.demo.memeber.registor.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.ispan.demo.memeber.registor.model.member.Member;
import com.ispan.demo.memeber.registor.service.MemberService;
import com.ispan.demo.memeber.registor.validator.RegisterValidator;

@Controller
public class RegisterController {

	@Autowired
	MemberService mService;


//	會員註冊
	@PostMapping("/addMember")
	public String insertMember(@Valid @ModelAttribute("newMember") Member member, BindingResult result, Model model) {
//  輸入驗證（自定義、預設）	
		RegisterValidator registerValidator = new RegisterValidator();
		registerValidator.validate(member, result);
// 	到資料庫找帳號是否重複       
		if (mService.existsByUserId(member.getUserId()) == true) {
			result.rejectValue("userId", "", "帳號重複，請重新輸入");
		}
		if (mService.existsByMail(member.getMail()) == true) {
			result.rejectValue("userId", "", "信箱重複，請重新輸入");
		}
		if (mService.existsByPhone(member.getPhone()) == true) {
			result.rejectValue("userId", "", "電話重複，請重新輸入");
		}
//	錯誤訊息顯示
		if (result.getFieldErrorCount() > 0) {
			System.out.println("出錯了");
			for (FieldError error : result.getFieldErrors()) {
				System.out.println(error.getField() + ":" + error.getDefaultMessage());
			}
//  錯誤的話，回傳註冊頁面
			return "member/register";
		}
//	否則儲存會員資料        
//  儲存會員資料
		mService.save(member);
		System.out.println("儲存" + member);
		model.addAttribute("login", member);
		return "redirect:/member/loginForm";

	}

//    修改個人資料
//    @PostMapping("/personData/Upload")
//    public String showPersonData(Model model) {
//        mService.findByUserId(null)
//        model.addAttribute("member",)
//    }

	
}
