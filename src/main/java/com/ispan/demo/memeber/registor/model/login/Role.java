//package com.ispan.demo.memeber.registor.model.login;
//
//import java.io.Serializable;
//
//public class Role implements Serializable {
//	private static final long serialVersionUID = 1L;
//	String userId; // 會員帳號
//	String password; // 密碼
//	String mail;
//	String description;
//	String invalidCredentials;
//	boolean rememberMe;// 記住我
//	public Role(String userId, String password, String mail, String description, String invalidCredentials,
//			boolean rememberMe) {
//		super();
//		this.userId = userId;
//		this.password = password;
//		this.mail = mail;
//		this.description = description;
//		this.invalidCredentials = invalidCredentials;
//		this.rememberMe = rememberMe;
//	}
//	public String getUserId() {
//		return userId;
//	}
//	public void setUserId(String userId) {
//		this.userId = userId;
//	}
//	public String getPassword() {
//		return password;
//	}
//	public void setPassword(String password) {
//		this.password = password;
//	}
//	public String getMail() {
//		return mail;
//	}
//	public void setMail(String mail) {
//		this.mail = mail;
//	}
//	public String getDescription() {
//		return description;
//	}
//	public void setDescription(String description) {
//		this.description = description;
//	}
//	public String getInvalidCredentials() {
//		return invalidCredentials;
//	}
//	public void setInvalidCredentials(String invalidCredentials) {
//		this.invalidCredentials = invalidCredentials;
//	}
//	public boolean isRememberMe() {
//		return rememberMe;
//	}
//	public void setRememberMe(boolean rememberMe) {
//		this.rememberMe = rememberMe;
//	}
//	public static long getSerialversionuid() {
//		return serialVersionUID;
//	}
//	@Override
//	public String toString() {
//		return "Role [userId=" + userId + ", password=" + password + ", mail=" + mail + ", description=" + description
//				+ ", invalidCredentials=" + invalidCredentials + ", rememberMe=" + rememberMe + ", getUserId()="
//				+ getUserId() + ", getPassword()=" + getPassword() + ", getMail()=" + getMail() + ", getDescription()="
//				+ getDescription() + ", getInvalidCredentials()=" + getInvalidCredentials() + ", isRememberMe()="
//				+ isRememberMe() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()="
//				+ super.toString() + "]";
//	}
//
//	}
