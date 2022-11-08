//package com.ispan.demo.memeber.registor.security.constants;
//
//public final class SecurityConstants {
//
//	private SecurityConstants() {
//		throw new IllegalStateException("Cannot create instance of static contant class");
//	}
//	/*
//	 *Json Wed Token = Header + payload + signature
//	 *
//	 * ** header **
//	 * Authorization Bearer
//	 * ** payload **
//	 * claim聲明內容
//	 * ** signature **
//	 *  Header+payload+secretKey -> hash
//	 * 
//	 */
//	
//	//header
//	public static final String TOKEN_HEADER = "Authorization";
//	public static final String TOKEN_PREFIX = "Bearer";
//	
//	
//	//	用於登入的url
//	public static final String AUTH_LOGIN_URL="/member/login";
//	//JWT密鑰，生成地址：http://www.allkeysgenerator.com/
//    public static final String JWT_SECRET_KEY = "p2s5v8y/B?E(H+MbQeThVmYq3t6w9z$C&F)J@NcRfUjXnZr4u7x!A%D*G-KaPdS";
//    public static final String TOKEN_TYPE = "JWT";
//    public static final String TOKEN_ROLE_CLAIM = "role";
//    public static final String TOKEN_ISSUER = "security";
//    public static final String TOKEN_AUDIENCE = "security-all";
//    //當Remember是false時，token有效時間為 2 hr
//    public static final long EXPIRATION_TIME = 60 * 60 * 2L;
//    //當Remember是true時，token 有效時間 7 days
//    public static final long EXPIRATION_REMEMBER_TIME = 60 * 60 * 24 * 7L;
//}
