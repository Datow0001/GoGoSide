package com.ispan.demo.memeber.login.interceptor;

import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;

import com.ispan.demo.memeber.login.model.Login;

public class LoginHandlerInterceptor implements HandlerInterceptor {
	/*
	 * 登入檢查
	 */

	String servletPath;
	String contextPath;
	 List<String> url = Arrays.asList("/member/memberCenter");
	@Override
	// 目標方法執行前
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {

		boolean byPass = true;
		boolean isRequestedSessionIdValid = false;
		servletPath = request.getServletPath();
		contextPath = request.getContextPath();
		isRequestedSessionIdValid = request.isRequestedSessionIdValid();
//		requestURI = contextPath + servletPath + pathInfo
//		                java     +  gogoside   + index.jsp
		if (mustLogin()) {
			if (cheakLogin(request)) {
				byPass = true;
			} else {
				HttpSession session = request.getSession();
				if (!isRequestedSessionIdValid) {
					session.setAttribute("timeOut", "使用逾期，請重新登入");
				} else {
					System.out.println("LoginHandlerInterceptor#preHandle,servletPath=" + servletPath);
					System.out.println("LoginHandlerInterceptor#preHandle,session=" + session);
					session.setAttribute("servletPath", servletPath);
				}
				response.sendRedirect(contextPath + "/member/loginForm");
				byPass = false;
			}
		} else {
			byPass=true;
		}
		return byPass;
		
	}

	// 判斷session內有無loginOK的識別字串
	private boolean cheakLogin(HttpServletRequest request) {
		HttpSession session = request.getSession();
		Login loginToken = (Login) session.getAttribute("LoginOK");
		if (loginToken == null) {
//			session.setAttribute("servletPath", servletPath);
			return false;
		} else {
//			System.out.println(loginToken.getUserId());
			return true;
		}
	}

//		如果請求servletPath的前導字是以某必須登入才能使用的資源路徑，則必須登入
	private boolean mustLogin() {
//		String servletPath = request.getServletPath();
		boolean login = false;
//		System.out.println(servletPath);
			if (servletPath.contains("/personForm")||servletPath.contains("Back")||servletPath.contains("forum/add")) {
				
				login = true;
			
			}
			
		return login;
	}
}
