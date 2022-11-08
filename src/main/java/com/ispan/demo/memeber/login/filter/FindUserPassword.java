package com.ispan.demo.memeber.login.filter;

import java.io.IOException;
import java.util.Iterator;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FindUserPassword implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		String cookiesName=" ";
		String user=" ";
		String password=" ";
		String rememberMe=" ";
		if (request instanceof HttpServletRequest && response instanceof HttpServletResponse) {
			HttpServletRequest req= (HttpServletRequest) request;
//			******* remember me ***********
			Cookie[] cookies = req.getCookies();
			if (cookies != null) {
				for (int i = 0; i < cookies.length; i++) {
					cookiesName=cookies[i].getName();
					if (cookiesName.equals("user")) {
						user=cookies[i].getValue();
					}else if (cookiesName.equals("password")){
						password= cookies[i].getValue();
					}
				}
			}
		}
	}

	
}
