//package com.ispan.demo.memeber.registor.security.config;
//
//import org.springframework.security.config.annotation.SecurityConfigurerAdapter;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.web.DefaultSecurityFilterChain;
//import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
//
//public class jwtConfig extends SecurityConfigurerAdapter<DefaultSecurityFilterChain, HttpSecurity> {
//
//	private JwtAuthorizationFilter authorizationFilter;
//
//	public jwtConfig(JwtAuthorizationFilter authorizationFilter) {
//		this.authorizationFilter = authorizationFilter;
//	}
//
//	@Override
//	public void configure(HttpSecurity builder) throws Exception {
//		builder.addFilterBefore(authorizationFilter, UsernamePasswordAuthenticationFilter.class);
//	}
//
//}
