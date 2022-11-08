package com.ispan.demo.memeber.login.util;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.ispan.demo.memeber.login.interceptor.LoginHandlerInterceptor;
@Configuration
public class WebMvcConfig implements WebMvcConfigurer{

	//註冊攔截器
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new LoginHandlerInterceptor())
				.addPathPatterns("/**");
//				.excludePathPatterns("/index","/","/loginForm");
		
	}

}
