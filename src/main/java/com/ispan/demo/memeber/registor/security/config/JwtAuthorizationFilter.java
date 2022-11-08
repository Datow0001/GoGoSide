//package com.ispan.demo.memeber.registor.security.config;
//
//import java.io.IOException;
//
//import javax.servlet.FilterChain;
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.validation.constraints.NotNull;
//
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
//import org.springframework.util.StringUtils;
//
//import com.ispan.demo.memeber.registor.security.constants.SecurityConstants;
//import com.ispan.demo.memeber.registor.security.utils.JwtUtil;
//
//public class JwtAuthorizationFilter extends BasicAuthenticationFilter {
//	public JwtAuthorizationFilter(AuthenticationManager authenticationManager) {
//		super(authenticationManager);
//	}
//
////	從Http請求中獲取token
//	private String getTokenHttpRequest(HttpServletRequest httpServletRequest) {
//		String authorization = httpServletRequest.getHeader(SecurityConstants.TOKEN_HEADER);
//		if (authorization == null || !authorization.startsWith(SecurityConstants.TOKEN_PREFIX)) {
//			return null;
//		}
//		return authorization.replace(SecurityConstants.TOKEN_PREFIX, "");
//	}
//
//	@Override
//	protected void doFilterInternal(@NotNull HttpServletRequest httpServletRequest,
//			@NotNull HttpServletResponse httpServletResponse, @NotNull FilterChain filterChain)
//			throws ServletException, IOException {
//		String token = this.getTokenHttpRequest(httpServletRequest);
//		if (StringUtils.hasText(token) && JwtUtil.validateToken(token)) {
//			// 获取认证信息
//			Authentication authentication = JwtUtil.getAuthentication(token);
//			// 将认证信息存入 Spring 安全上下文中
//			SecurityContextHolder.getContext().setAuthentication(authentication);
//		}
//		// 放行请求
//		filterChain.doFilter(httpServletRequest, httpServletResponse);
//
//	}
//
//	/**
//	 * 从 HTTP 请求中获取 token
//	 *
//	 * @param request HTTP 请求
//	 * @return 返回 token
//	 */
//	private String getTokenFromHttpRequest(HttpServletRequest request) {
//		String authorization = request.getHeader(SecurityConstants.TOKEN_HEADER);
//		if (authorization == null || !authorization.startsWith(SecurityConstants.TOKEN_PREFIX)) {
//			return null;
//		}
//		// 去掉 token 前缀
//		return authorization.replace(SecurityConstants.TOKEN_PREFIX, "");
//	}
//
//}
