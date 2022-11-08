package com.ispan.demo.memeber.login.model;

import javax.validation.constraints.NotBlank;

public class Login {
	@NotBlank(message = "請輸入帳號")
	private String userId;
	@NotBlank(message = "請輸入密碼")
	private String password;
	private boolean rememberMe;	

	public Login() {}

	public Login(@NotBlank(message = "請輸入帳號") String userId, @NotBlank(message = "請輸入密碼") String password,boolean rememberMe) {
		super();
		this.userId = userId;
		this.password = password;
		this.rememberMe = rememberMe;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	
	public boolean isRememberMe() {
		return rememberMe;
	}

	public void setRememberMe(boolean rememberMe) {
		this.rememberMe = rememberMe;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}


	}


