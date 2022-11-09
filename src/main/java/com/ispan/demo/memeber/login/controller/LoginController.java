package com.ispan.demo.memeber.login.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.ispan.demo.memeber.login.model.Login;
import com.ispan.demo.memeber.registor.model.member.Member;
import com.ispan.demo.memeber.registor.service.MemberService;


@Controller
@RequestMapping("/member")
@SessionAttributes({"LoginOK","servletPath"})
public class LoginController {
	
	@Autowired
	MemberService mService;
	
	@GetMapping("/loginForm")
	public String login00(HttpServletRequest request,Model model,
							@CookieValue(value = "userId",defaultValue = "") String userId,
							@CookieValue(value = "password",defaultValue = "") String password,
							@CookieValue(value = "rememberMe",defaultValue = "false") Boolean rememberMe
							) {
		Login login = new Login(userId,password,rememberMe);
		model.addAttribute("login",login);
		return "member/login";
	}
	
	
	@PostMapping("/loginForm")
	public String doLogin(@Valid 
						  @ModelAttribute("login") Login login, 
						  BindingResult bindingResult, 
						  Model model,
						  HttpServletRequest request,
						  HttpServletResponse response) {
	//  輸入驗證（自定義、預設）	
	
//		Member user=mService.cheakIdPassword(login.getUserId(), login.getPassword());
		Login user=mService.cheakIdPassword(login.getUserId(), login.getPassword());
		Member member = mService.findByUserId(login.getUserId());
		if (user==null) {
			bindingResult.rejectValue("password", null, "請輸入正確帳號密碼");
		}
	    if (bindingResult.getFieldErrorCount() > 0) {
			System.out.println("出錯了");
			for (FieldError error : bindingResult.getFieldErrors()) {
				System.out.println(error.getField() + ":" + error.getDefaultMessage());
			}
			return "member/login";
		}else {		
			HttpSession session = request.getSession();
			processCookeies(login, request, response);
			String nextPath=(String)model.getAttribute("servletPath");
//			String nextPath=(String)session.getAttribute("servletPath");
			System.out.println("nextPath:"+nextPath);
			model.addAttribute("LoginOK",user);
			if(member.getRoles()==null) {}
			else if(member.getRoles().equals("admin")) {
				session.setAttribute("IsAdmin",member);
				
			}
			if(nextPath==null) {
				nextPath="/";
			}
			return "redirect:"+nextPath;
		}
	}


	private void processCookeies(Login login,HttpServletRequest request,HttpServletResponse response) {
		Cookie cookieUser;
		Cookie cookiePassword;
		Cookie cookieRememberMe = null;
		String userId=login.getUserId();
		String password=login.getPassword();
		if (login.isRememberMe()) {
			cookieUser = new Cookie("userId",userId);
			cookieUser.setMaxAge(7*24*60*60);	// 7天
			cookieUser.setPath(request.getContextPath());
			
			cookiePassword = new Cookie("password",password);
			cookiePassword.setMaxAge(7*24*60*60);	// 7天
			cookiePassword.setPath(request.getContextPath());
			
			cookieRememberMe = new Cookie("rememberMe", "true");
			cookieRememberMe.setMaxAge(7*24*60*60);	// 7天
			cookieRememberMe.setPath(request.getContextPath());
		}else {//記住我沒有打勾
			cookieUser = new Cookie("userId",userId);
			cookieUser.setMaxAge(0);	// 7天
			cookieUser.setPath(request.getContextPath());
			
			cookiePassword = new Cookie("password",password);
			cookiePassword.setMaxAge(0);	// 7天
			cookiePassword.setPath(request.getContextPath());
			
			cookieRememberMe = new Cookie("rememberMe", "true");
			cookieRememberMe.setMaxAge(0);	// 7天
			cookieRememberMe.setPath(request.getContextPath());
		}
		response.addCookie(cookieUser);
		response.addCookie(cookiePassword);
		response.addCookie(cookieRememberMe);
	}
	
}
