package com.ispan.demo.memeber.login.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ispan.demo.memeber.login.model.Login;
import com.ispan.demo.memeber.registor.model.member.Member;


@Controller

@SessionAttributes({"LoginOK"}) 
public class LogoutController {
	@GetMapping("/logout")
	public String logout(HttpSession session,  Model model, SessionStatus status,
			RedirectAttributes redirectAtt
			) {
		String name = "";
		System.out.println("Logout");
		Login login = (Login)model.getAttribute("LoginOK");
//		Member login = (Member)model.getAttribute("LoginOK");
		if (login != null) {
			name = login.getUserId();
		} else {
			name = "訪客";
		}
		String farewellMessage = name + "您已登出，期待您再次蒞臨本網站";
		redirectAtt.addFlashAttribute("FlashMSG_farewell", farewellMessage);
		// 登出時執行下列兩敘述
		status.setComplete();		// 移除@SessionAttributes({"LoginOK"}) 標示的屬性物件
		session.invalidate();		// 此敘述不能省略		
		return "redirect:/";		// 跳轉回http://localhost:8080/Context_Path/
//		return "redirect: /";		// 跳轉回http://localhost:8080/
	}
}
