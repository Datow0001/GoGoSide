//package com.ispan.demo.memeber.registor.security.utils;
//
//import java.util.Collections;
//import java.util.Date;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//import java.util.Objects;
//import java.util.stream.Collectors;
//
//import javax.xml.bind.DatatypeConverter;
//
//import org.openqa.selenium.Keys;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.boot.autoconfigure.neo4j.Neo4jProperties.Authentication;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//
//import com.ispan.demo.memeber.registor.security.constants.SecurityConstants;
//import com.ispan.demo.memeber.registor.security.constants.UserRoleConstants;
//
//import io.jsonwebtoken.Claims;
//import io.jsonwebtoken.ExpiredJwtException;
//import io.jsonwebtoken.Jwts;
//import io.jsonwebtoken.MalformedJwtException;
//import io.jsonwebtoken.SignatureAlgorithm;
//import io.jsonwebtoken.UnsupportedJwtException;
//
//public class JwtUtil {
//
//	// 工具類，用於生成、解析、驗證token
//	private static final Logger logger = LoggerFactory.getLogger(JwtUtil.class);
//	private static final byte[] secretKey = DatatypeConverter.parseBase64Binary(SecurityConstants.JWT_SECRET_KEY);
//	//header
//	public static final String TOKEN_HEADER = "Authorization";
//	public static final String TOKEN_PREFIX = "Bearer";
//	//	用於登入的url
//	public static final String AUTH_LOGIN_URL="/member/login";
//	//JWT密鑰，生成地址：http://www.allkeysgenerator.com/
//    public static final String JWT_SECRET_KEY = "GoGoSide is good website";
//    public static final String TOKEN_TYPE = "JWT";
//    public static final String TOKEN_ROLE_CLAIM = "role";
//    public static final String TOKEN_ISSUER = "security";
//    public static final String TOKEN_AUDIENCE = "security-all";
//    //當Remember是false時，token有效時間為 2 hr
//    public static final long EXPIRATION_TIME = 60 * 60 * 2L;
//    //當Remember是true時，token 有效時間 7 days
//    public static final long EXPIRATION_REMEMBER_TIME = 60 * 60 * 24 * 7L;
//
////簽發JWT
//	public static String generateToken(HashMap<String, String> userDetail) {
//		// 記住我的時間(false 2 hr,true 7 day)
//		Map<String, Object> claims=new HashMap<>();
//		claims.put("username", userDetail.get("username"));
//		return Jwts.builder()
//				   .setClaims(claims)
//				   .setExpiration(new Date(System.currentTimeMillis() + expiration * 1000)) // 效期
//				   .signWith(Keys.hmacShaKeyFor(secretKey), SignatureAlgorithm.ES256) // 使用密鑰登入(ES256類型)
//				   .compact(); // 生成token(1.編碼header和payload 2.生成簽名 3.拼接字串);
//				   
//		long expiration = roleDto.isRememberMe() ? SecurityConstants.EXPIRATION_REMEMBER_TIME
//				: SecurityConstants.EXPIRATION_TIME;
//
//		Map<String, Object> map = new HashMap<>();
//		map.put("user", roleDto);
//		// 生成token
//		String token = Jwts.builder()// 創建JWT對象(token)
//				// Header
//				.setHeaderParam("typ", SecurityConstants.TOKEN_TYPE)// 設置標頭TOKEN_TYPE = "JWT"
//				.setClaims(map) 
//				.setSubject(roleDto.getUserId()) // 設置主題(聲明訊息)
//				.setIssuer(SecurityConstants.TOKEN_ISSUER) // TOKEN_ISSUER = "security"
//				.setIssuedAt(new Date()) // 設生成日期
//				.setAudience(SecurityConstants.TOKEN_AUDIENCE)
//		return token;
//	}
//
////	解析token
//	private static Claims getTokenBody(String token) {
//		return Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token).getBody();
//	}
//
//	
////	取得用戶訊息
//	public static Authentication getAuthentication(String token) {
//        Claims claims = getTokenBody(token);
//        // 获取用户角色字符串
//        List<String> roles = (List<String>)claims.get(SecurityConstants.TOKEN_ROLE_CLAIM);
//        List<SimpleGrantedAuthority> authorities =
//                Objects.isNull(roles) ? Collections.singletonList(new SimpleGrantedAuthority(UserRoleConstants.ROLE_USER)) :
//                        roles.stream()
//                                .map(SimpleGrantedAuthority::new)
//                                .collect(Collectors.toList());
//        // 获取用户名
//        String userName = claims.getSubject();
//
//        return new UsernamePasswordAuthenticationToken(userName, token, authorities);
//
//    }
//
//	// 驗證token是否有效
//	  public static boolean validateToken(String token) {
//	        try {
//	            getTokenBody(token);
//	            return true;
//	        } catch (ExpiredJwtException e) {
//	            logger.warn("Request to parse expired JWT : {} failed : {}", token, e.getMessage());
//	        } catch (UnsupportedJwtException e) {
//	            logger.warn("Request to parse unsupported JWT : {} failed : {}", token, e.getMessage());
//	        } catch (MalformedJwtException e) {
//	            logger.warn("Request to parse invalid JWT : {} failed : {}", token, e.getMessage());
//	        } catch (IllegalArgumentException e) {
//	            logger.warn("Request to parse empty or null JWT : {} failed : {}", token, e.getMessage());
//	        }
//	        return false;
//	    }

//}
