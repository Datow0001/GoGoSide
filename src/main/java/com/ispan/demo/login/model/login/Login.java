package com.ispan.demo.login.model.login;

public class Login {
	String userName; // 會員姓名
	String password; // 密碼
	String invalidCredentials;
	boolean rememberMe;// 記住我

	// 建構子範圍
	public Login(String userName, String password, String invalidCredentials, boolean rememberMe) {
		super();
		this.userName = userName;
		this.password = password;
		this.invalidCredentials = invalidCredentials;
		this.rememberMe = rememberMe;
	}

	// getter&setter
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getInvalidCredentials() {
		return invalidCredentials;
	}

	public void setInvalidCredentials(String invalidCredentials) {
		this.invalidCredentials = invalidCredentials;
	}

	public boolean isRememberMe() {
		return rememberMe;
	}

	public void setRememberMe(boolean rememberMe) {
		this.rememberMe = rememberMe;
	}

	@Override
	public String toString() {
		return "loginRepository [userName=" + userName + ", password=" + password + ", invalidCredentials="
				+ invalidCredentials + ", rememberMe=" + rememberMe + "]";
	}

}
