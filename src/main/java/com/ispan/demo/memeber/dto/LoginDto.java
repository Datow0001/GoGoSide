//package com.ispan.demo.memeber.dto;
//
//import java.util.Collection;
//import java.util.List;
//import java.util.stream.Collectors;
//
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//
//import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
//
//public class LoginDto extends MemberResponse implements UserDetails {
//	private static final long serialVersionUID = -5903399199316830506L;
//	private String userId;
//	private String userPassword;
//	private boolean rememberMe = false;
//	
//	public String getUserId() {
//		return userId;
//	}
//
//	public void setUserId(String userId) {
//		this.userId = userId;
//	}
//
//	public String getUserPassword() {
//		return userPassword;
//	}
//
//	public void setUserPassword(String userPassword) {
//		this.userPassword = userPassword;
//	}
//
//	public boolean isRememberMe() {
//		return rememberMe;
//	}
//
//	public void setRememberMe(boolean rememberMe) {
//		this.rememberMe = rememberMe;
//	}
//
//	
//	/*
//	 *  return權限
//	 */
//	@Override
//	public Collection<? extends GrantedAuthority> getAuthorities() {
////		List<GrantedAuthority> grantedAuthorities=getRoles().stream().map(roleName-> new SimpleGrantedAuthority("ROLE_"+roleName)).collect(Collectors.toList());
//		return grantedAuthorities;
//	}
//
//	@Override
//	public String getPassword() {
//		return userPassword;
//	}
//	@Override
//	public String getUsername() {
//		return userId;
//	}
//
//	//是否未過期
//	@Override
//	public boolean isAccountNonExpired() {
//		return true;
//	}
//
////	是否未鎖定
//	@Override
//	public boolean isAccountNonLocked() {
//		return true;
//	}
//
//	//憑證是否未過期
//	@Override
//	public boolean isCredentialsNonExpired() {
//		return true;
//	}
//
//	@Override
//	public boolean isEnabled() {
//		return true;
//	}
//
//}
