//package com.ispan.demo.memeber.registor.security.utils;
//
//import java.util.Optional;
//
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.security.core.userdetails.UserDetails;
//
////獲取登入的用戶名
//public class SecurityUtil {
//
//	private SecurityUtil() {
////		該異常表示，當前對客戶端的響應已經結束，不能再響應已經結束（或說消亡）後再向客戶端（實際上是緩衝區）輸出任何內容。）
//		throw new IllegalStateException("cannot create instance of static util class");
//	}
//
//	// 獲取用戶登入訊息
//	public static Optional<String> getCurrentUserLogin() {
//		// 取得個人已驗證的權限
//		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//		//如果在UserDetails找到權限
//		if (principal instanceof UserDetails) {
//			UserDetails userDetails = (UserDetails) principal;
//		//回傳姓名
//			return Optional.ofNullable(userDetails.getUsername());
//		} else if (principal instanceof String) {
//			return Optional.ofNullable((String) principal);
//		}
//		return null;
//	}
//}
